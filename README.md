# backend-portfolio
Este repositorio corresponde a la API de mi portfolio, la misma fue realizada para el curso de Argentina Programa #YoProgramo.

[Link al repositorio de la API](https://github.com/pauladruetta/frontendPortfolio)

[ ] Explicar características de la API
[ ] End points
[ ] JWT

El archivo de propiedades del back (application.properties) se encuentra sólo en el repositorio local. MEdiate el gitignore se elimina del repositorio remoto por seguridad (inforamción sensible), las variables del mismo se implementan directamente en Heroku.

## DATA BASE
~~~
 #spring.datasource.url = jdbc:mysql://
 #spring.datasource.username=
 #spring.datasource.password=


 spring.jpa.hibernate.ddl-auto=update
 spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

/* server.port=8282 */`
~~~

## Security
~~~
 jwt.secret = 
 wt.expiration = 
~~~

## Esquema Base de datos

![Esquema Base de datos](https://github.com/pauladruetta/backend-portfolio/blob/main/ModelBD.png)
