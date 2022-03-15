package scanner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.CharArrayReader;

public class CharStreamTest {

    @Test
    void increases_line_counter_on_newline() {

        String example          = "\na";

        CharArrayReader reader  = new CharArrayReader(example.toCharArray());
        CharStream cs           = new CharStream(reader);

        assertEquals(0, cs.lineCount);

        cs.advance();

        assertEquals(1, cs.lineCount);

    }
}
