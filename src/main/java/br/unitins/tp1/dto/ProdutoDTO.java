package br.unitins.tp1.dto;

public record ProdutoDTO (
    String marca, 
    String modelo, 
    String cor, 
    double preco, 
    Long fornecedorId
){ 
}
