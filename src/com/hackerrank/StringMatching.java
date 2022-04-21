package com.hackerrank;
import java.io.*;
import java.util.*;
import java.util.regex.*;
class StringResult {
    public static String abbreviation(String a, String b) {
        if(Pattern.compile(b, Pattern.CASE_INSENSITIVE).matcher(a).find())
            return "YES";
        else{
            char[] charArray=a.toCharArray();
            List<Character> charList= new ArrayList<>();
            int flag=0;
            String out="NO";
            for(int i=0; i < charArray.length; i++){
                if((flag==0) &&(Character.toLowerCase(charArray[i])==b.charAt(0) || Character.toUpperCase(charArray[i])==b.charAt(0)))
                    flag=1;
                if(flag==1)
                    charList.add(charArray[i]);
            }
            int i=1;
            String s = "(?=.*[A-Z]).+$";
            Pattern p = Pattern.compile(s);
            while(i<b.length() && charList.size()>0){
                
                /**checks if the string contains the next character we are looking for, if no return "NO"*/
                if(charList.contains(b.charAt(i)) || charList.contains(Character.toLowerCase(b.charAt(i)))){
                    
                   /**getting the index of the found character, since we can consider both lower case and upper case, need to do some dirty work*/
                   int upper=charList.size();
                   if(charList.contains(Character.toLowerCase(b.charAt(i))))
                       upper=charList.indexOf(Character.toLowerCase(b.charAt(i)));
                   if(charList.contains(b.charAt(i))){
                       if(charList.indexOf(b.charAt(i))<upper)
                           upper=charList.indexOf(b.charAt(i));
                   }

                    /**Now, we will check if the charecter in between the previos matching   
                     * charecter and now found characters has any capitals in between, if "no" we will increment the i or 
                     * we will change the i to 1 to and remove the first some set of charecters till the matching char
                     */
                    if(p.matcher(charList.subList(1,upper).toString()).matches()){


                        /**our sublist contains the capital letter, so we are now initializing out sublist to start at starting position of index*/
                        if(charList.subList(1,upper).contains(b.charAt(i-1))){
                            System.out.println("Here it is");
                            charList.subList(0,charList.indexOf(b.charAt(i-1))).clear();
                        }

                        /**Intilizes the charlist to starting matching index*/
                        else{
                            charList.subList(0,upper+1).clear();
                            int lower=charList.size();
                            int flag2=0;
                            if(charList.contains(Character.toLowerCase(b.charAt(0)))) {
                                lower = charList.indexOf(Character.toLowerCase(b.charAt(0)));
                                flag2=1;
                            }
                            if(charList.contains(b.charAt(0))){
                                flag2=1;
                                if(charList.indexOf(b.charAt(0))<lower)
                                    lower=charList.indexOf(b.charAt(0));
                            }
                            if(flag2==1)
                                return "NO";
                            charList.subList(0,lower).clear();
                            System.out.println(charList.toString());
                        }


                    }
                    else{
                        charList.subList(0,upper).clear();
                        i++;
                        if(i==b.length())
                            return "YES";
                    }
                }
                else{
                    return "NO";
                }
            }
            System.out.println(charList);
        }
        return "NO";
    }

}

public class StringMatching {
    public static void main(String[] args) throws IOException {
        String a ="beFgH",b="EFG";
                System.out.println(StringResult.abbreviation(a,b));
    }
}
