package Service; 

import DAO.Product;
import Utility.AppConfig;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.concurrent.*;

public class Application {

    private static final Logger LOGGER = Logger.getLogger(Application.class);

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
    public static AppConfig appConfig = new AppConfig();
    private static PriceService priceService = new PriceService();

    public static void main(String[] args) throws  Exception{

        List<Product> cycles = appConfig.loadInputData();

        BlockingQueue queue = new ArrayBlockingQueue(1024);

        final Producer producer = new Producer(queue,cycles);
        final Consumer consumer = new Consumer(queue);

        executorService.execute(producer);

       for(int num=0; num < 10; num++) {
           executorService.execute(consumer);
       }

       executorService.shutdown();
       executorService.awaitTermination(3,TimeUnit.SECONDS);

    }
}
