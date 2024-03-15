package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto>{
    public List<Produto> findByMarca(String marca){
        return find("UPPER(marca) LIKE ?1", "%" + marca.toUpperCase() + "%").list();
    }

    public List<Produto> findByModelo(String modelo){
        return find("UPPER(modelo) LIKE ?1", "%" + modelo.toUpperCase() +  "%").list();
    }
}
