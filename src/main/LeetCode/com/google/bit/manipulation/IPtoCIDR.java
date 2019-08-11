package com.google.bit.manipulation;

import java.util.ArrayList;
import java.util.List;

public class IPtoCIDR {
    public static List<String> ipToCIDR(String ip, int n) {
        String[] ips = ip.split("\\.");
        List<String> res = new ArrayList();
        int i = 3;
        while (n > 0) {
            int s = Integer.parseInt(ips[i]);
            int cnt = 0;
            while ((s & 0x1) == 0) {
                s >>= 1;
                cnt++;
            }
            n -= Math.pow(2, cnt);
            res.add(s + "/" + String.valueOf(32 - cnt));
            cnt = 0;
            s++;
        }
        return res;
    }

    public static void main(String... args) {
        List<String> strings = ipToCIDR("255.0.0.7", 10);
        strings.stream().forEach(o-> System.out.print(o));
    }
}
