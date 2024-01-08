package com.puzzles;

/**
 * There are 100 lights in a row that are all initially off.
 * You make 100 passes by the lights.
 * The first time through, visit every light and toggle the light (if the light is off,  on it; if it is on, off it).
 * The second time, only visit every 2nd light   (light #2, #4, #6, ...),   and toggle it.
 * The third time, visit every 3rd light   (light #3, #6, #9, ...), etc,   until you only visit the 100th light.
 *
 * Task:
 * Answer the question:   what state are the lights in after the last pass?   Which are on, which are off?
 *
 * #Hitachi
 *
 * @author Srinath.Rayabarapu
 */
public class LightBulbs100ToggleMain {

    public static void main(String[] args) {

        boolean[] lightsArray = new boolean[100];
        int passes = 100;

        for (int i = 0; i < lightsArray.length; i++) {
            for (int j = i; j < passes; j = j + i + 1) {
                lightsArray[j] = !lightsArray[j];
            }
        }

        // printing the array
        for (int i = 0; i < lightsArray.length; i++) {
            System.out.print(lightsArray[i] +",");
        }
    }

}