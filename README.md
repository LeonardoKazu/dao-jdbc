<h1 align="center">Dao - JDBC <h1/>

## Descrição : Projeto realizado para treinar Java com sua API JDBC.
 Este projeto tem como ideia buscar, inserir, modificar e deletar informações do DB temos sellers(vendedores) e departments(departamentos). 

## Pré-requisitos : 
  Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas :
  [Git](https://git-scm.com), [Java](https://www.java.com/pt-BR/), [MySQL](https://www.mysql.com/downloads/). 
  
  Além disto é bom ter um editor para trabalhar com o código como [IntelliJ](https://www.jetbrains.com/idea/download/?section=windows) obs: Foi utilizado a versão Community Edition(gratuito)

  No seu MySQL crie um DB para teste e execute : 
  ------------------------------------
⚠️ATENÇÃO⚠️
Todos dados informados abaixo são fictícios! 
------------------------------------
  ```sql
  CREATE TABLE department (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) DEFAULT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE seller (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) NOT NULL,
  Email varchar(100) NOT NULL,
  BirthDate datetime NOT NULL,
  BaseSalary double NOT NULL,
  DepartmentId int(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (DepartmentId) REFERENCES department (id)
);

INSERT INTO department (Name) VALUES 
  ('Computers'),
  ('Electronics'),
  ('Fashion'),
  ('Books');

INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES 
  ('Bob Brown','bob@gmail.com','1998-04-21 00:00:00',1000,1),
  ('Maria Green','maria@gmail.com','1979-12-31 00:00:00',3500,2),
  ('Alex Grey','alex@gmail.com','1988-01-15 00:00:00',2200,1),
  ('Martha Red','martha@gmail.com','1993-11-30 00:00:00',3000,4),
  ('Donald Blue','donald@gmail.com','2000-01-09 00:00:00',4000,3),
  ('Alex Pink','bob@gmail.com','1997-03-04 00:00:00',3000,2); 
  ```

## Clone este repositório :
$ git clone https://github.com/LeonardoKazu/dao-jdbc.git

após clonar o projeto modifique o arquivo [db.properties] colocando o seu user/password e dburl(caminho do BancoDeDados que será acessado) troque o caminho [ /coursejdbc ] para 
[ /exemplo ] <- BancoDeDados que você criou para o teste.

## Testar o código! :
Para testar este código vá em application e use Program ou Program2, os executáveis estão separados apenas para ser mais simples de se entender pois 1 modifica (seller) e o outro apenas (department), espero que esteja de simples compreensão caso haja dúvidas ou sugestões me disponho a respondê-las!. 
