package DAO;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

public class Wheels {

    private Tube tube;
    private Tyre tyre;
    private Spokes spokes;

    // default constructor
    public Wheels(){

    }

    public Wheels(Tube tube, Tyre tyre, Spokes spokes) {
        this.tube = tube;
        this.tyre = tyre;
        this.spokes = spokes;
    }

    public double getPrice(Date date){
    	double totalPrice = 0.0;
    	
    	for(Field field : this.getClass().getDeclaredFields()){
            try {

                Object obj = field.get(this);
                if(obj != null) {
                    Method method = obj.getClass().getMethod("getPrice", Date.class);

                    //invoke getPrice() method for each components
                    Double price = (Double) method.invoke(obj, date);
                    totalPrice += price;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
    	}
        return totalPrice;
    }

    public Tube getTube() {
        return tube;
    }

    public void setTube(Tube tube) {
        this.tube = tube;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    public Spokes getSpokes() {
        return spokes;
    }

    public void setSpokes(Spokes spokes) {
        this.spokes = spokes;
    }
}
