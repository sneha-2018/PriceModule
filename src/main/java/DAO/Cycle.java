package DAO;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

public class Cycle {

    private Frame frame;
    private BarWithBrakes barWithBrakes;
    private Seating seating;
    private Wheels wheels;
    private ChainAssembly chainAssembly;

    public Cycle() {
    }

    public Cycle(Frame frame, BarWithBrakes barWithBrakes, Seating seating, Wheels wheels, ChainAssembly chainAssembly) {
        this.frame = frame;
        this.barWithBrakes = barWithBrakes;
        this.seating = seating;
        this.wheels = wheels;
        this.chainAssembly = chainAssembly;
    }

    // to get price of whole cycle object including its components
    public String getPrice(Date date){
        StringBuffer output = new StringBuffer();
        double totalPrice = 0;

        // iterate over the object's fields
        for(Field field : this.getClass().getDeclaredFields()){
            try {

                Object obj = field.get(this);
                if(obj != null) {
                    Method method = obj.getClass().getMethod("getPrice", Date.class);

                    //invoke getPrice() method for each components
                    Double price = (Double) method.invoke(obj, date);
                    output.append("Price of " + field.getName() + " Component : " + price + "\n");

                    totalPrice += price;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        output.append("Total Price of a Cycle : " + totalPrice + "\n");

        return output.toString();
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public BarWithBrakes getBarWithBrakes() {
        return barWithBrakes;
    }

    public void setBarWithBrakes(BarWithBrakes barWithBrakes) {
        this.barWithBrakes = barWithBrakes;
    }

    public Seating getSeating() {
        return seating;
    }

    public void setSeating(Seating seating) {
        this.seating = seating;
    }

    public Wheels getWheels() {
        return wheels;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    public ChainAssembly getChainAssembly() {
        return chainAssembly;
    }

    public void setChainAssembly(ChainAssembly chainAssembly) {
        this.chainAssembly = chainAssembly;
    }
}
