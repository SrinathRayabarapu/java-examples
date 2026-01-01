package com.sri.strings.random;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for generating random English sentences.
 * 
 * <p>This class generates grammatically simple sentences following the pattern:
 * <b>Article + Noun + Verb + Preposition + Article + Noun</b></p>
 * 
 * <h3>Example Output:</h3>
 * <ul>
 *   <li>"The boy drove to a girl."</li>
 *   <li>"One dog jumped from some town."</li>
 *   <li>"A car ran over the boy."</li>
 * </ul>
 * 
 * <h3>Usage:</h3>
 * <pre>{@code
 * RandomSentences generator = new RandomSentences();
 * 
 * // Get a list of 10 random sentences
 * List<String> sentences = generator.getOf(10);
 * 
 * // Or generate and display
 * generator.formSentences();
 * generator.showSentences();
 * }</pre>
 * 
 * <h3>Use Cases:</h3>
 * <ul>
 *   <li>Generating test data for string processing</li>
 *   <li>Creating sample content for UI testing</li>
 *   <li>Educational demonstrations of sentence structure</li>
 * </ul>
 * 
 * @author Srinath.Rayabarapu
 */
public class RandomSentences {

    /** Array of articles for sentence construction. */
    private String[] article = {"the", "a", "one", "some"};
    /** Array of nouns for sentence construction. */
    private String[] noun = {"boy", "girl", "dog", "town", "car"};
    
    /** Array of verbs for sentence construction. */
    private String[] verb = {"drove", "jumped", "ran", "walked", "skipped"};
    
    /** Array of prepositions for sentence construction. */
    private String[] prepo = {"to", "from", "over", "under", "on"};
    
    /** Index trackers for random word selection. */
    private int a_index, n_index, v_index, p_index, j;
    
    /** Array to store generated sentences. */
    private String[] s = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    
    /** Default number of sentences to generate. */
    private int defaultSize = 10;

    /**
     * Generates a specified number of random sentences.
     *
     * @param size the number of sentences to generate
     * @return list of randomly generated sentences
     */
    public List<String> getOf(int size){
        return formSentences(size);
    }

    /**
     * Forms sentences using the default size (10).
     * 
     * <p>Use {@link #showSentences()} to display the generated sentences.</p>
     */
    public void formSentences(){
        formSentences(defaultSize);
    }

    /**
     * Forms a specified number of random sentences.
     * 
     * <p>Each sentence follows the pattern:
     * Article + Noun + Verb + Preposition + Article + Noun</p>
     *
     * @param size the number of sentences to generate
     * @return list of generated sentences (lowercase, no punctuation)
     */
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

    /**
     * Displays the previously generated sentences to standard output.
     * 
     * <p>Sentences are displayed with:</p>
     * <ul>
     *   <li>First letter capitalized</li>
     *   <li>Period at the end</li>
     * </ul>
     * 
     * <p>Call {@link #formSentences()} or {@link #formSentences(int)} first.</p>
     */
    public void showSentences() {
        for (int i = 0; i < defaultSize; i++) {
            System.out.print(Character.toUpperCase(s[i].charAt(0)));
            for (int j = 1; j < s[i].length(); j++)
                System.out.print(s[i].charAt(j));
            System.out.println(".");
        }
    }

}
