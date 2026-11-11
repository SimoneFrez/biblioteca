-- Dados de teste

INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel) VALUES
(1, 'Dom Casmurro', 'livro', 'Machado de Assis', NULL, FALSE),
(2, 'O Cortico', 'livro', 'Aluisio Azevedo', NULL, TRUE),
(3, 'Capitaes da Areia', 'livro', 'Jorge Amado', NULL, TRUE),
(4, 'Superinteressante', 'revista', NULL, 450, TRUE),
(5, 'Veja', 'revista', NULL, 2800, TRUE);

INSERT INTO usuario (nome, tipo, limite_itens) VALUES
('Maria', 'aluno', 3),
('Carlos', 'professor', 5);

-- Emprestimo 1: Maria com o Dom Casmurro, ainda em aberto
-- Emprestimo 2: Carlos com a Superinteressante, ja devolvida com 3 dias de atraso (3 x R$ 1,00)
INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa) VALUES
(1, 1, '2026-11-03', '2026-11-17', NULL, 0),
(4, 2, '2026-10-01', '2026-10-08', '2026-10-11', 3.00);
