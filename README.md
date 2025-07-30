# LiterAlura: Catálogo de Livros

## Descrição

Este projeto é um catálogo de livros desenvolvido como parte de um desafio proposto pela Alura. O objetivo é construir uma aplicação Spring Boot que consome dados da API Gutendex (uma API gratuita com informações de mais de 70 mil livros) e persiste esses dados em um banco de dados PostgreSQL.

## Funcionalidades

O LiterAlura oferece as seguintes funcionalidades:

*   **Buscar livro pelo título:** Consulta a API Gutendex e insere o livro no banco de dados.
*   **Listar livros registrados:** Exibe todos os livros armazenados no banco de dados.
*   **Listar autores:** Mostra os autores cadastrados no banco de dados, com seus respectivos livros.
*   **Listar autores em determinado ano:** Filtra e exibe os autores que estavam vivos em um determinado ano.
*   **Listar livros em determinado idioma:** Lista os livros disponíveis em um idioma específico (português, inglês, espanhol ou francês).

## Tecnologias Utilizadas

*   Java
*   Spring Boot
*   PostgreSQL
*   Spring Data JPA
*   Maven

## Pré-requisitos

Antes de executar o projeto, você precisa ter instalado:

*   Java Development Kit (JDK) 8 ou superior
*   Maven
*   PostgreSQL

## Configuração

1.  **Banco de Dados:**
    *   Certifique-se de que o PostgreSQL esteja instalado e em execução.
    *   Crie um banco de dados chamado `literalura` (ou ajuste o nome no arquivo de configuração).
    *   Crie uma variavel de ambiente com nome DB_USER e passe o usuario do seu banco de dados e outra com nome DB_PASS e passe a senha do banco de dados e reinicie o computador
    *   Caso não queira criar variaveis de ambiente configure as credenciais de acesso ao banco de dados no arquivo `src/main/resources/application.properties`:

    * Troque de
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost/literalura
    spring.datasource.username=${DB_USER}
    spring.datasource.password=${DB_PASS}
    ```

    *Para
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost/literalura
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_usuario
    ```

## Execução

1.  **Clone o Repositório:**

    ```bash
    git clone https://github.com/Wendell-Dorta/literalura.git
    cd literalura
    ```

2.  **Execute a Aplicação:**

    Abra o projeto em sua IDE (IntelliJ IDEA, Eclipse, etc.) e execute a classe principal `LiteraluraApplication`, que esta em `src/main/br.com.alura.alura_challenge.literalura`.

3.  **Acesse o Menu Interativo:**

    Após a execução, a aplicação exibirá um menu interativo no terminal. Siga as instruções para interagir com o catálogo de livros.

    ```
    1 - Buscar livro pelo título
    2 - Listar livros registrados
    3 - Listar autores
    4 - Listar autores em determinado ano
    5 - Listar livros em determinado idioma
    ```

## Utilização

1.  **Buscar Livro pelo Título:**
    *   Digite `1` e pressione Enter.
    *   Digite o título do livro que deseja buscar e pressione Enter.
    *   O sistema buscará o livro na API Gutendex e o adicionará ao banco de dados.

2.  **Listar Livros Registrados:**
    *   Digite `2` e pressione Enter.
    *   O sistema exibirá todos os livros cadastrados no banco de dados.

3.  **Listar Autores:**
    *   Digite `3` e pressione Enter.
    *   O sistema exibirá todos os autores cadastrados no banco de dados.

4.  **Listar Autores em Determinado Ano:**
    *   Digite `4` e pressione Enter.
    *   Digite o ano desejado e pressione Enter.
    *   O sistema exibirá os autores que estavam vivos no ano especificado.

5.  **Listar Livros em Determinado Idioma:**
    *   Digite `5` e pressione Enter.
    *   Digite o código do idioma desejado (PT, EN, ES, FR) e pressione Enter.
    *   O sistema exibirá os livros disponíveis no idioma especificado.

## API Utilizada

*   [Gutendex API](https://gutendex.com/) - API gratuita com dados de mais de 70 mil livros.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
