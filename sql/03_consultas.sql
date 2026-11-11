-- 1) Todo o acervo
SELECT codigo, titulo, tipo, disponivel
FROM item;

-- 2) Emprestimos em aberto, com nome do usuario e titulo do item
SELECT u.nome, i.titulo, e.data_retirada, e.data_devolucao_prevista
FROM emprestimo e
JOIN usuario u ON u.id = e.usuario_id
JOIN item i ON i.id = e.item_id
WHERE e.data_devolucao IS NULL;

-- 3) Total de multas por usuario
SELECT u.nome, SUM(e.valor_multa) AS total_multas
FROM emprestimo e
JOIN usuario u ON u.id = e.usuario_id
GROUP BY u.nome;

-- 4) Itens que nunca foram emprestados
SELECT i.codigo, i.titulo
FROM item i
LEFT JOIN emprestimo e ON e.item_id = i.id
WHERE e.id IS NULL;
