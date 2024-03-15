package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.FornecedorDTO;
import br.unitins.tp1.dto.FornecedorResponseDTO;
import jakarta.validation.Valid;

public interface FornecedorService {
    public FornecedorResponseDTO create(@Valid FornecedorDTO dto);
    public void update (Long id, FornecedorDTO dto);
    public void delete(Long id);
    public FornecedorResponseDTO findById(Long id);
    public List <FornecedorResponseDTO> findAll();
    public List <FornecedorResponseDTO> findByNome(String nome);
    public List <FornecedorResponseDTO> findByEmailFornecedor(String email);
}
