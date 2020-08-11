DROP TABLE IF EXISTS cliente CASCADE;

CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL
);

INSERT INTO cliente (nome) VALUES
('Nicollas Gabriel'),
('Thiago Cardoso');

DROP TABLE IF EXISTS cartao CASCADE;

CREATE TABLE cartao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(12) NOT NULL UNIQUE,
    ativo BOOL NOT NULL DEFAULT FALSE,
    expirado BOOL NOT NULL DEFAULT FALSE,
    cliente_id INT NOT NULL,
    foreign key (cliente_id) references cliente(id)
);

INSERT INTO cartao (numero, cliente_id) VALUES
('123456789', 1),
('987654321', 2);

DROP TABLE IF EXISTS fatura;

CREATE TABLE fatura (
    id INT AUTO_INCREMENT PRIMARY KEY,
    valor_pago DOUBLE NOT NULL,
    pago_em DATE NOT NULL,
    cartao_id INT NOT NULL,
    foreign key (cartao_id) references cartao(id)
);

DROP TABLE IF EXISTS pagamento;

CREATE TABLE pagamento (
     id INT AUTO_INCREMENT PRIMARY KEY,
     descricao VARCHAR(100) NOT NULL,
     valor DOUBLE NOT NULL,
     cartao_id INT NOT NULL,
     foreign key (cartao_id) references cartao(id)
);

INSERT INTO pagamento (descricao, valor, cartao_id) VALUES
('Compra de Cerveja', 300.56, 1),
('Compra de Café', 73.89, 2);