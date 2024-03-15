package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.dto.ProdutoDTO;
import br.unitins.tp1.dto.ProdutoResponseDTO;
import jakarta.validation.Valid;

public interface ProdutoService {
    
    public ProdutoResponseDTO create(@Valid ProdutoDTO dto);
    public void update(Long id, ProdutoDTO dto);
    public void delete(Long id);
    public ProdutoResponseDTO findById(Long id);
    public List<ProdutoResponseDTO> findAll();
    public List<ProdutoResponseDTO> findByMarca(String marca);
    public List<ProdutoResponseDTO> findByModelo(String modelo);
}
