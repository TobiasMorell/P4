/**
 * Created by Lee on 09/03/16.
 */

import java_cup.*;
import java.io.FileReader;

public class Main {

    public static void main (String args[]) throws Exception
    {
        Scanner s =  new Scanner(new FileReader("src/cancer"));
        parser p = new parser (s);

        p.debug_parse();
    }
}
