package com.puzzles;

import lombok.extern.slf4j.Slf4j;

/**
 * given input 'n', print all the possible prime numbers which can be divisible
 * Ex: 12 -> 2, 2, 3
 * 20 -> 2, 2, 5
 * 15 -> 3, 5
 *
 * @EPAM
 */
@Slf4j
public class FindAllDivisiblePrimeNumbers {

    public static void main(String[] args) {
        findDivisiblePrimeNumbers(12);
    }

    private static void findDivisiblePrimeNumbers(int input) {

        int number = 2;
        StringBuilder builder = new StringBuilder();

        while(input >= 2) {
            if(isPrimeNumber(number) && (input % number == 0)) {
                builder.append(number).append(",");
                input /= number;
            } else {
                number++;
            }
        }
        log.info("Output : {}", builder);
    }

    private static boolean isPrimeNumber(int number) {

        if(number == 2) {
            return true;
        }

        boolean isDivisible = false;
        for(int i = 2; i < number/2; i++){
            if(number % i == 0){
                isDivisible = true;
                break;
            }
        }

        return !isDivisible;
    }

}
