package br.com.seiya.barbershop.domain.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Builder;

@Builder
public class ClienteRequest {

	@NotBlank
	@CPF
    public String cpf;
	@NotBlank
    public String nome;
	public Boolean status;
	@NotBlank
	@Email
    public String email;
//	@NotBlank
//    public String senha;
	@NotBlank
    public String telefone;
	
}
