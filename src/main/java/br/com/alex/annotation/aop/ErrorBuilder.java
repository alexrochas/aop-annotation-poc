package br.com.alex.annotation.aop;

public class ErrorBuilder {

	protected SimpleError error;

	public ErrorBuilder(String message, Object... args) {
		error = new SimpleError(message, args);
	}

	public ErrorBuilder code(String code) {
		error.setCodigo(code);
		return this;
	}

	public ErrorBuilder object(Object objeto) {
		error.setObjeto(objeto);
		return this;
	}

	public ErrorBuilder detail(SimpleError detail) {
		error.addDetalhe(detail);
		return this;
	}

	public SimpleError build() {
		return error;
	}
}

