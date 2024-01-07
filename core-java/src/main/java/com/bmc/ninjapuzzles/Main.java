package com.bmc.ninjapuzzles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * bmc ninza puzzle
 *
 * @author Srinath.Rayabarapu
 */
public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    private static Map<String, Integer> scoreCard = new HashMap<>();
    private static Set<String> countrySet = new HashSet<>();

    public static void main(String[] args) {
        Main mainObj = new Main();
        boolean boolMessage = mainObj.readAndPopulateData();
        if (boolMessage) {
            LOG.info("Successfully read the input file and populated values");
        }

        LOG.info("Number of No Century countries : {}", (countrySet.size() - scoreCard.size()));

        boolMessage = mainObj.writeOutputDatatoFile();
        if (boolMessage) {
            LOG.info("Successfully written to Output file");
        }
    }

    private boolean writeOutputDatatoFile() {

        boolean result = false;
        String outputFile = "output.txt";
        FileWriter writer = null;
        try {
            writer = new FileWriter(outputFile);
            writer.write((countrySet.size() - scoreCard.size()) + "");
            result = true;
        } catch (IOException e) {
            LOG.info("IOException : ", e);
        } finally {
            if (writer != null)
                try {
                    writer.close();
                } catch (IOException ignore) {
                }
        }

        return result;
    }

    private boolean readAndPopulateData() {
        BufferedReader reader = null;
        boolean isSuccess = false;
        try {
            String inputFile = "input.txt";
            reader = new BufferedReader(new FileReader(new File(inputFile)));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(":");
                String countryName = arr[0];
                Integer score = Integer.parseInt(arr[1]);
                countrySet.add(countryName);
                populateScoreCard(countryName, score);
                isSuccess = true;
            }
        } catch (NumberFormatException | IOException e) {
            LOG.info("IOException : ", e);
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException ignore) {
            }
        }
        return isSuccess;
    }

    private void populateScoreCard(String cName, Integer score) {

        Integer existingScore = scoreCard.get(cName);
        if (existingScore != null) {
            if (existingScore > score) {
                scoreCard.put(cName, score);
            }
        } else if (score >= 100) {
            scoreCard.put(cName, score);
        }
    }

}
