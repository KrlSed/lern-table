# Getting Started


### DOCKER STARTt

docker run --name new-postgres --volume db-data:/var/lib/postgresql/data -e 
POSTGRES_PASSWORD=specialpass -e POSTGRES_DB=payservice -p 5434:5432 postgres:12-alpine