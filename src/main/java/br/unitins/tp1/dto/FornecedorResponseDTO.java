package br.unitins.tp1.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.tp1.model.Fornecedor;

public record FornecedorResponseDTO(
    Long id,
    String nome,
    String telefone,
    String localLojaFornecedor,
    String email,
    String cnpj,
    List<ProdutoResponseDTO> produtos
) {
    public static FornecedorResponseDTO valueOf(Fornecedor fornecedor){
        if (fornecedor == null) {
            return null; // Pode retornar null ou criar um FornecedorResponseDTO com valores padrão, conforme necessário.
        }
        List<ProdutoResponseDTO> produtos = fornecedor.getProdutos()
            .stream().map(produto -> ProdutoResponseDTO.valueOf(produto)).collect(Collectors.toList());
        return new FornecedorResponseDTO(
            fornecedor.getId(),
            fornecedor.getNome(),
            fornecedor.getTelefone(),
            fornecedor.getLocalLojaFornecedor(),
            fornecedor.getEmail(),
            fornecedor.getCnpj(),
            produtos
        );
    }
}
