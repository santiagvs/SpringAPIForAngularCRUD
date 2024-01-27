# API em Spring para CRUD de Cursos

Back-end do CRUD Angular, feito em Spring que serve para realizar operações de criação, salvamento, atualização e exclusão de cursos, aulas, etc.

## Executando o Projeto com Maven

Para executar o projeto usando o Maven, siga as instruções abaixo:

### Instalação do Maven

Certifique-se de ter o Maven instalado em sua máquina. Você pode baixar o Maven em [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi) e seguir as instruções de instalação.

### Executando o Spring com Maven

Após a instalação do Maven, navegue até o diretório raiz do projeto e execute o seguinte comando para 1) instalar as dependências 2) rodar o servidor Spring:

```bash
mvn install # instalar as dependências

mvn spring-boot:run
```

Para rodar os testes:

```bash
mvn test
```

## Endpoints

| Método | Endpoint         | Descrição                                                                                   |
|--------|------------------|---------------------------------------------------------------------------------------------|
| GET    | /api/courses     | Retorna uma lista de todos os cursos disponíveis.                                           |
| GET    | /api/courses/{id}| Retorna os detalhes de um curso específico com base no ID fornecido.                        |
| POST   | /api/courses     | Cria um novo curso com base nos dados fornecidos no corpo da solicitação.                   |
| PUT    | /api/courses/{id}| Atualiza os detalhes de um curso específico com base no ID fornecido e nos dados fornecidos.|
| DELETE | /api/courses/{id}| Exclui um curso específico com base no ID fornecido.                                        |

## Estrutura do Objeto Curso

Um objeto de curso possui as seguintes propriedades:

- `id` (Long): O ID único do curso.
- `nome` (String): O nome do curso.
- `categoria` (String): A categoria do curso.

## Exemplos de Requisições

### Exemplo de Requisição GET /cursos
