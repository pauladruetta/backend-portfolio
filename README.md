# backend-portfolio

Este repositorio corresponde a la API de mi portfolio, la misma fue realizada para el curso de Argentina Programa #YoProgramo.

El frontend del portfolio se puede consultar en este link:
[Link al repositorio del frontend](https://github.com/pauladruetta/frontendPortfolio)

## End points

 Esta api cuenta con los siguientes end points(para mayor claridad ver: [Link a Swagger UI](https://back-portfolionan.herokuapp.com/swagger-ui/index.html ):
 
 * /persona
   - /new
   - /edit/{id}
   - /ver-todas
   - /delete/{id}
   - /personal-info/{id}
   - /details/{id}
 * /auth
   - /newUser
   - /login
 * /educacion
   - /{id}
   - /new
   - /edit/{id}
   - /ver-todas
   - /delete/{id}
   - /persona/{id}
 * /proyecto
   - /{id}
   - /new
   - /edit/{id}
   - /ver-todos
   - /delete/{id}
   - /persona/{id}
 * /experiencia
   - /{id}
   - /new
   - /edit/{id}
   - /ver-todas
   - /delete/{id}
   - /persona/{id}
 * /habilidad
   - /{id}
   - /new
   - /edit/{id}
   - /ver-todas
   - /delete/{id}
   - /persona/{id}
 * /habilidadPersona
   - /{id}
   - /new
   - /edit/{id}
   - /ver-todas
   - /delete/{id}
   - /persona/{idPersona}
   - /noPersona/{idPersona}


## JWT

Esta api tiene implementada autenticación con JSON Web Token (JWT) y cuenta con dos tipos de roles de usuario, USER y ADMIN, con diferentes posibilidades de acceso a los diferentes end points.

## Propiedades
El archivo de propiedades del back (application.properties) se encuentra sólo en el repositorio local. Mediante el archivo gitignore, se elimina el archivo de propiedades del repositorio remoto, esto se realiza por cuestiones de seguridad (ya que es inforamción sensible), las variables del mismo se implementan directamente en Heroku.

### DATA BASE
~~~
 #spring.datasource.url = jdbc:mysql://
 #spring.datasource.username=
 #spring.datasource.password=


 spring.jpa.hibernate.ddl-auto=update
 spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

/* server.port=8282 */`
~~~

### Security
~~~
 jwt.secret = 
 wt.expiration = 
~~~

## Esquema Base de datos

![Esquema Base de datos](https://github.com/pauladruetta/backend-portfolio/blob/main/ModelBD.png)
