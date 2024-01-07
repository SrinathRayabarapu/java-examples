package com.core.java8.lambda.purefunction;

import com.util.LogUtil;

/**
 * The output of the pure function only depends on
 * a) it's input parameter
 * b) it's internal algorithm
 *
 * A pure function doesn't have any side effects. The output is always same when passed same input params
 *
 * Pure functions can be used in a multi-threaded env without side effects
 *
 */
public class PureFunctionMain {

    int c;

    public static void main(String[] args) {

        var funcMain = new PureFunctionMain();
        LogUtil.info("Result is : {}", funcMain.add(funcMain.product(10, 20)));

    }

    // pure
    public int product(int a, int b){
        return a*b;
    }

    // impure
    public int add(int a){
        c += a;
        return c;
    }

}
