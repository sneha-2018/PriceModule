package DAO;

import Service.PriceService;

import java.util.Date;

public class Tyre {

    private final String partId = "wheels.tyre";
    private int quantity;

    // default constructor
    public Tyre(){

    }

    public Tyre(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice(Date date){

        double price = 0;

        String key = partId;
        if(PriceService.priceMap.containsKey(key)) {
            price = PriceService.priceMap.get(key).floorEntry(date).getValue() * quantity;
        }

        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
