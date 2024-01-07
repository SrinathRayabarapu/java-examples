package com.sri.strings.random;

import java.util.ArrayList;
import java.util.List;

public class RandomSentences {

    private String[] article = {"the", "a", "one", "some"};
    private String[] noun = {"boy", "girl", "dog", "town", "car"};
    private String[] verb = {"drove", "jumped", "ran", "walked", "skipped"};
    private String[] prepo = {"to", "from", "over", "under", "on"};
    private int a_index, n_index, v_index, p_index, j;
    private String[] s = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    private int defaultSize = 10;

    public List<String> getOf(int size){
        return formSentences(size);
    }

    public void formSentences(){
        formSentences(defaultSize);
    }

    public List<String> formSentences(int size) {
        defaultSize = size;
        List<String> returnList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            a_index = 0 + (int) (3 * Math.random());
            n_index = 0 + (int) (4 * Math.random());
            v_index = 0 + (int) (4 * Math.random());
            p_index = 0 + (int) (4 * Math.random());

            s[i] = s[i] + article[a_index];
            s[i] = s[i] + " " + noun[n_index];
            s[i] = s[i] + " " + verb[v_index];
            s[i] = s[i] + " " + prepo[p_index];

            a_index = 0 + (int) (3 * Math.random());
            n_index = 0 + (int) (4 * Math.random());

            s[i] = s[i] + " " + article[a_index];
            s[i] = s[i] + " " + noun[n_index];
            returnList.add(s[i]);
        }
        return returnList;
    }

    public void showSentences() {
        for (int i = 0; i < defaultSize; i++) {
            System.out.print(Character.toUpperCase(s[i].charAt(0)));
            for (int j = 1; j < s[i].length(); j++)
                System.out.print(s[i].charAt(j));
            System.out.println(".");
        }
    }

}
