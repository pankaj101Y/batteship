import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ShipTest {

    @Test
    public void testSetStatusAlive(){
        Ship ship=new Ship();
        ship.setStatus(Ship.ShipStatus.DESTROYED);

        assertEquals(ship.getStatus(),Ship.ShipStatus.DESTROYED);
    }


}