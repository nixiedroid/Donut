import com.nixiedroid.Donut.render.Vector2D;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class Vector2DTest {
     Vector2D a = new Vector2D(0,0);
     //Vector2D b = new Vector2D(0,0);

    @Test
    public void addVector(){
        a.add(2.);
        assertEquals(a.x,2);
        assertEquals(a.y,2);
    }
    @Test
    public void multVector(){
        a.set(2,4).multiply(5);
        assertEquals(a.x,10);
        assertEquals(a.y,20);
        a.set(2,4).multiply(8,20);
        assertEquals(a.x,16);
        assertEquals(a.y,80);
    }
}
