import com.obsidiskrivemaskine.Test;

public class DynamicClass{
   public static void main(String[] args){
      Test.createEntityIfNotPresent();
      Test.Talk("Hej");
      //Test.move("west", 15, 0.75);
      //Test.dig("north");
   }
}