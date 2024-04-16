package com.dsalgo.dynamicprog;

public class JumpGameMain {

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 3, 0, 0};

        canJumpToLastPosition(arr);
    }

    private static void canJumpToLastPosition(int[] arr) {
        int cur = arr[arr.length-1];
        for (int i = arr.length-1; i >= 0; i--) {
            if(i + arr[i] >= cur){
                cur = i;
            }
        }
        if(cur == 0){
            System.out.println("Can reach!");
        } else {
            System.out.println("No");
        }
    }

}