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

    public Coord plusNum(float num)
    {
        return new Coord(this.x + num, this.y + num, this.z + num);
    }

    public Coord plusCoord(Coord coord)
    {
        return new Coord(this.x + coord.x, this.y + coord.y, this.z + coord.z);
    }

    public Coord multNum(float num)
    {
        return new Coord(this.x * num, this.y * num, this.z * num);
    }

    public Coord multCoord(Coord coord)
    {
        return new Coord(this.x * coord.x, this.y * coord.y, this.z * coord.z);
    }

    public Coord minusNum(float num)
    {
        return new Coord(this.x - num, this.y - num, this.z - num);
    }

    public Coord minusCoord(Coord coord)
    {
        return new Coord(this.x - coord.x, this.y - coord.y, this.z - coord.z);
    }

    public Coord divNum(float num)
    {
        return new Coord(this.x / num, this.y / num, this.z / num);
    }

    public Coord divCoord(Coord coord)
    {
        return new Coord(this.x / coord.x, this.y / coord.y, this.z / coord.z);
    }

    @Override
    public String toString() {
        return String.format("(%2f,%2f,%2f)", x, y, z);
    }
}
