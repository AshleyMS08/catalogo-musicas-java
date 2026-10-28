# 🎵 Sistema de Catálogo de Músicas (POO + JDBC)

Projeto acadêmico em Java para gerenciamento de um catálogo musical, demonstrando conceitos de Programação Orientada a Objetos (Herança e Polimorfismo) e integração com banco de dados MySQL via JDBC.

## 📌 Funcionalidades
- **Cadastro de Música Digital**: Registra informações gerais e específicas (tamanho em MB e formato do arquivo).
- **Cadastro de Música em Vinil**: Registra informações gerais e específicas (velocidade em RPM e estado de conservação).
- **Listagem Unificada**: Exibe todas as músicas cadastradas utilizando polimorfismo.
- **Persistência Relacional**: Gravação e leitura em tabela do MySQL com padronização via Data Access Object (DAO).

## 📐 Estrutura de Classes (Herança)
- `Musica` (Classe Abstrata Base)
    - `MusicaDigital` (Herda de `Musica`)
    - `MusicaVinil` (Herda de `Musica`)

## 🛠️ Tecnologias Utilizadas
- Java 17+
- MySQL Server 8.0+
- MySQL Connector/J (`mysql-connector-j-8.x.x.jar`)

## 🚀 Como Executar

### 1. Configurar o Banco de Dados
Execute o script abaixo no seu SGBD MySQL:

```sql
CREATE DATABASE catalogo_musicas;
USE catalogo_musicas;

CREATE TABLE musica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    artista VARCHAR(100) NOT NULL,
    duracao_segundos INT NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    tamanho_mb DOUBLE NULL,
    formato VARCHAR(10) NULL,
    rpm INT NULL,
    condicao VARCHAR(30) NULL
);