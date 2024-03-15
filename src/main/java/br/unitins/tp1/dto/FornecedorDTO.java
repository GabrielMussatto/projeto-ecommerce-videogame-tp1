package br.unitins.tp1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FornecedorDTO(
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do nome deve ser entre 2 e 60 caracteres")
    String nome,
    
    @NotBlank(message = "O email não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do email deve ser entre 2 e 60 caracteres")
    String email,
    
    String telefone,
    String localLojaFornecedor,
    String cnpj
) {
    
}
