## Start Minikube (Local Kubernetes Cluster - Can be GKE, Azure, ECS)
```
minikube start
```

## Selenium Grid installation


```
helm install selenium-grid stable/selenium \
--set chromeDebug.enabled=true \
--set firefoxDebug.enabled=true
```
where selenium-grid - resource name

Check status of chart installation: 
```
helm status selenium-grid
```
OR
```
minikube dashboard
```
OR
```
kubectl get all
```

Go to `http://localhost:4444/grid/console`

### Uninstall all Release - will delete all Kuber resources (e.g. deployments, services, pods)
```
helm delete selenium-grid 
```

## Resources
1. [Selenium Grid using Kubernetes, Docker, Helm and Traefik](https://medium.com/expedia-group-tech/da-kube-selenium-grid-using-kubernetes-docker-helm-and-traefik-856b802d1d08)
2. [Running Selenium grid on Kubernetes cluster using Helm package manager](https://www.sayem.org/selenium-grid-kubernetes-helm/)

