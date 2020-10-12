package Utility;
import DAO.Product;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.apache.log4j.Logger;

public class AppConfig {

    private static final Logger LOGGER = Logger.getLogger(AppConfig.class);
    private static final String INPUT_FILE_NAME = "input.json";
    private static final String PRICE_FILE_NAME = "priceData.json";

    public List<Product> loadInputData(){
        ObjectMapper mapper = new ObjectMapper();
        List<Product> products = null;

        try (final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(INPUT_FILE_NAME)) {

            if (inputStream != null) {
                try {

                    products = mapper.readValue(inputStream, new TypeReference<List<Product>>(){});

                } catch (IOException e) {
                    LOGGER.error("Error while building Cycle object from input file : " + e.getMessage());
                }
            }
        } catch (IOException e){
            LOGGER.error("Failed to load input file : "+ e.getMessage());
        }

        return products;
    }

    public Map<String, TreeMap<Date,Double>> loadInputPrice(){
        ObjectMapper mapper = new ObjectMapper();
        Map<String, TreeMap<Date,Double>> priceMap = new HashMap<>();

        try (final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(PRICE_FILE_NAME)) {

            if (inputStream != null) {
                try {

                    priceMap = mapper.readValue(inputStream, new TypeReference<Map<String, TreeMap<Date,Double>>>(){});

                } catch (IOException e) {
                    LOGGER.error("Error while building priceData.json into priceMap Object : " + e.getMessage());
                }
            }
        } catch (IOException e){
            LOGGER.error("Failed to load priceData.json file : "+ e.getMessage());
        }

        return priceMap;
    }
}
