package br.com.plataformalancamento.repository;

import br.com.plataformalancamento.entity.ReceitaEntity;
import br.com.plataformalancamento.enumeration.TipoReceitaEnumeration;
import br.com.plataformalancamento.enumeration.TipoSituacaoPagamentoEnumeration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

@Repository
public class ReceitaImplementacaoDao implements ReceitaInterfaceDao, Serializable {

    private static final long serialVersionUID = 2395441516165389505L;

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("deprecation")
	@Override
    public Double recuperarReceitasVariavelRecebidas() {
        StringBuilder query = new StringBuilder("SELECT SUM(receitaEntity.valorPagamento) ")
                .append("FROM ReceitaEntity receitaEntity ")
                .append("WHERE receitaEntity.tipoSituacaoPagamentoEnumeration = :situacao_pagamento_ ");
        TypedQuery<Double> typedQuery = entityManager.createQuery(query.toString(), Double.class);
        typedQuery.setParameter("situacao_pagamento_", TipoSituacaoPagamentoEnumeration.PAGO);
        Double totalizador = typedQuery.getSingleResult();
        if (totalizador == null) {
            return new Double(0.0);
        }
        return totalizador;
    }

    @SuppressWarnings("deprecation")
	@Override
    public Double recuperarReceitasFixasRecebidas() {
        StringBuilder query = new StringBuilder("SELECT SUM(parcelamentoEntity.valorEfetivoParcela) ")
                .append("FROM ParcelamentoEntity parcelamentoEntity ")
                .append("JOIN parcelamentoEntity.receitaEntity receitaEntity ")
                .append("WHERE parcelamentoEntity.tipoSituacaoPagamentoEnumeration = :situacao_pagamento_ ");
        TypedQuery<Double> typedQuery = entityManager.createQuery(query.toString(), Double.class);
        typedQuery.setParameter("situacao_pagamento_", TipoSituacaoPagamentoEnumeration.PAGO);
        Double totalizador = typedQuery.getSingleResult();
        if (totalizador == null) {
            return new Double(0.0);
        }
        return totalizador;
    }

    @SuppressWarnings("deprecation")
	@Override
    public Double recuperarReceitasFixasPendentes() {
        StringBuilder query = new StringBuilder("SELECT SUM(parcelamentoEntity.valorEfetivoParcela) ")
                .append("FROM ParcelamentoEntity parcelamentoEntity ")
                .append("JOIN parcelamentoEntity.receitaEntity receitaEntity ")
                .append("WHERE parcelamentoEntity.tipoSituacaoPagamentoEnumeration = :situacao_pagamento_ ");
        TypedQuery<Double> typedQuery = entityManager.createQuery(query.toString(), Double.class);
        typedQuery.setParameter("situacao_pagamento_", TipoSituacaoPagamentoEnumeration.PENDENTE);
        Double totalizador = typedQuery.getSingleResult();
        if (totalizador == null) {
            return new Double(0.0);
        }
        return totalizador;
    }

    @SuppressWarnings("deprecation")
	@Override
    public Double recuperarReceitasVariaveisPendentes() {
        StringBuilder query = new StringBuilder("SELECT SUM(parcelamentoEntity.valorPrevistoParcela) ")
                .append("FROM ParcelamentoEntity parcelamentoEntity ")
                .append("JOIN parcelamentoEntity.receitaEntity receitaEntity ")
                .append("WHERE parcelamentoEntity.tipoSituacaoPagamentoEnumeration = :situacao_pagamento_ ");
        TypedQuery<Double> typedQuery = entityManager.createQuery(query.toString(), Double.class);
        typedQuery.setParameter("situacao_pagamento_", TipoSituacaoPagamentoEnumeration.PENDENTE);
        Double totalizador = typedQuery.getSingleResult();
        if (totalizador == null) {
            return new Double(0.0);
        }
        return totalizador;
    }
    
    // TODO -- [N]
    public Integer recuperarNumeroControleDiario(ReceitaEntity receitaEntity) {
    	StringBuilder query = new StringBuilder("SELECT receitaEntity ")
    		.append("FROM ReceitaEntity receitaEntity ")
    		.append("WHERE receitaEntity.tipoReceitaEnumeration = :tipo_receita_ ");
                if(receitaEntity.getTipoReceitaEnumeration().equals(TipoReceitaEnumeration.RECEITA_FIXA)) {
    		        query.append("AND receitaEntity.dataPrevisaoRecebimento = :data_previsao_recebimento_pagamento_ ");
                } else {
                    query.append("AND receitaEntity.dataRecebimentoPagamento = :data_recebimento_pagamento_ ");
                }
    	TypedQuery<ReceitaEntity> typedQuery = entityManager.createQuery(query.toString(), ReceitaEntity.class);
    		typedQuery.setParameter("tipo_receita_", receitaEntity.getTipoReceitaEnumeration());
                if(receitaEntity.getTipoReceitaEnumeration().equals(TipoReceitaEnumeration.RECEITA_FIXA)) {
                    typedQuery.setParameter("data_previsao_recebimento_pagamento_", receitaEntity.getDataPrevisaoRecebimento());
                } else {
                    typedQuery.setParameter("data_recebimento_pagamento_", receitaEntity.getDataRecebimentoPagamento());
                }
    	List<ReceitaEntity> receitaEntityList = typedQuery.getResultList();
    	Integer totalizadorDiario = receitaEntityList.size();
    	if(totalizadorDiario != 0) {
    		return totalizadorDiario + 1;
    	} else {
    		return 1;
    	}
    }

}
