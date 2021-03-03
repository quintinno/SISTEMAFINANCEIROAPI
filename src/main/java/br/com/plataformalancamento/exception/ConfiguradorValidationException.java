package br.com.plataformalancamento.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ConfiguradorValidationException extends ConfiguradorErrorException {

    @JsonProperty("errosDeValidacaoDeCampos")
    private List<CamposValidacaoException> configuradorMensagemValidacaoExceptionList = new ArrayStack<>();

    public ConfiguradorValidationException(String horarioErro, HttpStatus httpStatus, String mensagemErro) {
        super(horarioErro, httpStatus, mensagemErro);
    }

    public List<CamposValidacaoException> getConfiguradorMensagemValidacaoExceptionList() {
        return configuradorMensagemValidacaoExceptionList;
    }

    public void setConfiguradorMensagemValidacaoExceptionList(List<CamposValidacaoException> configuradorMensagemValidacaoExceptionList) {
        this.configuradorMensagemValidacaoExceptionList = configuradorMensagemValidacaoExceptionList;
    }

    public void adicionarErrosConfigurador(String nomeCampoErro, String mensagemErro) {
        this.configuradorMensagemValidacaoExceptionList.add(new CamposValidacaoException(nomeCampoErro, mensagemErro));
    }

}
