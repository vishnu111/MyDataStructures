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
/**https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings*/
class ResultSherlock {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        // Write your code here
        /** This question is about uniform count occurences of characters in a string, if a string has same number of charcter count occurances then we should return "YES", or else we have an option to remove any character and check all the occurences of remaninging charecters are of same count, if yes then return YES or return NO*/
        Map<Character,Integer> hm= new LinkedHashMap<Character, Integer>();

        /**converting the string to char array*/
        char[] charArray= s.toCharArray();

        /**counting each occurances of charecters in the string using LINKED HASH MAP*/
        for(char c: charArray){
            if(hm.containsKey(c))
                hm.put(c, hm.get(c)+1);
            else
                hm.put(c, 1);
        }

        /**since the values() return in Object type, we are convering that to int type with casting*/
        Object[] valueArray= hm.values().toArray();
        int[] valueInInt= new int[hm.size()];
        for(int i=0;i<hm.size();i++){
            valueInInt[i]= (int) valueArray[i];
        }

        /**sorting the int array*/
        Arrays.sort(valueInInt);

        if(valueInInt[0]==valueInInt[hm.size()-1])
            return "YES";
        else if(hm.size()>2 && (valueInInt[1]==valueInInt[hm.size()-1] || valueInInt[0]==valueInInt[hm.size()-2]) )
            return "YES";
        else
            return "NO";

    }
}

public class Sherlock {
    public static void main(String[] args) throws IOException {
      /*  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();*/

        System.out.println(ResultSherlock.isValid("abcdefghhgfedecba"));

      /*  bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
