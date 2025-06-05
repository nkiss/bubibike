#!/bin/bash
# build.sh

set -e

VERSION=$(grep "^version" build.gradle | sed "s/version *= *['\"]\([^'\"]*\)['\"]/\1/")
echo "Project version is: $VERSION"

# Build the project JARs
./gradlew clean build -x test

# Copy fat JAR to predictable name for Docker build
cp collector-service/build/libs/collector-service-$VERSION.jar collector-service/build/libs/app.jar

# Build Docker images with tags
docker-compose build

echo "Build complete. Version: $VERSION"
