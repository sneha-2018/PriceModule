package DAO;

import Service.PriceService;

import java.util.Date;

public class Spokes {

    private final String partId = "wheels.spokes";
    private Integer quantity;

    public Spokes() {
    }

    public Spokes(Integer quantity) {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
