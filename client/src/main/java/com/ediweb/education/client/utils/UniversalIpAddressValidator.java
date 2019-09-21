package com.ediweb.education.client.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static java.lang.System.out;

public class UniversalIpAddressValidator {
    private static Pattern VALID_IPV4_PATTERN = null;
    private static Pattern VALID_IPV6_PATTERN = null;
    private static Pattern VALID_PORT_PATTERN = null;
    private static Pattern CHECK_IPV6_ADDRESS = null;
    private static String COMMA = ",";
    private static String COLON = ":";
    private static String CLOSE_BRACKET = "]";
    private static String CLOSE_BRACKET_AND_COLON = "]:";

    private static final String ipv4Pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    private static final String ipv6Patten = "^(((?=(?>.*?::)(?!.*::)))(::)?([0-9A-F]{1,4}::?){0,5}|([0-9A-F]{1,4}:){6})(\\2([0-9A-F]{1,4}(::?|$)){0,2}|((25[0-5]|(2[0-4]|1\\d|[1-9])?\\d)(\\.|$)){4}|[0-9A-F]{1,4}:[0-9A-F]{1,4})(?<![^:]:|\\.)\\z";
    private static final String portRegex = "^(6553[0-5]|655[0-2]\\d|65[0-4]\\d\\d|6[0-4]\\d{3}|[1-5]\\d{4}|[2-9]\\d{3}|1[1-9]\\d{2}|10[3-9]\\d|102[4-9])$";
    private static final String ip6address = "^\\[([0-9a-fA-F:]*)\\]:(.*)";

    public UniversalIpAddressValidator() {
        VALID_IPV4_PATTERN = Pattern.compile(ipv4Pattern, Pattern.CASE_INSENSITIVE);
        VALID_IPV6_PATTERN = Pattern.compile(ipv6Patten, Pattern.CASE_INSENSITIVE);
        VALID_PORT_PATTERN = Pattern.compile(portRegex, Pattern.CASE_INSENSITIVE);
        CHECK_IPV6_ADDRESS = Pattern.compile(ip6address, Pattern.CASE_INSENSITIVE);
    }

    private boolean validateIP4Address(String ip) {
        return VALID_IPV4_PATTERN.matcher(ip).matches();
    }

    private boolean validateIP6Address(String ip) {
        return VALID_IPV6_PATTERN.matcher(ip).matches();
    }

    private boolean validatePortNumber(String port) {
        return VALID_PORT_PATTERN.matcher(port).matches();
    }

    private boolean isIPV6Address(String ip) {
        return ip.contains("[") && ip.contains("]");
    }

    private List<String> getSeperatedList(String data, String delimeter) {
        //return Pattern.compile(delimeter).splitAsStream(data).collect(Collectors.toList());
        return new ArrayList<String>(Arrays.asList(data.split(delimeter)));
    }

    public boolean validateIPAddress(String ips) {
        List<String> ipsList = getSeperatedList(ips, COMMA);
        List<String> ipAndPort;
        String ipAddress;
        String port;
        for (String ip : ipsList) {
            ip = ip.trim();
            if (isIPV6Address(ip)) {
                ipAndPort = getSeperatedList(ip, CLOSE_BRACKET_AND_COLON);
                if (ipAndPort.size() != 2) {
                    out.println("Invalid format. Please specify the IP addresses and port numbers again.");
                    return false;
                }
                ipAddress = ipAndPort.get(0).trim().substring(1); // to remove [
                port = ipAndPort.get(1).trim(); // to remove :

                if (!(validateIP6Address(ipAddress))) {
                    out.println("The specified IVP6 address is invalid. Please specify the IP addresses again.");
                    return false;
                }
            } else {
                ipAndPort = getSeperatedList(ip, COLON);
                if (ipAndPort.size() != 2) {
                    out.println("Invalid format. Please specify the IP addresses and port numbers again.");
                    return false;
                }
                ipAddress = ipAndPort.get(0).trim();
                port = ipAndPort.get(1).trim();

                if (!(validateIP4Address(ipAddress))) {
                    out.println("The specified IPV4 address is invalid. Please specify the IP addresses again.");
                    return false;
                }
            }
            if (!(validatePortNumber(port))) {
                out.println("The specified port is invalid. Please specify port numbers again.");
                return false;
            }
        }
        return true;
    }

}