package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FornecedorRepository implements PanacheRepository<Fornecedor> {
    public List<Fornecedor> findByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%" + nome.toUpperCase() + "%").list();
    }

    public List<Fornecedor> findByEmailFornecedor(String email){
        return find("UPPER(email) LIKE ?1", "%" + email.toUpperCase() + "%").list();
    }
}
