package compiler.Utility;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;

/**
 * Created by morell on 5/16/16.
 */
public class AntlrErrorCollector extends BaseErrorListener {
    //This class collects syntax-errors from the ANTLR-generated parser and stores them in the ErrorHandling-class
    public static AntlrErrorCollector INSTANCE = new AntlrErrorCollector();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e)
    {
        String sourceName = recognizer.getInputStream().getSourceName();
        if (!sourceName.isEmpty()) {
            sourceName = String.format("%s:%d:%d: ", sourceName, line, charPositionInLine);
        }

        ErrorHandling.Error(sourceName+"line "+line+":"+charPositionInLine+" "+msg);
    }


}
