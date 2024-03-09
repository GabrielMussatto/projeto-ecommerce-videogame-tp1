package br.unitins.tp1.dto;

import java.time.LocalDate;

import br.unitins.tp1.model.Cliente;

public record ClienteResponseDTO(
    Long id,
    String nome,
    String email,
    String telefone,
    String endereco,
    String cpf,
    LocalDate dataNascimento,
    LocalDate dataCadastro
) {
    public static ClienteResponseDTO valueOf(Cliente cliente){
        return new ClienteResponseDTO(
            cliente.getId(),
            cliente.getNome(),
            cliente.getEmail(),
            cliente.getTelefone(),
            cliente.getEndereco(),
            cliente.getCpf(),
            cliente.getDataNascimento(),
            cliente.getDataCadastro()
        );
    }
}
