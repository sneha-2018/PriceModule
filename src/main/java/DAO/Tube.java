package DAO;

import Service.PriceService;

import java.util.Date;

public class Tube {

    private final String partId = "wheels.tube";
    private TubeSize size;

    public Tube() {
    }

    public Tube(TubeSize size) {
        this.size = size;
    }

    public double getPrice(Date date){
        double price = 0;

        String key = partId+ "." +size;
        if(PriceService.priceMap.containsKey(key)) {
            price = PriceService.priceMap.get(key).floorEntry(date).getValue();
        }

        return price;
    }

    public TubeSize getSize() {
        return size;
    }

    public void setSize(TubeSize size) {
        this.size = size;
    }
}
