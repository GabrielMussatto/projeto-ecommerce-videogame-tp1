package br.unitins.tp1.dto;

import br.unitins.tp1.model.Produto;

public record ProdutoResponseDTO(
    Long id,
    String marca,
    String modelo,
    String cor,
    double preco,
    FornecedorResponseDTO fornecedor
) {
    public static ProdutoResponseDTO valueOf(Produto produto){
        return new ProdutoResponseDTO(
            produto.getId(), 
            produto.getMarca(), 
            produto.getModelo(), 
            produto.getCor(), 
            produto.getPreco(), 
            FornecedorResponseDTO.valueOf(produto.getFornecedor())
        );
    }
}
