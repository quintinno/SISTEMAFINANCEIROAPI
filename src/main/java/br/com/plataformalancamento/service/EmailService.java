package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.entity.EmailEntity;
import br.com.plataformalancamento.repository.EmailRepository;

@Service
public class EmailService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EmailRepository emailRepository;
	
	public EmailEntity cadastrar(EmailEntity emailEntity) {
		return this.emailRepository.save(emailEntity);
	}
	
	public List<EmailEntity> recuperar() {
		return this.emailRepository.findAll();
	}
	
}
