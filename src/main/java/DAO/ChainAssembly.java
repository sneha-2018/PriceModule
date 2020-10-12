package DAO;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

public class ChainAssembly {
	private Gear gears;
	private Chain chain;
	private ChainGuard chainGuard;

	public ChainAssembly() {
	}

	public ChainAssembly(Gear gears, Chain chain, ChainGuard chainGuard) {
		this.gears = gears;
		this.chain = chain;
		this.chainGuard = chainGuard;
	}

	public Gear getGears() {
		return gears;
	}


	public void setGears(Gear gears) {
		this.gears = gears;
	}


	public Chain getChain() {
		return chain;
	}


	public void setChain(Chain chain) {
		this.chain = chain;
	}


	public ChainGuard getChainGuard() {
		return chainGuard;
	}


	public void setChainGuard(ChainGuard chainGuard) {
		this.chainGuard = chainGuard;
	}


	public double getPrice(Date date){
        double price = 0;
 
        for(Field field : this.getClass().getDeclaredFields()){
            try {

                Object obj = field.get(this);
                if(obj != null) {
                    Method method = obj.getClass().getMethod("getPrice", Date.class);

                    //invoke getPrice() method for each components
                    double pr = (double) method.invoke(obj, date);
                  
                    price += pr;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //System.out.println("Total Price of a chain Assembly : " + price + "\n");
        return price;
    }
}
