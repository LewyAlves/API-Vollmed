# API VollMed

Bem-vindo à API VollMed! A VollMed é uma clínica fictícia que oferece um conjunto de endpoints para facilitar o gerenciamento de médicos, pacientes e agendamentos de consultas. Esta API permite a integração simples e eficaz com o aplicativo da VollMed.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal.
- **Spring Boot**: Framework para criação de aplicativos Java baseados em microservices.
- **MySQL**: Banco de dados relacional utilizado para armazenar dados da API.

## Como Setar o Projeto

Siga as instruções abaixo para configurar e executar o projeto:

1. **Certifique-se de ter o Java 17 instalado:**

    Verifique se o Java 17 está instalado em sua máquina executando o seguinte comando no terminal:

    ```bash
    java -version
    ```

    Se o Java 17 não estiver instalado, faça o download e a instalação a partir do [site oficial da Oracle](https://www.oracle.com/java/technologies/javase-downloads.html).

2. **Clone o repositório:**

    ```bash
    git clone https://github.com/LewyAlves/API-Vollmed
    ```

3. **Acesse o diretório do projeto:**

    ```bash
    cd api-vollmed
    ```

4. **Configure as propriedades do banco de dados:**

    Abra o arquivo `application.properties` e ajuste as configurações do banco de dados MySQL.

5. **Execute o projeto:**

    Você pode usar sua IDE preferida ou executar o seguinte comando no terminal:

    ```bash
    ./mvnw spring-boot:run
    ```

    Certifique-se de ter o Maven instalado em sua máquina.

6. **Acesse a API:**

    A API estará disponível em `http://localhost:8080`.
   
## Licença

Esta API é distribuída sob a licença da empresa Alura, concedida pelo instrutor Rodrigo Ferreira.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para reportar problemas, sugerir melhorias ou enviar pull requests.

