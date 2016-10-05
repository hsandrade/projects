# projects

rest-spring-mongo-sample
(Maven Project)


Este projeto prove uma estrutura básica de uma camada serviços REST utilizando persistência NOSQL. A camada de serviços foi construída com base no Spring REST e a camada de persistência com base no Spring Data persistindo em MongoDB.

Para fins de exemplificação existe apenas um serviço mapeado com a segurança oAuth2.

Trata-se de um projeto Maven que após compilado e instalado em um Application Server pode ser testado através dos seguintes exemplos de chamada de serviços:


Registrar um novo Usuário:

URI  : http://localhost:8080/rest-spring-mongo-sample/usuario
Method : POST
Content-Type : application/json

 {
        "id": null,
        "status": null,
        "dataCriacao": null,
        "dataRemocao": null,
        "email": "usuario@usuario.com.br",
        "senha": "123456",
        "nome": "Usuario",
        "dataUltimoAcesso": null
    }

Recuperar um Usuário :

URI  : http://localhost:8080/rest-spring-mongo-sample/usuario/1
Method : GET


Recuperar um Usuário com a camada de segurança oAuth2:

Primeiro passo é se autenticar e recuperar o Token de acesso:
URI : http://localhost:8080/rest-spring-mongo-sample/oauth/token?grant_type=password&client_id=app&client_secret=app&username=usuario@usuario.com.br&password=123456
Method: GET

Com o Token retornado já é possível fazer acesso ao serviço protegido pela camada oAuth2:
URI: http://localhost:8080/rest-spring-mongo-sample/usuario/oAuth2/1/?access_token=10540881-f2e1-4266-84b6-21fa6881a9a9
Method: GET
