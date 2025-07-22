#!/bin/bash
# build.sh

set -e

VERSION=$(grep "^version" build.gradle | sed "s/version *= *['\"]\([^'\"]*\)['\"]/\1/")
echo "Project version is: $VERSION"

# Build the project JARs
./gradlew clean build -x test

# Build Docker images with tags
docker-compose build --no-cache

echo "Build complete. Version: $VERSION"

docker-compose up
