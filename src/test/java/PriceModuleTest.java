

import DAO.*;
import Service.PriceService;
import org.junit.Test;
import java.util.Date;

public class PriceModuleTest {

    private PriceService priceService = new PriceService();


    @Test
    public void testPriceOfTyre() {

        Date cur_date = new Date();
        Tyre tyre = new Tyre(2);


        double tyrePrice = tyre.getPrice(cur_date);
        double expectedPrice = 500.0;

        assert expectedPrice==tyrePrice : "Tyre price is not matching";

    }

    @Test
    public void testPriceOfFrame() {

        Date cur_date = new Date();
        Frame frame = new Frame(FrameType.STEEL);


        double framePrice = frame.getPrice(cur_date);
        double expectedPrice = 650.0;
        System.out.println(framePrice);

        assert expectedPrice == framePrice : "Frame price is not matching";

    }

    @Test
    public void testUpdatePrice(){

        //update price for tyre to 300
        String partId = "wheels.tyre";
        double newPrice = 300.0;

        priceService.updatePrice(partId, newPrice);

        Tyre tyre = new Tyre(1);
        Date cur_date = new Date();

        double tyrePrice = tyre.getPrice(cur_date);
        double expectedPrice = newPrice;

        assert tyrePrice == expectedPrice : "Tyre price is not updated correctly";
    }

}
