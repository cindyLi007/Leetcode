package com.google.string;

public class SimilarRGBColor {
    public String similarRGB(String color) {
        return "#" + f(color.substring(1, 3)) + f(color.substring(3, 5)) +
                f(color.substring(5));
    }

    private String f(String color) {
        int q = Integer.parseInt(color, 16);
        q = q/17 + (q%17>8 ? 1 : 0);
        // Conversion 'X' - The result is formatted as a hexadecimal integer, uppercase, 'x' is lowercase
        return String.format("%02x", q*17);
    }
}
