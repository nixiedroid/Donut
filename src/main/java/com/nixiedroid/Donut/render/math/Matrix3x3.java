package com.nixiedroid.Donut.render.math;

public class Matrix3x3 {
    Vector3 x;
    Vector3 y;
    Vector3 z;

    public Matrix3x3(
            double xx, double xy,double xz,
            double yx, double yy,double yz,
            double zx, double zy,double zz
    ) {
        x = new Vector3(xx,xy,xz);
        y = new Vector3(yx,yy,yz);
        z = new Vector3(zx,zy,zz);
    }

    public Matrix3x3(Vector3 x, Vector3 y, Vector3 z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 multiply(Vector3 coords){
        return new Vector3(
                x.dotProduct(coords),
                y.dotProduct(coords),
                z.dotProduct(coords)
        );
    }

    @Override
    public String toString() {
        return "Matrix \n"+
                x.x + ", " + x.y + ", " + x.z + " \n"+
                y.x + ", " + y.y + ", " + y.z + " \n"+
                z.x + ", " + z.y + ", " + z.z;
    }
}
