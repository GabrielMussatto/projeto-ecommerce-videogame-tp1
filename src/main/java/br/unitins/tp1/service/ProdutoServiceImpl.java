package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.ProdutoDTO;
import br.unitins.tp1.dto.ProdutoResponseDTO;
import br.unitins.tp1.model.Fornecedor;
import br.unitins.tp1.model.Produto;
import br.unitins.tp1.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService {
    
    @Inject
    public ProdutoRepository produtoRepository;

    @Inject
    public FornecedorService fornecedorService;
    
    @Override
    @Transactional
    public ProdutoResponseDTO create(@Valid ProdutoDTO dto){
        Produto produto = new Produto();
        produto.setMarca(dto.marca());
        produto.setModelo(dto.modelo());
        produto.setPreco(dto.preco());
        produto.setCor(dto.cor());
        
        Fornecedor fornecedor = fornecedorService.findById(dto.fornecedorId()).toEntity();
        produto.setFornecedor(fornecedor);

        produtoRepository.persist(produto);
        return ProdutoResponseDTO.valueOf(produto);
    }

    @Override
    @Transactional
    public void update(Long id, ProdutoDTO dto) {
        Produto produtoBanco = produtoRepository.findById(id);

        produtoBanco.setMarca(dto.marca());
        produtoBanco.setModelo(dto.modelo());
        produtoBanco.setPreco(dto.preco());
        produtoBanco.setCor(dto.cor());
        
        Fornecedor fornecedor = fornecedorService.findById(dto.fornecedorId()).toEntity();
        produtoBanco.setFornecedor(fornecedor);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public ProdutoResponseDTO findById(Long id){
        return ProdutoResponseDTO.valueOf(produtoRepository.findById(id));
    }

    @Override
    public List<ProdutoResponseDTO> findAll(){
        return produtoRepository.listAll()
                .stream()
                .map(produto  -> ProdutoResponseDTO.valueOf(produto))
                .toList();
    }

    @Override
    public List<ProdutoResponseDTO> findByMarca(String marca){
        return produtoRepository.findByMarca(marca)
                .stream()
                .map(produto -> ProdutoResponseDTO.valueOf(produto))
                .toList();
    }

    @Override
    public List<ProdutoResponseDTO> findByModelo(String modelo){
        return produtoRepository.findByModelo(modelo)
                .stream()
                .map(produto -> ProdutoResponseDTO.valueOf(produto))
                .toList();
    }

}
