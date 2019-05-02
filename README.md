# ClipServiceV2

To check the Istio with GCP kubernates 

# Setting up the Istio on GCP  #

    *.Install istio on GCP kubernates using : https://cloud.google.com/istio/docs/istio-on-gke/installing
        * CMD
            * gcloud beta container clusters create istio-demo --addons=Istio --istio-config=auth=MTLS_STRICT --region us-west1
    * Deploy all the versions of ClipServices
        * Deploy ClipService Version1(ClipServiceV1)
            * Run below CMD from ClipService Version 1 files
                * kubectl apply -f src/main/resources/deployment.yaml  
                * src/main/resources/deployment.yaml (This file is from ClipServiceV1 project)
        * Deploy ClipService Versio2(ClipServiceV2)
            * Run below CMD from ClipService Version 2 files
                * kubectl apply -f src/main/resources/deployment.yaml  
                * src/main/resources/deployment.yaml (This file is from ClipServiceV2 project)
    * Deploy Service over these deployments 
        * Make sure ,You dont have version in “spec:selector” in service.yaml
        * kubectl apply -f src/main/resources/service.yaml
            * Run above CMD from any project but only once since service is constant like LoadBalancer
            * Refer to service.yaml from ClipServiceV1 project
    * Once Service is ready,You should see the external ip in kubernetes dashboard
    * Deploy DestinationRule
        * This rule define the naming for ClipService Naming like below
            * ClipService-V1 as “ClipService-versionv-1”
        * This naming convention is used in Virtual service setup
    * Now deploy Virtual Services rules
        * First deploy 100% traffic to Version2
            * You can run yaml from ClipServiceV1 project as 
            * kubectl apply -f src/main/resources/virtual-service-clipservice-v2.yml
        * Check for API response ,It should be always “Version 2”
            * API : “http://<extnalIP>:8080/api/spring/google/clip/1”
        * Now change the rule to API invoked from safari should go Version 1
            * You can run yaml file from ClipServiceV1 project as
            * kubectl apply -f src/main/resources/newVirtualService.yaml
          * Check for API response from Safari ,It should be always “Version 1”
          * From other ,it should be version 2
    * Projects are checked in as 
        * ClipServiceV1 :
        * ClipServiceV2:
    * More info Refer to : https://github.com/redhat-developer-demos/istio-tutorial

~~~~__~~~~
