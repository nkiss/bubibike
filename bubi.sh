#!/bin/bash

# BubiBike Application Management Script
# This script manages the BubiBike application lifecycle, including building, deploying,
# and cleaning up Docker images and containers.

# Exit immediately if a command exits with a non-zero status.
# This ensures that if any step fails, the script will stop executing further commands.

set -e

VERSION=$(./gradlew properties -q | grep "^version:" | awk '{print $2}')

fail() {
    echo ERROR: ${1:-"Unknown error occurred"}
    exit ${2:-1}
}

version() {
	echo "Project version is: $VERSION"	
}

preconditions() {
    # Check if Docker is installed
    if ! command -v docker &> /dev/null; then
        fail "Docker is not installed. Please install Docker and try again." 2
    fi

    # Check if Docker Compose is installed
    if ! command -v docker-compose &> /dev/null; then
        fail "Docker Compose is not installed. Please install Docker Compose and try again." 3
    fi

    # Check if Gradle is installed
    if ! command -v ./gradlew &> /dev/null; then
        fail "Gradle is not installed. Please install Gradle and try again." 4
    fi
}

build() {
	# Build the project JARs
	./gradlew clean build -x test || fail "Gradle build failed. Please check the output for errors." 5
}

test() {
  ./gradlew test jacocoTestReport || fail "Gradle tests failed. Please check the output for errors." 7
  open collector-service/build/reports/jacoco/test/html/index.html || fail "Failed to open test report. Please check the file path." 8
  open persistence-service/build/reports/jacoco/test/html/index.html || fail "Failed to open test report. Please check the file path." 9
}

docker_compose(){
	# Build Docker images with tags
	docker-compose build --no-cache || fail "Docker Compose build failed. Please check the output for errors." 6
	
	echo "Build complete. Version: $VERSION"
	
	docker-compose up
}

cleanup() {
    echo "Cleaning up Docker resources..."
    
    # Remove dangling images
    docker rmi "$(docker images -q --filter "dangling=true")" || true
    
    # Remove intermediate images
    docker rmi "$(docker images -q --filter "label=stage=builder")" || true
    docker rmi "$(docker images -q --filter "label=stage=intermediate")" || true
    
    echo "Cleanup done."
}

create_images() {
	echo "Creating Docker images for BubiBike application..."
    
    # Build Docker images with version tag
	docker build -t bubibike/persistence-service:$VERSION ./persistence-service \
		|| fail "Docker build for persistence-service failed. Please check the output for errors." 11
  docker build -t bubibike/collector-service:$VERSION ./collector-service \
    || fail "Docker build for collector-service failed. Please check the output for errors." 12
}

upload_to_docker_hub() {
    echo "Uploading Docker images to Docker Hub..."
    
    # Login to Docker Hub
    docker login || fail "Docker login failed. Please check your credentials."
    
    # Push images to Docker Hub
    docker push bubibike/persistence-service:$VERSION || fail "Failed to push persistence-service image to Docker Hub." 21
    docker push bubibike/collector-service:$VERSION || fail "Failed to push collector-service image to Docker Hub." 22
    
    echo "Docker images uploaded successfully."
}

delete_volumes() {

    preconditions

    down

    echo "Deleting Docker volumes..."
    docker volume prune -f || fail "Failed to delete Docker volumes." 31
}

release() {
    echo "Releasing BubiBike application..."
    
    # Ensure preconditions are met
    preconditions
    
    # Build the project
    build
    
    # Create Docker images
    create_images
    
    # Upload to Docker Hub
    upload_to_docker_hub
    
}

up() {
	echo "Starting BubiBike application..."
	
	preconditions
    
	version
	
	build
	
	docker_compose
}

down() {
    echo "Stopping BubiBike application..."
    
    # Stop and remove containers, networks, images, and volumes
    docker-compose down --volumes --remove-orphans
    
    cleanup

}

# Check the input argument
case "$1" in
    --build)
        build
        exit 0
        ;;
    --test)
        test
        exit 0
        ;;
    --up)
        up
        exit 0
        ;;
    --down)
        down
        exit 0
        ;;
    --release)
        release
        exit 0
        ;;
    --delete-volumes)
        delete_volumes
        exit 0
        ;;
    --clean)
        cleanup
        exit 0
        ;;
    *)
        echo "Usage: $0 [--build|--up|--down|--release|--generate-schema|--clean]"
        exit 0
        ;;
esac