package br.com.plataformalancamento.repository;

public interface ReceitaInterfaceDao {
    public Double recuperarReceitasVariavelRecebidas();
    public Double recuperarReceitasFixasRecebidas();
    public Double recuperarReceitasVariaveisPendentes();
    public Double recuperarReceitasFixasPendentes();
}
