package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
/**https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 */
class Result {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int makeAnagram(String a, String b) {
        char[] ac=a.toCharArray();
        char[] bc=b.toCharArray();
        List<Character> al = new ArrayList<Character>();
        List<Character> bl = new ArrayList<Character>();
        for(char ax: ac)
            al.add(ax);
        for(char bx: bc)
            bl.add(bx);
        int alsize=al.size();

        for(int i=0; i<alsize; i++){
            if(bl.contains(al.get(i))){
                System.out.println("Entered with "+i);
                bl.remove(al.get(i));
                al.remove(i);
                alsize--;
                i--;
            }
        }
        int blsize=bl.size();
        for(int i=0; i<blsize; i++){
            if(al.contains(bl.get(i))){
                System.out.println("Entered with in the second  "+i);
                al.remove(bl.get(i));
                bl.remove(i);
                blsize--;
                i--;
            }
        }
        return al.size()+bl.size();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {


      /*  String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();*/

        int res = Result.makeAnagram("cde", "abc");
        System.out.println(res);
/*
        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
