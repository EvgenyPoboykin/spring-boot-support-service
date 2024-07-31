
POSTGRES_PORT=5858
POSTGRES_DATA=dblpsupport
POSTGRES_VERSION=postgres

db.container:
	docker run --name ${POSTGRES_DATA} -p ${POSTGRES_PORT}:5432 -e POSTGRES_PASSWORD=${POSTGRES_DATA} -e POSTGRES_USER=${POSTGRES_DATA} -d ${POSTGRES_VERSION}

db.create:
	docker exec -it ${POSTGRES_DATA} createdb --username=${POSTGRES_DATA} --owner=${POSTGRES_DATA} ${POSTGRES_DATA}

container.start:
	docker start ${POSTGRES_DATA}

container.stop:
	@echo "Stop ${POSTGRES_DATA} container..."
	if [ $$(docker ps -q) ]; then \
		echo "Found and stop ${POSTGRES_DATA} container..."; \
		docker stop $$(docker ps -q); \
	else \
		echo "No active ${POSTGRES_DATA} containers!"; \
	fi

project.build:
	gradle build

project.dev:
	./gradlew bootRun

project.api:
	gradle api:publishToMavenLocal
