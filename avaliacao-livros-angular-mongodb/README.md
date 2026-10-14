# Avaliação de Livros — Angular + Spring Boot + MongoDB

Projeto acadêmico com **front-end Angular 20**, **back-end Java 17 / Spring Boot 3.5** e **MongoDB**.

## Requisitos
- Node.js compatível com Angular 20 (recomendado 22.12+)
- Java 17 ou superior
- Maven 3.9+ (ou executar pelo IntelliJ)
- Docker Desktop com Docker Compose (para o MongoDB)

## Executar
1. Na pasta raiz, abra o Docker Desktop e execute `docker compose up -d`.
2. Abra a pasta `backend` no IntelliJ e execute `ApiAvaliacaoLivrosApplication`, ou rode `mvn spring-boot:run` dentro de `backend`.
3. Em outro terminal, entre na pasta `frontend`, rode `npm install` e `npm start`.
4. Abra `http://localhost:4200`.

## Integração
- O Angular usa `HttpClient` para requisições REST à API em `http://localhost:8080`.
- O Spring Boot usa `spring-boot-starter-data-mongodb` para persistir livros e avaliações no banco `avaliacao_livros` em `mongodb://localhost:27017`.
- O banco é persistido no volume Docker `livros_data`.
- O CORS está liberado para `http://localhost:4200`.

## Rotas da API
- `GET /livros`, `GET /livros/{id}`, `POST /livros`, `PUT /livros/{id}`, `DELETE /livros/{id}`.
- `GET /avaliacoes`, `GET /avaliacoes/{id}`, `GET /avaliacoes/livro/{livroId}`, `POST /avaliacoes`, `PUT /avaliacoes/{id}`, `DELETE /avaliacoes/{id}`.

### Exemplo para POST /livros
```json
{"titulo":"Dom Casmurro","autor":"Machado de Assis","genero":"Romance","anoPublicacao":1899}
```

### Exemplo para POST /avaliacoes
```json
{"livroId":"ID_RETORNADO_PELO_MONGODB","nomeUsuario":"Ana","nota":5,"comentario":"Gostei muito."}
```

**Atenção:** o MongoDB usa IDs do tipo `String` (ObjectId representado como texto), diferentes dos IDs numéricos do antigo banco H2. O front-end foi atualizado para isso. A API antiga baseada em JPA/H2 foi substituída por Spring Data MongoDB. Os dados antigos do H2 não são migrados automaticamente.

Se a porta 27017 já estiver ocupada por outro MongoDB local, pare esse serviço ou ajuste a configuração do Docker. É necessário iniciar os três componentes para testar a integração completa.
