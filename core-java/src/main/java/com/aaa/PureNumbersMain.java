package com.aaa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * given an index, print the pure number series.
 *
 * Pure number series should consists of only 4 and 5 numbers and the each number should be even.
 * Ex: 44, 55, 4444, 4554, 5555 ..
 *
 * @author Srinath.Rayabarapu
 */
public class PureNumbersMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());

            String out_ = Solve(N);
            System.out.println(out_);
        }

        wr.close();
        br.close();
    }
    static String Solve(int N){

        for (int i = 0; i < N; i++) {

            int n, b, rev = 0;
            for (int k = 0; (k <= Math.sqrt(N) && Math.sqrt(N) < Integer.MAX_VALUE); k++)
            {
                n = k;
                while (n > 0)
                {
                    b = n % 10;
                    rev = rev * 10 + b;
                    n = n / 10;
                }
                if (rev == k)
                {
                    System.out.println(rev);

                    for (int l = 0; (l < Integer.toString(k).length() && 2 < Integer.toString(k).length()); l++) {
                        if(
                                ((Integer.toString(k).charAt(l) == '4' || Integer.toString(k).charAt(l) == '5')
                                        && Integer.toString(k).charAt(l) != '1'
                                        && Integer.toString(k).charAt(l) != '2'
                                        && Integer.toString(k).charAt(l) != '3'
                                        && Integer.toString(k).charAt(l) != '6'
                                        && Integer.toString(k).charAt(l) != '7'
                                        && Integer.toString(k).charAt(l) != '8'
                                        && Integer.toString(k).charAt(l) != '9'
                                        && Integer.toString(k).charAt(l) != '0')
                        ){
                            System.out.print(k + " ");
                        }
                    }

                }
                rev = 0;
            }
        }
        return "";
    }

}
