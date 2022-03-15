package scanner;

import java.io.Reader;

public class CharStream {

    public static final char
            BLANK = ' ';

    private final   Reader is;      //Becomes the reader for input stream

    public int      lineCount;
    private char    nextChar;
    private boolean eof;

    public CharStream(Reader ds) {
        this.is         = ds;
        this.eof        = false;
        this.nextChar   = 0;
    }

    public char peek() {
        return nextChar;
    }

    public boolean EOF() {
        return eof;
    }

    /* Advances one character forward in the character stream */
    public char advance() {

        char ans = nextChar;
        try {
            int next = is.read();

            //EOF has been met
            if (next == -1) {
                eof = true;
                nextChar = 0;
            }

            //Count number of read lines
            if (next == (int) '\n') {
                lineCount++;
            }

            nextChar = (char) next;

        } catch (Throwable e) {
            System.out.println("Failed to read input on line " + lineCount);
            eof = true;
        }

        return ans;
    }
}
