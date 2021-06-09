# Desafio App Reclamação

Aplicação desenvolvida com Java 11 Spring boot e Spring data JPA, utilizando banco de dados Nosql Mongodb. Antes de executar certifique-se de ter instalado em sua máquina a JDK 11, Git e Maven.

##Rodar com o Docker
Certifique-se de ter o docker instalado na máquina

`docker run -d -p 8080:8080 brunomktd/app-reclamacao:alpha`

##Rodar com Maven

Faça o download da aplicação:

`git clone https://github.com/brunomktd/reclamacao-app.git`

Acesse a pasta da aplicação onde contém o pom.xml e rode os seguintes comandos:

`mvn clean install -DskipTests`

`java -jar target/app-0.0.1-SNAPSHOT.jar`

###Rotas para consultas:

####Empresa

Cadastrar empresa:
`POST: http://localhost:8080/empresas`

Atualizar:
`PUT http://localhost:8080/empresas/empresa/{id}`

body:
`{
    "nome": "String"
}`

Buscar todas empresas:`GET http://localhost:8080/empresas `


Buscar empresa por Id: `GET http://localhost:8080/empresas/empresa/{id}`

####Reclamações:

Registrar Reclamação
`POST http://localhost:8080/reclamacoes/empresa/{empresaId}`

body:
`{
    "titulo": "String",
    "descricao": "String",
    "localidade": "String"
}`

Buscar reclamações por empresa: `GET http://localhost:8080/reclamacoes/empresa/{empresaId}`

