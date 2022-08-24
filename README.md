# backend-portfolio
Backend del portfolio para Argentina Programa

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

![Modelo Base de Datos][https://drive.google.com/file/d/1VD8oSrijJxIVisDYRYED6saHng5DtoXw/view?usp=sharing]


## Security
~~~
 jwt.secret = 
 wt.expiration = 
~~~


