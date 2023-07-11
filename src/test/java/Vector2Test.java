import com.nixiedroid.Donut.render.math.Vector2;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class Vector2Test {
     Vector2 a = new Vector2(0,0);
     //Vector2 b = new Vector2(0,0);

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
