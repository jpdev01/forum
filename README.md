- Spring Boot com Kotlin
- REST API
- Spring Data JPA
- Flyway como ferramenta de migrations
- Cache do Spring para melhorar a performance de consultas (no endpoint)
- spring-security para trabalhar com autenticação e autorização de usuários
- Autenticação com JWT
- Conteineriza a aplicação
- Sobe usando heroku

### Para subir via docker
#### 1- Fazer build da imagem
```
sudo docker build -t forum -f Dockerfile .
```
#### 2- Executar a aplicação
```
docker run -p 3080:8080 forum
```
