package Service;


import DAO.Product;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    protected BlockingQueue<Product> queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            // adding this condition to keep polling message from queue. consumer thread will
            // wait till there is an object in the queue
        	while(true) {
                System.out.println("In Consumer " + Thread.currentThread().getId());

                Product prod = queue.take();
                PriceService.getPrice(prod.getCycle() , prod.getDate());
                Thread.sleep(1000);
        	}
                
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}