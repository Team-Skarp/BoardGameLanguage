package scanner;

public class Token {

    public final static int

        EXP     = 0,
        DIV     = 1,
        MUL     = 2,
        ADD     = 3,
        SUB     = 4,
        MOD     = 5,
        FNUM    = 6,
        INUM    = 7,
        EOF     = 8;

    public final static String[] token2str = new String[] {
            "exp", "div", "mul", "add", "sub", "mod", "fnum", "inum", "eof"
    };

    public final int    type;
    public final String val;

    public Token(int type) {
        this.type = type;
        this.val = "";
    }

    public Token(int type, String val) {
        this.type   = type;
        this.val    = val;
    }

    @Override
    public String toString() {
        return "Token{" + "type=" + token2str[type] + ", val='" + val + '\'' + '}';
    }
}
