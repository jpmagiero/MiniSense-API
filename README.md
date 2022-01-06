<div align="center">
 <h1>Minisense - API</h1>
 <p>Api desenvolvida visando o gerenciamento de sensores Iot, permitindo tanto configuração quanto obtenção de dados de seus sensores cadastrados.</p>
</div>

<img src="https://img.shields.io/static/v1?label=License&message=MIT&color=7159c1&style=for-the-badge&logo=ghost"/>

### 📁 Index

- [Objetivo](#%EF%B8%8F-objetivo)
- [Pré-requisitos](#%EF%B8%8F-pré-requisitos)
- [Criando banco de dados e sua conexão](#%EF%B8%8F-criando-banco-de-dados-e-sua-conexão)
- [Rodando o BackEnd](#%EF%B8%8F-rodando-o-backend)
- [Tecnologias](#-tecnologias)
- [Funcionalidades](#-funcionalidades)
- [Problemas a serem resolvidos](#-problemas-a-serem-resolvidos)

### ✔️ Objetivo
<p> 
A API MiniSense foi desenvolvida com objetivo de facilitar o monitoramento de sensores IoT.
<p>
<p>
  Após se cadastrar, o usuário poderá ter acesso aos dados de todos os sensores em seu nome, modificá-los e excluí-los se necessário.
<p> 

### ✔️ Pré-requisitos
<p>Antes de começar, será necessario as seguintes ferramentas:</p>
<p align="center">
	<a href="https://www.oracle.com/java/technologies/javase/jdk16-archive-downloads.html">JDK-16</a> •
 	<a href="https://dev.mysql.com/downloads/installer/">Mysql</a> •
  IDE JAVA
</p>

### 🗄️ Criando banco de dados e sua conexão

<ol>
	<li>Abra o MySql Workbench após a instalação e configuração do MySql</li>
	<li>Com o programa aberto crie uma conexão, clicando no simbolo '+', ao lado de "MySQL connections"</li>
	<li>No campo port, atribua: 3306</li>
 	<li>No campo username, atribua: root (Ou o username utilizado na configuração feita no Mysql)</li>
  <li>Clique em OK para finalizar a conexão</li>
  <li>Clique na conexão criada e insira a senha do usuario root</li>
  <li>Dentro do ambiente abra um SQL File</li>
  <li>Execute o código "create database minisenseapi"</li>
</ol>

### ⚙️ Rodando o BackEnd
<ol>
<li>Realize o dowload ou clone do repositorio</li>
<li>Extraia o projeto do rar</li>
<li>Acesse a pasta MiniSense-Api pela IDE Java de sua preferência</li>
  <li>Caso a senha do seu usuário root do banco for diferente de MiniSenseApi, abra a pasta application.properties e troque o valor de "spring.datasource.password = MiniSenseApi" para "spring.datasource.password = Sua senha"</li>
  <li>Execute a pasta MiniSenseApiApplication</li>
	<li>O servidor inciará na porta: localhost:8080</li>
</ol>

### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [Spring](https://start.spring.io/)
- [Mysql](https://www.mysql.com/)
- [IntelliJ](https://www.jetbrains.com/pt-br/idea/)
- [Hibernate](https://hibernate.org/)
- [Swagger](http://localhost:8080/swagger-ui.html) - Clicar após subir a aplicação

### 📁 Funcionalidades
##### Usuario
- [x] Cadastro de usuário
- [x] Pesquisar todos usuários
- [x] Pesquisar por usuário
- [x] Peaquisar todos sensores de um usuário
- [x] Deleta um usuário
- [x] Atualiza um usuário
##### Sensor
- [x] Cadastro de sensores
- [x] Peaquisar todos sensores
- [x] Peaquisar um sensor
- [x] Peaquisar todos sensores de um usuário
- [ ] Recupera os ultimos 5 dados de sensor de um cada stream
- [x] Deleta um sensor
- [x] Atualiza um sensor
##### Unidade de medida
- [x] Cadastro de unidade de medida
- [x] Peaquisar todas unidades de medida
- [x] Peaquisar uma unidade de medida
- [x] Deleta uma unidade de medida
- [x] Atualiza uma unidade de medida
##### Stream
- [x] Cadastro de stream
- [x] Peaquisar todos streams
- [x] Peaquisar uma stream
- [x] Recupera todos dados de sensor de um stream
- [x] Deleta um stream
- [x] Atualiza um stream
##### Dado de sensor
- [x] Cadastro de dado de sensor
- [x] Peaquisar todos dados de sensor
- [x] Peaquisar um dado de sensor
- [x] Peaquisar todos dado de sensor de um usuário
- [x] Deleta um dado de sensor
- [x] Atualiza um dado de sensor

### 🔴 Problemas a serem resolvidos
- "MeasurementCount" atualmente não está fazendo a contagem de todas as medições armazenadas.

### 🔴 Exemplos JSON
- Criar usuário:
{
  "email": "teste",
  "name": "teste"
}

- Update usuário:
{
  "email": "Testeupdate",
  "id": 1,
  "name": "teste"
}

- Criar sensor:
{
  "description": "Sensor 1",
  "label": "Sensor 1",
  "userId": 1
}

- Sensor update:
{
  "description": "Sensor 1",
  "id": 1,
  "label": "Sensor teste update",
  "userId": 1
}

- Criar sensor data:
{
  "timesTamp": "20202022",
  "value": 70
}

- Update sensor data:
{
  "id": 1,
  "timesTamp": "202022",
  "value": 100
}

- Criar o measurementunit:
{
  "description": "Graus",
  "symbol": "C"
}

- Update measurementUnit:
{
  "description": "Graus",
  "id": 1,
  "symbol": "F"
}

- Criar DataStream:
{
  "label": "Teste Stream",
  "measurementUnitId": 1,
  "sensorDataId": 1,
  "sensorId": 1
}

- Update no DataStream:
- {
    "id": 1,
    "streamKey": "Teste  update",
    "label": "Teste  update",
    "enabled": null,
    "sensor": {
        "id": 1,
        "label": "Sensor teste update",
        "description": "Sensor 1",
        "user": {
            "id": 1,
            "name": "teste",
            "email": "Testeupdate"
        },
        "key": "ff6de8ca-d887-475e-a017-1d46a23fd6b9"
    },
    "sensorData": {
        "id": 1,
        "value": 100.0,
        "timesTamp": "202022"
    },
    "measurementUnit": {
        "id": 4,
        "symbol": "F",
        "description": "Graus"
    }
}
