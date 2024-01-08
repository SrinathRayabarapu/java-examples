package com.puzzles;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Other implementation at https://github.com/excellencia/problemSolving/blob/056805df3e21015e9bce6e82984a7a8384f06595/Result.java
 *
 * #Arcesium
 */
@Slf4j
public class CalculateNAVForTheDayMain {

    public static void main(String[] args) {
        String date = "20190103";
        double totalValue = calculateNAV(date);
        log.info("Total value for the day {} is {}", date, totalValue);
    }

    /*
     * Complete the 'calculateNAV' function below.
     *
     * The function is expected to return a DOUBLE.
     * The function accepts STRING date as parameter.
     */
    public static double calculateNAV(String date) {

        double totalValueForTheDay = 0d;

        String holdingAllApi = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding";
        String PriceAllAPi = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/pricing";

        String holdingData = getAPIData(holdingAllApi);
        String priceData = getAPIData(PriceAllAPi);

        Holding[] holdings = convertToHoldingJSONArray(holdingData);
//        log.info("{}", Arrays.toString(holdings));
        Price[] prices = convertToPricingJSONArray(priceData);

        List<Holding> filteredHoldingsList = Stream.of(holdings).filter(holding -> holding.getDate().equals(date)).collect(Collectors.toList());

        log.info("Filtered holdings size : {}", filteredHoldingsList.size());

        for (Holding holding : filteredHoldingsList){
            Optional<Price> priceOptional = Stream.of(prices).filter(price -> price.getDate().equals(holding.getDate()) && price.getSecurity().equals(holding.getSecurity())).findFirst();
            if(priceOptional.isPresent()){
                log.info("Holding : {} and Price : {}", holding, priceOptional.get());
                totalValueForTheDay += holding.getQuantity() * priceOptional.get().getPrice();
            }
        }
        return totalValueForTheDay;
    }

    private static Holding[] convertToHoldingJSONArray(String holdingData) {
        Gson gson = new Gson();
        return gson.fromJson(holdingData, Holding[].class);
    }

    private static Price[] convertToPricingJSONArray(String priceData) {
        Gson gson = new Gson();
        return gson.fromJson(priceData, Price[].class);
    }

    private static String getAPIData(String holdingAllApi) {

        try {
            URL url = new URL(holdingAllApi);
            InputStream inputStream = url.openConnection().getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder stringBuilder = new StringBuilder();
            String data = "";

            while ((data = bufferedReader.readLine()) != null){
                stringBuilder.append(data);
            }

            return stringBuilder.toString();
        } catch (Exception e){
            log.error("Error reading API data : ", e);
        }

        return null;
    }

}

@ToString
@Getter
@Setter
class Price{
    private String date;
    private String security;
    private Double price;
}

@ToString
@Getter
@Setter
class Holding{
    private String date;
    private String security;
    private Integer quantity;
    private Double price;
    private String portfolio;
}
