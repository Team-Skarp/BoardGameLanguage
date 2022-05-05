package Parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 * Custom error class to catch parse errors as normnal exceptions to be used in testing
 *
 * https://stackoverflow.com/questions/18132078/handling-errors-in-antlr4
 */
public class SyntaxErrorListener extends BaseErrorListener {

    public static final SyntaxErrorListener INSTANCE = new SyntaxErrorListener();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {

        throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
    }
}
