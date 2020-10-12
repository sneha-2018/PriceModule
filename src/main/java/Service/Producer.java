package Service;
import DAO.Cycle;
import DAO.Product;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    protected BlockingQueue<Product> queue;
    private List<Product> cycles;

    public Producer(BlockingQueue<Product> queue, List<Product> cycles) {
        this.queue = queue;
        this.cycles = cycles;
    }

    public void run() {

        try {
            System.out.println("In Producer " + Thread.currentThread().getId());

            for(Product prod : cycles){
                queue.put(prod);
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

