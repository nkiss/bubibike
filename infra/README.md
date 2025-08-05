# BubIBike Cloud Infrastructure

## GKE

I'm using Google Kubernetes Engine (GKE) to run the BubIBike application. GKE is a managed Kubernetes service that simplifies deploying, managing, and scaling containerized applications using Google Cloud's infrastructure. 

1. Set constants:
    ```bash
    ```
2. Create a project, and swith to it
    ```bash
    gcloud projects create bubibike --set-as-default
    ```
   or if its already created, switch to it:
    ```bash
    gcloud config set project bubibike
    ```
3. Enable GKE API services
    ```bash
    gcloud services enable container.googleapis.com \
    cloudresourcemanager.googleapis.com \
    compute.googleapis.com
   ```
4. Create the autopilot cluster. GKE Autopilot is a mode of operation in GKE in which Google manages your cluster configuration, including your nodes, scaling, security, and other preconfigured settings.
    ```bash
    gcloud container clusters create-auto bubibike-dev-cluster \
    --region europe-central2 \
    --release-channel regular
    ```
5. Get the credentials for the cluster. This configures kubectl to talk to your cluster.
    ```bash
    gcloud container clusters get-credentials bubibike-dev-cluster \
    --region europe-central2
    ```
6. Create namespace
    ```bash
    kubectl create namespace bubibike
    ```
7. Verify the cluster is running
- In the GCP console → Kubernetes Engine → Workloads
    ```bash
    kubectl get nodes
    kubectl get pods --all-namespaces
    ```
8. Install RabbitMQ with management plugin
    ```bash
    helm repo add bitnami https://charts.bitnami.com/bitnami
    helm repo update
    
    helm install rabbitmq bitnami/rabbitmq \
    --namespace bubibike --create-namespace \
    --set auth.username=admin \
    --set auth.password=adminpassword \
    --set auth.erlangCookie=secretcookie123 \
    --set service.type=LoadBalancer
    ```
    or    
    ```bash
    helm install rabbitmq bitnami/rabbitmq \
     -n bubibike --create-namespace \
     -f infra/k8s/rabbitmq/values.yaml
   ```
9. Create Cloud SQL secret
    ```bash
    kubectl apply -f infra/k8s/secrets/sql-credentials.yaml -n bubibike
    ```
10. Create Cloud SQL instance
    ```bash
    gcloud sql instances create bubibike-dev-db \
    --database-version=POSTGRES_15 \
    --region=europe-central2 \
    --tier=db-f1-micro \
    --storage-auto-increase
    ```
11. Collector service deployment
    ```bash
    kubectl apply -f infra/k8s/collector-service/deployment.yaml -n bubibike
    ```
12. Persistence service service
    ```bash
    kubectl apply -f infra/k8s/persistence-service/deployment.yaml -n bubibike
    ```
## Cleanup

1. Delete namespace when done
    ```bash
    kubectl delete namespace bubibike
    ```
2. Delete the cluster when done
    ```bash
    gcloud container clusters delete bubibike-dev-cluster --region europe-central2
    ```
3. Delete bubibike-dev-db Cloud SQL instance
    ```bash
    gcloud sql instances delete bubibike-dev-db
    ```