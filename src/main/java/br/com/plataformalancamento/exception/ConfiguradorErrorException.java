package br.com.plataformalancamento.exception;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Responsavel por personalizar a mensagem de erro de retorno de uma determinada requisicao
 */
public class ConfiguradorErrorException {

    @JsonProperty("Horario do Erro")
    private String horarioErro;

    @JsonProperty("Identificador do Erro")
    private String identificadorErro;

    @JsonProperty("Mensagem do Erro")
    private String mensagemErro;

    public ConfiguradorErrorException(String horarioErro, HttpStatus httpStatus, String mensagemErro) {
        this.horarioErro = horarioErro;
        this.identificadorErro = httpStatus.getReasonPhrase().concat(" (" + httpStatus.value() + ")");
        this.mensagemErro = mensagemErro;
    }

    public static String recuperarMensagemErroObjetoNaoEncontradoRequisicao() {
        return "Não existem objetos cadastrados no Banco de Dados!";
    }
    
    public static String recuperarMensagemErroObjetoNaoEncontradoRequisicao(Long codigo) {
        return "O objeto com código \"" + codigo + "\" não está cadastrado no Banco de Dados!";
    }
    
    public static String recuperarMensagemErroObjetoNaoPodeSerDeletadoRequisicao(Long codigo) {
        return "O objeto com código '" + codigo + "' não pode ser deletado, pois existem objetos associados a ele no Banco de Dados!";
    }

    public String getHorarioErro() {
        return horarioErro;
    }

    public void setHorarioErro(String horarioErro) {
        this.horarioErro = horarioErro;
    }

    public String getIdentificadorErro() {
        return identificadorErro;
    }

    public void setIdentificadorErro(String identificadorErro) {
        this.identificadorErro = identificadorErro;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

}
