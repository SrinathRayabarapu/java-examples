package com.dsalgo.scaler.arrays.day14;

/**
 * Given a binary string A. It is allowed to do at most one swap between any 0 and 1.
 * Find and return the length of the longest consecutive 1’s that can be achieved.
 */
public class LengthOfLongestConsecutiveOnes {

    public static void main(String[] args) {
        String input = "111011101";

        int onesCount = totalOnesCount(input);

        int length = calculateLongestSubString(input, onesCount);
        System.out.println("length = " + length);
    }

    private static int totalOnesCount(String input) {
        int count = 0;
        for (char c : input.toCharArray()){
            if(c == '1'){
                count++;
            }
        }
        return count;
    }

    private static int calculateLongestSubString(String input, int totalOnesCount) {

        if(totalOnesCount == 0){
            return 0;
        }

        if(totalOnesCount == input.length()){
            return totalOnesCount;
        }

        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '0'){

                //find left 1's count
                int leftIndex = i-1;
                int leftOnesCount = 0;
                while (0 <= leftIndex){
                    if(input.charAt(leftIndex) == '1'){
                        leftOnesCount++;
                    } else {
                        break;
                    }
                    leftIndex--;
                }

                //find right 1's count
                int rightIndex = i+1;
                int rightOnesCount = 0;
                while (rightIndex < input.length()) {
                    if(input.charAt(rightIndex) == '1'){
                        rightOnesCount++;
                    } else {
                        break;
                    }
                    rightIndex++;
                }

                // if left + right < totalOnesCount then assign to a max variable
                if(leftOnesCount + rightOnesCount < totalOnesCount){
                    maxLength = Math.max(maxLength, leftOnesCount + rightOnesCount + 1);
                } else {
                    maxLength = Math.max(maxLength, leftOnesCount + rightOnesCount);
                }
            } // if ends
        } // for ends
        return maxLength;
    }

}