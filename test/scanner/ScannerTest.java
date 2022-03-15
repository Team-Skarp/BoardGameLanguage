package scanner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static scanner.Token.*;
import java.io.CharArrayReader;
import java.io.IOException;

public class ScannerTest {

    @Test
    void reads_inttoken_from_file() throws IOException {

        String example          = "23";
        CharArrayReader reader  = new CharArrayReader(example.toCharArray());

        Scanner scanner         = new Scanner(reader);

        Token token             = scanner.nextToken();

        assertEquals(INUM, token.type);

    }
}
