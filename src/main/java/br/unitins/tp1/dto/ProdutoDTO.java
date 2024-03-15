package br.unitins.tp1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProdutoDTO (
    @NotBlank(message = "A marca não pode ser nula ou vazia")
    @Size(min = 4, max = 60, message = "O tamanho da marca deve ser entre 2 e 60 caracteres")
    String marca, 

    @NotBlank(message = "O nome do modelo não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do nome do modelo deve ser entre 2 e 60 caracteres")
    String modelo, 
    String cor, 
    double preco, 
    Long fornecedorId
){ }
