package br.com.alex.annotation.aop.exception;

import java.util.ArrayList;
import java.util.List;

public class SimpleError {

    private String mensagem;
    private String codigo;
    private Object objeto;
    private List<SimpleError> detalhes;

    public SimpleError() {
	}

    public SimpleError(String mensagem, Object... args) {
        this.mensagem = mensagem;
    }

    public static ErrorBuilder message(String message, Object... args) {
		return new ErrorBuilder(message, args);
	}

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

	public List<SimpleError> getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(List<SimpleError> detalhes) {
		this.detalhes = detalhes;
	}

	public void addDetalhe(SimpleError detailError) {
    	if(detalhes == null) {
    		detalhes = new ArrayList<>();
    	}
    	detalhes.add(detailError);
    }
}

