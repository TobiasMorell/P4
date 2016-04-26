import com.obsidiskrivemaskine.Test;

public class DynamicClass{
   public static void main(String[] args){
     Test test = new Test();
      Test.createCow();
      Test.spawnCow();
      test.moveCow("forward");
   }
}