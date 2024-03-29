package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente>{
    public List<Cliente> findByNome(String nome){
        return find("UPPER(nome) LIKE %1", "%" + nome.toUpperCase() + "%").list();
    }
    public List<Cliente> findByEmailCliente(String email){
        return find("UPPER(email) LIKE ?1", "%" + email.toUpperCase() + "%").list();
    }
}
