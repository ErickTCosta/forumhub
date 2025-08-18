ALTER TABLE topicos DROP INDEX idx_mensagem;

ALTER TABLE topicos ADD CONSTRAINT uk_topico UNIQUE (titulo, mensagem);
