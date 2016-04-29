package Utility;

import javax.tools.SimpleJavaFileObject;
import java.io.IOException;
import java.net.URI;

/**
 * Created by morell on 4/27/16.
 */
public class JavaSourceBuffer extends SimpleJavaFileObject {
    private final String _code;

    public  JavaSourceBuffer (String className, String code)
    {
        super(URI.create("string:///"+ className.replace('.','/') + Kind.SOURCE.extension), Kind.SOURCE);
        this._code = code;
    }

    public CharSequence getCharContent(boolean b) throws IOException {
        return _code;
    }
}
