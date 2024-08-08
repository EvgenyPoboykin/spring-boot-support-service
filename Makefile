
POSTGRES_PORT=5858
POSTGRES_DATA=dbsupport
POSTGRES_VERSION=postgres

db.container:
	docker run --name ${POSTGRES_DATA} -p ${POSTGRES_PORT}:5432 -e POSTGRES_PASSWORD=${POSTGRES_DATA} -e POSTGRES_USER=${POSTGRES_DATA} -d ${POSTGRES_VERSION}

d.stop:
	killall docker

d.start:
	open /Applications/Docker.app

container.start:
	@echo "Start ${POSTGRES_DATA} container..."
	if [ $$(docker ps -q) ]; then \
  		echo "Container ${POSTGRES_DATA} is started!"; \
	else \
		echo "Start ${POSTGRES_DATA} container..."; \
		docker start ${POSTGRES_DATA}; \
	fi

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

project.dev: container.start project.build
	./gradlew bootRun
