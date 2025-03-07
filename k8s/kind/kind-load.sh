docker pull mongo:7.0.5
docker pull postgres:15
docker pull confluentinc/cp-zookeeper:7.5.0
docker pull confluentinc/cp-kafka:7.5.0
docker pull confluentinc/cp-schema-registry:7.5.0
docker pull provectuslabs/kafka-ui:latest
docker pull mysql:8
docker pull quay.io/keycloak/keycloak:24.0.1
docker pull mailhog/mailhog:latest
docker pull grafana/loki:main
docker pull prom/prometheus:v2.46.0
docker pull grafana/tempo:2.2.2
docker pull grafana/grafana:10.1.0
docker pull makskud/api-gateway:0.0.1-SNAPSHOT
docker pull makskud/product-service:0.0.1-SNAPSHOT
docker pull makskud/norder-service:0.0.1-SNAPSHOT
docker pull makskud/inventory-service:0.0.1-SNAPSHOT
docker pull makskud/notification-service:0.0.1-SNAPSHOT

kind load docker-image -n microservices mongo:7.0.5
kind load docker-image -n microservices postgres:15
kind load docker-image -n microservices confluentinc/cp-zookeeper:7.5.0
kind load docker-image -n microservices confluentinc/cp-kafka:7.5.0
kind load docker-image -n microservices confluentinc/cp-schema-registry:7.5.0
kind load docker-image -n microservices provectuslabs/kafka-ui:latest
kind load docker-image -n microservices mysql:8
kind load docker-image -n microservices quay.io/keycloak/keycloak:24.0.1
kind load docker-image -n mailhog/mailhog:latest
kind load docker-image -n microservices grafana/loki:main
kind load docker-image -n microservices prom/prometheus:v2.46.0
kind load docker-image -n microservices grafana/tempo:2.2.2
kind load docker-image -n microservices grafana/grafana:10.1.0
kind load docker-image -n microservices makskud/api-gateway:0.0.1-SNAPSHOT
kind load docker-image -n microservices makskud/product-service:0.0.1-SNAPSHOT
kind load docker-image -n microservices makskud/order-service:0.0.1-SNAPSHOT
kind load docker-image -n microservices makskud/inventory-service:0.0.1-SNAPSHOT
kind load docker-image -n microservices makskud/notification-service:0.0.1-SNAPSHOT
