package br.unitins.tp1.dto;

import java.time.LocalDate;

public record ClienteDTO(
    String nome,
    String email,
    String telefone,
    String endereco,
    String cpf,
    LocalDate dataNascimento,
    LocalDate dataCadastro
) {
    
}
