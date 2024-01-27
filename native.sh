#!/usr/bin/env bash

# Check if the correct number of arguments is provided
if [ "$#" -ne 1 ]; then
    echo "Usage: $0 must contains one of arguments [mvn-build|docker-build]"
    exit 1
fi

mvn_build(){
  ./mvnw -DskipTests -Pnative clean package
  echo "✔ Native image is created...✅"
}

docker_build() {
  mvn_build
  docker build -t graal-demo:v1  --build-arg APP_FILE=target/demo .
  echo "✔ Docker image with native image is created...✅"
}


# Execute the appropriate function based on the command-line argument
case "$1" in
    mvn-build)
        mvn_build
        ;;
    docker-build)
        docker_build
        ;;
    *)
        echo "Invalid argument. Usage: $0 [mvn-build|docker-build]"
        exit 1
        ;;
esac
