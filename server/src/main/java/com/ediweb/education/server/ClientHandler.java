package com.ediweb.education.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientHandler implements Runnable {

    private static final Logger log = Logger.getLogger(ClientHandler.class.getName());

    private static Socket clientDialog;


    public ClientHandler(Socket client) {
        ClientHandler.clientDialog = client;
    }

    @Override
    public void run() {

        try {
            DataOutputStream out = new DataOutputStream(clientDialog.getOutputStream());
            DataInputStream in = new DataInputStream(clientDialog.getInputStream());

            while (!clientDialog.isClosed()) {
                log.info("Server reading from channel");
                String entry = in.readUTF();

                log.info("READ from clientDialog message - " + entry);
                String answer;

                Map<String, String> result = parseEntry(entry);
                if (checkAuthorization(result)) {
                    answer = "200";
                } else {
                    answer = "403";
                }

                log.info("Server try writing to channel");
//                String answer = "Server reply - " + entry + " - OK";
                out.writeUTF(answer);
                out.flush();
                log.info("Server Wrote message to clientDialog.");
                log.info("end.");
            }


        } catch (IOException e) {
            if (log.isLoggable(Level.SEVERE)) log.severe(e.getMessage());
        }

    }

    private Map<String, String> parseEntry(String entry) {
        Map<String, String> result = new HashMap<>();
        List<String> parceResult = new ArrayList<>();

        String[] splited = entry.split(",");
        Pattern pattern = Pattern.compile("[^\",{}:][0-9a-zA-Z]*");
        for(String pair : splited) {
            Matcher m = pattern.matcher(pair);
            while (m.find()) {
                String s = m.group();
                parceResult.add(s);
            }
        }

        Iterator<String> iterator = parceResult.iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            String value = null;
            if (iterator.hasNext()) {
                value = iterator.next();

            }
            result.put(key, value);
        }
        return result;
    }

    private boolean checkAuthorization(Map<String, String> result) {
        String login = "admin";
        String pass = "admin123";

        boolean isCorrect = false;
        for(Map.Entry<String, String> entry : result.entrySet()) {
            if ("login".equals(entry.getKey())) {
                if (login.equals(entry.getValue())) {
                    isCorrect = true;
                } else {
                    return false;
                }
            } else if ("password".equals(entry.getKey())) {
                if (pass.equals(entry.getValue())) {
                    isCorrect = true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return isCorrect;
    }

}
