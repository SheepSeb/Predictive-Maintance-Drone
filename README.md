# Predictive Maintenance for Drone

This should be used with the [Go Producer](https://github.com/SheepSeb/Go-Drone-Mocking-Producer) that will produce data about drones and their components. The Kafka Cluster is in the ```docker-compose.yml``` file from the Go Producer repository. Another part is the Postgres Database which you can start using the following command:
```bash
docker run --name drone-postgres -e POSTGRES_PASSWORD=secretpass -p 5432:5432 -d postgres
```
