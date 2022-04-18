package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SubStrCount {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long count=0;

        for(int i=0; i < n; i++){
            long check1=1, initial=0,counter=0;
            boolean test=true,test2=true, test3=true;

            if(i>0 && s.charAt(i-1)==s.charAt(i)){
                test2=false;
            }
            char start=s.charAt(i);
         //  System.out.println(" Outer for loop with i "+i);
            for(int j=i; j < n-1 ; j++){
              //  System.out.println(" inner for loop with j "+j);
                if(s.charAt(j)==s.charAt(j+1) && test2){
                    System.out.println("entered with i "+i );
                    initial++;
                }
                else{
                    if(j!=i && test2){
                        long x=initial+1;
                        count = count+(x*(x+1)/2)-x;
                        //test=false;
                    }
                }

                if(initial==n-1 && test2){
                    long x=initial+1;
                    count = count+(x*(x+1)/2)-x;
                }
               //System.out.println("with j "+test2);
                if(j-i>=2 && (j-i)%2==0 && test3 && test2){
                    System.out.println("Entered in test3");
                    if(start==s.charAt(i) && start==s.charAt(j-i/2)){
                        count++;
                    }
                }
                if((s.charAt(j) == s.charAt(j+1)) && test3){
                    counter++;
                    if(counter>2){
                        test3=false;
                    }
                }

            }
        }


        return count+n;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
   /*     BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();*/

        System.out.println(substrCount(7, "abcbaba"));
/*
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
}
