#Módulo 35: Projeto JPA com Testes

Este projeto utiliza **Java Persistence API (JPA)** para gerenciar entidades como **Cliente, Produto e Venda**, com persistência no banco **PostgreSQL**. Os testes foram desenvolvidos usando **JUnit 4**.

## Estrutura do Projeto

- **Entidades**:
  - `Cliente`: Representa um cliente com informações como CPF, nome e endereço.
  - `Produto`: Define os produtos disponíveis para venda.
  - `Venda`: Armazena vendas realizadas e sua relação com produtos e clientes.

- **Relacionamentos**:
  - `Venda` possui um relacionamento **@ManyToOne** com `Cliente`.
  - `Venda` e `Produto` possuem relação **@ManyToMany**, representando os produtos em cada venda.

## Funcionalidades Testadas

Os testes cobrem operações básicas de um sistema de vendas:
- **Cadastrar Cliente e Produto**  
- **Salvar uma Venda**  
- **Adicionar e Remover Produtos de uma Venda**  
- **Cancelar e Finalizar uma Venda**  

## Tecnologias Utilizadas

- **Java 8+**
- **JPA (Java Persistence API)**
- **PostgreSQL**
- **JUnit 4**
