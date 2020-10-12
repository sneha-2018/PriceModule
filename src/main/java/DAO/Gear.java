package DAO;

import java.util.Date;

import Service.PriceService;

public class Gear {
	
	private final String partId = "ChainAssembly.Gear";
	private int quantity;

	public Gear() {
	}

	public Gear(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
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
	
}
