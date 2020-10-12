package Service;

import DAO.Cycle;
import Utility.AppConfig;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class PriceService {

    private static final Logger LOGGER = Logger.getLogger(PriceService.class);

    private static final String INPUT_FILE_NAME = "input.json";
    private static final String PRICE_FILE_NAME = "priceData.json";

    public static Map<String, TreeMap<Date,Double>> priceMap;

    public PriceService(){
        priceMap = Application.appConfig.loadInputPrice();
    }

    public static void getPrice(Cycle cycle,Date date){

        String priceOutput = cycle.getPrice(date);

        System.out.println(priceOutput);

        return;
    }

    public synchronized boolean updatePrice(String partId, Double newPrice){
        // get current date
        Date date = new Date();

        //check if the partId is valid or not
        if(!priceMap.containsKey(partId)){
            LOGGER.error("partId is not valid");
            return false;
        }

        //update new price of that part into map
        priceMap.get(partId).put(date,newPrice);

        return true;
    }
}
