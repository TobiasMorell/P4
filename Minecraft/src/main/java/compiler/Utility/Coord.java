package compiler.Utility;

/**
 * Created by morell on 4/28/16.
 */
public class Coord {
    public float x, y, z;

     public Coord(float x, float y, float z)
     {
         this.x = x;
         this.y = y;
         this.z = z;
     }

    @Override
    public String toString() {
        return String.format("(%f,%f,%f)", x, y, z);
    }
}
