package br.com.alex.annotation.aop;

import org.springframework.http.HttpStatus;

public class ExpectedException extends HttpException {

	private static final long serialVersionUID = 8258285295487174044L;
    private SimpleError error;
    private Throwable cause;

    public ExpectedException(SimpleError error) {
    	super(error.getMensagem());
        this.error = error;
    }

	public ExpectedException(Throwable cause, SimpleError error) {
        this(error);
        this.cause = cause;
    }

    public ExpectedException(String message, Object... args) {
        this(new SimpleError(message, args));
    }

    public ExpectedException(Integer code, String message, Object... args) {
        this(SimpleError.message(message).code(code.toString()).build());
    }

	public ExpectedException(Throwable cause, String message, Object... args) {
        this(cause, new SimpleError(message, args));
    }

    @Override
    public synchronized Throwable getCause() {
    	return cause;
    }

    @Override
    public SimpleError getError() {
		return error;
	}

    @Override
    public HttpStatus getStatus() {
    	return HttpStatus.EXPECTATION_FAILED;
    }
}

