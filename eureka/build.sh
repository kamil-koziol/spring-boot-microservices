#!/usr/bin/env bash

# Builds application and docker image using Dockerfile and tags it based on org.opencontainers.image.version label in
# Dockerfile.

#######################################
# Script main function. Builds applicaiton and docker image using Dockerfile and tags it based on
# org.opencontainers.image.version label in Dockerfile.
# Arguments:
#   None.
#######################################


function main() {
    ./mvnw clean verify -Dmaven.test.skip=true
    title="eureka"
    version="1.0.0"
    docker build \
      --label "org.opencontainers.image.created=$(date +%Y-%m-%dT%H:%M:%S%:z)" \
      --label "org.opencontainers.image.ref.name=$(git rev-parse HEAD)" \
      --label "org.opencontainers.image.revision=$(git rev-parse HEAD)" \
      -t "${title}":"${version}" .
}

main "$@"
