package br.com.plataformalancamento.exception;

import java.io.Serializable;

public class CamposValidacaoException implements Serializable {

    private static final long serialVersionUID = -5600205532422676058L;

    private String nomeCampoErro;

    private String mensagemErro;

    public CamposValidacaoException() { }

    public CamposValidacaoException(String nomeCampoErro, String mensagemErro) {
        this.nomeCampoErro = nomeCampoErro;
        this.mensagemErro = mensagemErro;
    }

    public String getNomeCampoErro() {
        return nomeCampoErro;
    }

    public void setNomeCampoErro(String nomeCampoErro) {
        this.nomeCampoErro = nomeCampoErro;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

}
