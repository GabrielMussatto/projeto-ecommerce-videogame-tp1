package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto>{
    public List<Produto> findByNome(String nome){
        return find("UPPER(nome) LIKE %1", "%" + nome.toUpperCase() + "%").list();
    }
}
