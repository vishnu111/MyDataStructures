package com.hackerrank;
import java.util.regex.*;
import java.util.regex.Pattern;

public class RegxPractice {
    public static void main(String args[]) {
        String s = "(?=.*[A-Z]).+$";
        Pattern p = Pattern.compile(s);
        String m = "ghjj";
        Matcher ma = p.matcher(m);
        System.out.print(ma.matches());

    }
}
