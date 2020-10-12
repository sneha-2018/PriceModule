package DAO;

import java.util.Date;

public class BarWithBrakes {

	private Brake brakes;

	// default constructor
	public BarWithBrakes(){
		super();
	}

	public BarWithBrakes(Brake brakes) {
		this.brakes = brakes;
	}

	public Brake getBrakes() {
		return brakes;
	}

	public void setBrakes(Brake brakes) {
		this.brakes = brakes;
	}

	public double getPrice(Date date){
        double price = 0;
        try {
        	price = brakes.getPrice(date);
        }
        catch(NullPointerException e) {
        	System.out.println("Please provide brakes information!!");
        }
        return price;
    }
}
