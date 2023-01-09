import java.io.*;
import java.util.*;

public class WallsandGates {

    public static void main(String[] args) throws IOException {
        wallsAndGate();
    }
    public static void wallsAndGate() {
        // create an arraylist for current iteration
        // create an hashset <Int, Int> for storing results
        // HashSet<String, Integer> gateMap = new HashSet<String, Integer>();
        // int[3][3] counter= new int[][];
        System.out.println("hey");
        int[][] rooms= {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        int[][] gateMap = new int[rooms.length][rooms.length > 0 ? rooms[0].length : 0];
        int x_Axis = rooms.length;
        int y_Axis = rooms.length > 0 ? rooms[0].length : 0;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                Deque<String> currentItr = new ArrayDeque<String>();
                int steps = 0;
                boolean flag = true;
                if (rooms[i][j] > 0 && flag) {
                    currentItr.add(String.valueOf(i) + "/" + String.valueOf(j));

                    while (currentItr.size() != 0 && flag) {
                        String[] indexNumbers = currentItr.poll().split("/");
                        int x = Integer.valueOf(indexNumbers[0]), y = Integer.valueOf(indexNumbers[1]);
                        if (rooms[x][y] == 0) {
                            gateMap[x][y] = steps;
                            flag = false;
                            continue;
                        }
                        if (x - 1 >= 0 && rooms[x - 1][y] > 0)
                            currentItr.add(String.valueOf(x - 1) + "/" + String.valueOf(y));
                        if (y + 1 <= y_Axis - 1 && rooms[x][y + 1] > 0)
                            currentItr.add(String.valueOf(x) + "/" + String.valueOf(y + 1));
                        if (x + 1 <= x_Axis - 1 && rooms[x + 1][y] > 0)
                            currentItr.add(String.valueOf(x + 1) + "/" + String.valueOf(y));
                        if (y - 1 >= 0 && rooms[x][y - 1] > 0)
                            currentItr.add(String.valueOf(x) + "/" + String.valueOf(y - 1));

                        steps++;
                    }

                }

            }
        }
        System.out.println(Arrays.toString(gateMap));
    }
   
}