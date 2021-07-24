<img src="https://raw.githubusercontent.com/drigues90/aluraflix-backend/053f19da2a792ee6d79436501e5f47a47463a25b/alura-challanges.PNG">

# Alura Backend Challenge
<img src="https://img.shields.io/badge/JAVA-11-red"> <img src="https://img.shields.io/badge/Spring%20Boot-2.1.4-green"> <img src="https://img.shields.io/badge/Postgresql-13-blue"> <img src="https://img.shields.io/badge/Docker-19.03.12-blueviolet"> <img src="https://img.shields.io/badge/Maven-3.8.1-ff69b4">

<p align="center">
 <a href="#objetivo">Objetivo</a> •
 <a href="#rng">Regras de Negócio</a> •
 <a href="#executando">Executando a Aplicação</a> • 
 <a href="#testes">Testando Aplicação</a> 
</p>

<h2 id="objetivo"> Objetivo </h2>
Desenvolver uma API backend do zero, aplicando regras de negócio fornecidas pela alura.

<h2 id="rng">Regras de Negócio </h2>
<p> • Implementação da base de dados escolhida, desenvolvimento da API com rotas CRUD para uma entidade e primeiros testes.</p>
<p> • Criação de mais um modelo/entidade, rotas CRUD e relacionais, buscas na base via parâmetros de query, testes de unidade e integração.</p>
<p> • Implementação de mais funcionalidades: paginação, autenticação; deploy da aplicação.</p>

<h2 id="executando"> Executando a Aplicação </h2>
<h3> Pre Requisitos </h3>
<p> • ter previamente o docker instalado e ativo em seu sistema operacional.</p>
<p> • ter as portas 8080 (backend) e 5432 (banco de dados) liberadas em seu sistema operacional, caso as portas citadas estajam indisponivel é possivel alterar as portas do projeto dentro do arquivo docker-compose.yml.</p>
<h3> Iniciando aplicação </h3>
dentro da pasta da aplicação no diretorio raiz executar:

```bash
docker-compose up
```

<h2 id="testes">Testando Aplicação</h2> 
<h4>Rotas disponiveis</h4> 
<p>  /videos 
  
  • GET 
  
  ```bash
curl localhost:8080/videos | json_pp
```

```json
  [
   {
      "descricao" : "o que sao de onde vem e o que comem",
      "id" : 1,
      "titulo" : "Microserviços",
      "url" : "https://www.youtube.com/watch?v=jSnLOoGjQ80"
   },
   {
      "descricao" : "sempre curti",
      "id" : 2,
      "titulo" : "Emuladores",
      "url" : "https://www.youtube.com/watch?v=9qx7qjKhJ1Q"
   },
   {
      "descricao" : "curioso pra assistir",
      "id" : 3,
      "titulo" : "Alura Cases",
      "url" : "https://www.youtube.com/watch?v=Amt8gqUCHB8"
   }
]
```
• POST
```bash
 curl -v -H "Content-Type: application/json" -d '{"titulo":"novo video","descricao":"meu video", "url": "mdjsidjis"}'  http://localhost:8080/videos
```
  
```json
* Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8080 (#0)
> POST /videos HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.68.0
> Accept: */*
> Content-Type: application/json
> Content-Length: 67
>
* upload completely sent off: 67 out of 67 bytes
* Mark bundle as not supporting multiuse
< HTTP/1.1 201
< Location: http://localhost:8080/videos/5
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Sat, 24 Jul 2021 15:36:05 GMT
<
* Connection #0 to host localhost left intact
{"id":5,"titulo":"novo video","descricao":"meu video","url":"mdjsidjis"}
  ```
  
 Metodos • PUT • DELETE também estão implementados.
