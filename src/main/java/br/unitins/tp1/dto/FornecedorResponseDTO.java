package br.unitins.tp1.dto;

import java.util.List;

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
        List<ProdutoResponseDTO> produtos = fornecedor.getProdutos()
            .stream().map(produto -> ProdutoResponseDTO.valueOf(produto)).toList();
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
    public Fornecedor toEntity() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(id());
        fornecedor.setNome(nome());
        fornecedor.setTelefone(telefone());
        fornecedor.setLocalLojaFornecedor(localLojaFornecedor());
        fornecedor.setEmail(email());
        fornecedor.setCnpj(cnpj());
        return fornecedor;
    }
}
