public class MyException extends Exception{

    private final ErrorCode code;

    public MyException(ErrorCode code) {
        super();
        this.code = code;
    }

    public MyException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public MyException(Throwable cause, ErrorCode code) {
        super(cause);
        this.code = code;
    }

    public ErrorCode getCode() { return this.code; }
}