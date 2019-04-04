package com.ediweb.education.client.cmdl;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Logger;

import static java.lang.System.out;

public class TimeCommandHandler implements Runnable {

    private static final Logger log = Logger.getLogger(InputCommandHandler.class.getName());

    private final StringBuilder clock = new StringBuilder(32);
    private final char CR = '\r';
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss z", Locale.ENGLISH);

    @Override
    public void run() {
        clock.append(CR).append(ZonedDateTime.now().format(formatter));
        out.println(clock);
        clock.delete(0, clock.length());
    }

}
