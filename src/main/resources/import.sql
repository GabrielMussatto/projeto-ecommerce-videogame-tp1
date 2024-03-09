-- Inserção de dados para a tabela Produto
INSERT INTO Produto (id, marca, modelo, cor, preco) VALUES (1, 'Sony', 'PlayStation 5', 'Preto', 4999.99);
INSERT INTO Produto (id, marca, modelo, cor, preco) VALUES (2,'Microsoft', 'Xbox Series X', 'Branco', 4999.99);
INSERT INTO Produto (id, marca, modelo, cor, preco) VALUES (3,'Nintendo', 'Switch', 'Azul', 2999.99);

-- Inserção de dados para a tabela Fornecedor
INSERT INTO Fornecedor (id, nome, telefone, localLojaFornecedor, email, cnpj) VALUES (1, 'GameStore', '(63) 98765-4321', 'Rua Principal, 123', 'gamestore@example.com', '11.222.345/0001-63');

-- Inserção de dados para a tabela Cliente
INSERT INTO Cliente (nome, sobrenome, email, telefone, endereco, cpf, dataNascimento, dataCadastro) VALUES (1, 'João', 'Silva', 'joao@example.com', '(63) 912345678', 'Rua A, 456', '123.456.789-00', '1990-01-15', CURRENT_DATE);


INSERT INTO ProdutoFornecedor (id_produto, id_fornecedor) VALUES (1, 1);
INSERT INTO ProdutoFornecedor (id_produto, id_fornecedor) VALUES (2, 1);
INSERT INTO ProdutoFornecedor (id_produto, id_fornecedor) VALUES (3, 1);