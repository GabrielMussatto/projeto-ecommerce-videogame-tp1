package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.model.Produto;
import br.unitins.tp1.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProdutoService {

    @Inject
    ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.listAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    @Transactional
    public void salvar(Produto produto) {
        produtoRepository.persist(produto);
    }

    @Transactional
    public void atualizar(Produto produto) {
        produtoRepository.getEntityManager().merge(produto);
    }

    @Transactional
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}
