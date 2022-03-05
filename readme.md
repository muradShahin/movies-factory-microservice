# Movies Factory Rest API
# Created by Murad Shahin
- Main class com.moviesmms.moviesfactory.MoviesFactoryApplication 
- You cannot run this app on local as it is configured to run on port 8000 

### Creating Containers

- mvn clean package
- docker run --publish 8000:8000 muradshahin/movies-factory-movies-factory:0.1.15-SNAPSHOT



## Test URLs

- http://localhost:8000/api/movies-microservice/movies-factory/get



- http://localhost:8000/api/movies-microservice/movies-factory/get2


- http://localhost:8000/
