import com.nixiedroid.Donut.render.math.Matrix3x3;
import com.nixiedroid.Donut.render.math.Vector3;
import org.junit.jupiter.api.Test;

public class Matrix3x3Test {
    Vector3 vector = new Vector3(1,2,3);
    Vector3 multiplier = new Vector3(23,12,42);
    Matrix3x3 matrix = new Matrix3x3(vector, vector.clone().multiply(4),vector.clone().add(6));
    @Test
    public void MatrixMultTest(){
        System.out.println(matrix);
        System.out.println(multiplier);
        System.out.println(matrix.multiply(multiplier));
    }
}
