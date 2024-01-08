package com.dsalgo.arrays.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * check whether unique elements can be found by visiting all the rooms.
 *
 * 1            // number of test cases
 * 3 2          // 3 rooms, need to find 2 unique chocolates
 * 1 kit        // 1 chocolate
 * 2 fiv kit    // 2 chocolates
 * 1 kit        // 1 chocolate
 *
 * @author Srinath.Rayabarapu
 */
public class CheckUniqueChocolatesInAllRoomsMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            String[] temp = br.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int K = Integer.parseInt(temp[1]);
            int MAXSIZE = 105;
            String[][] chocolates = new String[MAXSIZE][MAXSIZE];
            int[] p = new int[MAXSIZE];
            for (int i = 0; i < N; i++) {
                String[] arr_chocolates = br.readLine().split(" ");
                p[i] = Integer.parseInt(arr_chocolates[0]);
                for (int j = 0; j < p[i]; j++) {
                    chocolates[i][j] = arr_chocolates[j + 1];
                }
            }
            String out_ = solve(N, K, p, chocolates);
            wr.println(out_);
        }
        wr.close();
        br.close();

    }

    /**
     * prints whether unique chocolates can found by visiting all rooms and counting all chocolates.
     *
     * @param numberOfRooms
     * @param uniqueChocolates
     * @param chocolatesCountInRoom
     * @param chocolatesMatrix
     * @return
     */
    static String solve(int numberOfRooms, int uniqueChocolates, int[] chocolatesCountInRoom, String[][] chocolatesMatrix) {

        Set<String> set = new HashSet<>();

        for (int i = 0; i < numberOfRooms; i++) { //visiting each room
            for (int j = 0; j < chocolatesCountInRoom[i]; j++) { //number of chocolates
                set.add(chocolatesMatrix[i][j]);
            }
        }

        System.out.println(set.size() == uniqueChocolates);

        if(set.size() == uniqueChocolates){
            return "Yes";
        } else{
            return "No";
        }

    }

}
