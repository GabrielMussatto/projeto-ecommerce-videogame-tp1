package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.FornecedorDTO;
import br.unitins.tp1.dto.FornecedorResponseDTO;
import br.unitins.tp1.model.Fornecedor;
import br.unitins.tp1.repository.FornecedorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class FornecedorServiceImpl implements FornecedorService{
    
    @Inject
    public FornecedorRepository fornecedorRepository;

    @Override
    @Transactional
    public FornecedorResponseDTO create(@Valid FornecedorDTO dto){
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(dto.nome());
        fornecedor.setTelefone(dto.telefone());
        fornecedor.setLocalLojaFornecedor(dto.localLojaFornecedor());
        fornecedor.setEmail(dto.email());
        fornecedor.setCnpj(dto.cnpj());
        
        fornecedorRepository.persist(fornecedor);
        return FornecedorResponseDTO.valueOf(fornecedor);
    }

    @Override
    @Transactional
    public void update(Long id, FornecedorDTO dto){
        Fornecedor fornecedorBanco = fornecedorRepository.findById(id);

        fornecedorBanco.setNome(dto.nome());
        fornecedorBanco.setTelefone(dto.telefone());
        fornecedorBanco.setLocalLojaFornecedor(dto.localLojaFornecedor());
        fornecedorBanco.setEmail(dto.email());
        fornecedorBanco.setCnpj(dto.cnpj());
    }

    @Override
    @Transactional
    public void delete(Long id){
        fornecedorRepository.deleteById(id);
    }

    @Override
    public FornecedorResponseDTO  findById(Long id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id);
    if (fornecedor != null) {
        return FornecedorResponseDTO.valueOf(fornecedor);
    }
    
        return FornecedorResponseDTO.valueOf(fornecedorRepository.findById(id));
    }

    @Override
    public List <FornecedorResponseDTO> findAll(){
        return fornecedorRepository.listAll()
                .stream()
                .map(fornecedor -> FornecedorResponseDTO.valueOf(fornecedor))
                .toList();
    }

    @Override
    public List <FornecedorResponseDTO> findByNome(String nome){
        return  fornecedorRepository.findByNome(nome)
                .stream()
                .map(fornecedor -> FornecedorResponseDTO.valueOf(fornecedor))
                .toList();
    }

    @Override
    public List <FornecedorResponseDTO> findByEmailFornecedor(String email){
        return fornecedorRepository.findByEmailFornecedor(email)
                .stream()
                .map(fornecedor -> FornecedorResponseDTO.valueOf(fornecedor))
                .toList();
    }

}
