package com.dsalgo.arrays;

import java.io.IOException;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

/**
 * Arrays practice problem
 * <p>
 * https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 *
 * @author Srinath.Rayabarapu
 */
public class ArrayManipulationMain {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int arrayLength, int[][] queries) {
        long[] array = new long[arrayLength];

        Clock clock = Clock.systemDefaultZone();
        Instant instant = clock.instant();
        Date from = Date.from(instant);//can form legacy Date object
        System.out.println(from);

        for (int i = 0; i < queries.length; i++) {

            int fromIndex = queries[i][0];
            int toIndex = queries[i][1];
            int value = queries[i][2];

            for (int k = fromIndex - 1; k <= toIndex - 1; k++) {
                array[k] = array[k] + value;
            }
        }

        Date to = Date.from(clock.instant());//can form legacy Date object
        System.out.println(to);

        long greater = -1;

        for (int i = 0; i < array.length; i++) {
            if (greater < array[i]) {
                greater = array[i];
            }
        }

        Date later = Date.from(clock.instant());//can form legacy Date object
        System.out.println(later);

        return greater;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}
