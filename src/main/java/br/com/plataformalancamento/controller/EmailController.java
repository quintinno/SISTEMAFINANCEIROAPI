package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.entity.EmailEntity;
import br.com.plataformalancamento.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping
	public ResponseEntity<EmailEntity> cadastrar(@RequestBody EmailEntity emailEntity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.emailService.cadastrar(emailEntity));
	}
	
	@GetMapping
	public List<EmailEntity> recuperar() {
		return this.emailService.recuperar();
	}

}
