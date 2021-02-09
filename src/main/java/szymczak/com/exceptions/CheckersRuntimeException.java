package szymczak.com.exceptions;

public class CheckersRuntimeException extends RuntimeException {
    public CheckersRuntimeException(String methodName) {
        super("Something went wrong in " + methodName);
    }
}
