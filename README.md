# ejemplo-auth-server
Proyecto que muestra un server de autenticacion con Outh2, sin incluir recursos


Este proyecto va construyendo paso por paso con las instrucciones de [esta pagina](https://docs.spring.io/spring-security-oauth2-boot/docs/current-SNAPSHOT/reference/htmlsingle/#do-i-need-to-stand-up-my-own-authorization-server)
Debido a que por defecto no todos los tipos de grant estan habilitados, es necesario ir redefiniendo
algunos beans para que funcione (ver historial de commits).



### Probar que funciona

- **client_credentials**
> curl first-client:noonewilleverguess@localhost:8080/oauth/token -dgrant_type=client_credentials  

Debería autenticar como el cliente

- **authorization_code**
  - Ir a  http://localhost:8080/oauth/authorize?grant_type=authorization_code&response_type=code&client_id=first-client&state=1234
  - Loguear como enduser:password  
  - Redirige a  http://localhost:8081/oauth/login/client-app una vez aprobado
  
- **password**
  - Ignorar el annotation de @Configurtation en  AuthorizationServerConfiguration
> curl first-client:noonewilleverguess@localhost:8080/oauth/token -dgrant_type=password -dusername=enduser-d password=password  
   

