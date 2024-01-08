package com.dsalgo.strings;

import java.util.Stack;

/**
 * string puzzle - reduce linux style paths based on conditions
 * 1. /./ denotes the current directory
 * 2. /../ denotes the parent directory
 * <p>
 * Ex: /x/./y/../z/ is equivalent to /x/z
 *
 * Idea: use stack and based on conditions push and pop
 *
 * @author Srinath.Rayabarapu
 */
public class StringPatternMain {

    public static void main(String[] args) {

        String str = "/root/";
        System.out.println(reduce(str));

        str = "/x/./y/../z/";
        System.out.println(reduce(str));

    }

    private static String reduce(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("") || parts[i].equals(".")) {
                continue;
            } else if (parts[i].equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(parts[i]);
            }
        }//for
        String res = "";
        if (stack.empty()) {
            return "/";
        } else {
            while (!stack.empty()) {
                res = "/" + stack.pop() + res;
            }
            return res;
        }

    }

}
