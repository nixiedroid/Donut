import com.nixiedroid.Donut.render.math.Vector3;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Vector3DTest {
    @Test
    public void cloneTest(){
        Vector3 vec = new Vector3(1,2,3);
        System.out.println(vec);
        Vector3 vecClone = vec.clone();
        Vector3 vecClone2 = vec.clone();
        assertNotEquals(vec,vecClone);
        assertEquals(vec.x,vecClone.x);
        assertEquals(vec.y,vecClone.y);
        assertEquals(vec.z,vecClone.z);
        assertNotEquals(vecClone2,vec);
        assertNotEquals(vecClone2,vecClone);
    }
    @Test
    public void substractTest(){
        Vector3 vec = new Vector3(23,42,34);
        System.out.println(vec);
        Vector3 vecClone = Vector3.add(vec,-5);
        assertEquals(vec.x,vecClone.x);
        assertEquals(vec.y,vecClone.y);
        assertEquals(vec.z,vecClone.z);
    }
}
