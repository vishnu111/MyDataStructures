package com.leetcode.randomquestions;
/**https://leetcode.com/problems/climbing-stairs/solution/**/
/**We are finding the no.of possible ways to reach to the nth step by climbing either 1 step at a time or 2 steps at a time**/
public class StairCase {
    public static void main(String[] args){
        StairsA s= new StairsA();
        System.out.println(s.climbStairs(11));
    }
}


/**SOLUTION: 1**/
/**This is using BRUTE FORCE, at every step we take. we are caluculating the possible ways and adding up using recursion, the time complexity will be O(2ˆn) and space complexity will be O(n)**/
class Stairs {
    public int climbStairs(int n) {
        return climb_Stairs(0,n);
    }
    public int climb_Stairs(int c, int n){
        if(c>n){
            return 0;
        }
        if(c==n){
            return 1;
        }
        return climb_Stairs(c+1, n)+climb_Stairs(c+2,n);
    }
}


/**SOLUTION: 2**/
/**In the above problem, we are calculating the result at every step, now we are storing the result at each step in the array and returing it when called again**/
class StairsA {
    public int climbStairs(int n) {
        int memo[ ] = new int[n+1];
        return climb_Stairs(0, n, memo);
    }
    public int climb_Stairs(int c, int n, int[] memo){
        if(c>n){
            return 0;
        }
        if(c==n){
            return 1;
        }
        if(memo[c]>0){
            return memo[c];
        }
        memo[c] = climb_Stairs(c+1,n,memo)+climb_Stairs(c+2, n, memo);
        System.out.println("c is <-"+c+" and the array is "+memo[c]);
        for(int i:memo){
            System.out.print(i+" ");
        }
        System.out.println();

        return memo[c];
    }
}

/**Dynamic programing**/
class StairsD {
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        int[] node= new int[n+1];
        node[1]=1;
        node[2]=2;
        for(int i=3;i<=n;i++){
            node[i]=node[i-1]+node[i-2];
        }
        return node[n];
    }
}