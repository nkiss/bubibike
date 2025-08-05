#!/usr/bin/env bash

set -e

#Constants
export ENVIRONMENT=dev
export PROJECT_NAME=bubibike-${ENVIRONMENT}
export PROJECT_ID=bubibike-${ENVIRONMENT}
export REGION=europe-central2
export CLUSTER_NAME=bubibike-${ENVIRONMENT}-cluster

fail() {
    echo "ERROR: ${1:-"Unknown error occurred"}"
    exit ${2:-1}
}

set_project() {
  if [[ -z "${PROJECT_ID}" ]]; then
    gcloud config set project "${PROJECT_ID}" || fail "Failed to set GCP project to ${PROJECT_ID}" 1
  fi
}