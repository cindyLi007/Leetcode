package com.google.stack;

public class ValidIpAddress {
    public String validIPAddress(String IP) {
        if (IP.contains(".")) {
            return isValidIPv4(IP) ? "IPv4" : "Neither";
        }
        return isValidIPv6(IP) ? "IPv6" : "Neither";
    }

    private boolean isValidIPv4(String IP) {
        // since split use regex, for ".", must use "\\."
        String[] ips = IP.split("\\.");
        if (ips.length!=4 ||IP.charAt(IP.length()-1) == '.') {
            return false;
        }
        for (String ip : ips) {
            if (ip.length()==0 || (ip.length()>1 && ip.startsWith("0"))) {
                return false;
            }
            try {
                Integer i = Integer.parseInt(ip);
                if (ip.startsWith("-") || i<0 || i>255) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIPv6(String IP) {
        String[] ips = IP.split(":");
        if (ips.length!=8 || IP.charAt(IP.length()-1) == ':') {
            return false;
        }
        for (String ip : ips) {
            if (ip.length()==0) {
                return false;
            }
            try {
                if (ip.startsWith("-") || ip.length()>4) {
                    return false;
                }
                Integer.parseInt(ip, 16);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}
