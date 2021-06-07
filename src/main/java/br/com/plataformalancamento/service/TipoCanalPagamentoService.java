package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.plataformalancamento.dto.TipoCanalPagamentoDTO;
import br.com.plataformalancamento.enumeration.TipoCanalPagamentoEnumeration;

@Service
public class TipoCanalPagamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public List<TipoCanalPagamentoDTO> recuperar() {
		List<TipoCanalPagamentoDTO> tipoCanalPagamentoDTOList = new ArrayList<>();
		for(TipoCanalPagamentoEnumeration tipoCanalPagamentoEnumeration : TipoCanalPagamentoEnumeration.values()) {
			TipoCanalPagamentoDTO tipoCanalPagamentoDTO = new TipoCanalPagamentoDTO();
				tipoCanalPagamentoDTO.setCodigo(tipoCanalPagamentoEnumeration.getCodigo());
				tipoCanalPagamentoDTO.setDescricao(tipoCanalPagamentoEnumeration.getDescricao());
				tipoCanalPagamentoDTO.setSigla(tipoCanalPagamentoEnumeration.getSigla());
				tipoCanalPagamentoDTO.setValor(tipoCanalPagamentoEnumeration.name());
			tipoCanalPagamentoDTOList.add(tipoCanalPagamentoDTO);
		}	
		return tipoCanalPagamentoDTOList;
	}

}
