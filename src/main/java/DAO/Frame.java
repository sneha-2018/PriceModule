package DAO;

import Service.PriceService;

import java.util.Date;

public class Frame {

    private final String partId = "frame";
    private FrameType type;

    // default constructor
    public Frame(){
    }

    public Frame(FrameType type) {
        this.type = type;
    }


    public double getPrice(Date date){
        double price = 0;

        String key = partId+"."+type;
        if(PriceService.priceMap.containsKey(key)) {
            price = PriceService.priceMap.get(key).floorEntry(date).getValue();
        }

        return price;
    }

    public FrameType getType() {
        return type;
    }

    public void setType(FrameType type) {
        this.type = type;
    }
}
