# spring-boot-with-istio
Basic Example of Spring Boot Microservices with Istio

Steps to run -:
 1. Build the docker images of the microservices. Note - The docker should be running.
    mvn com.google.cloud.tools:jib-maven-plugin:build -Dimage=<{docker-id}/{image-name}>

 2. Check your docker and kubernetes is running fine, if not start them first

 3. Open a terminal and go to the path where istio is installed and apply the manifest using the profile demo.
    istioctl manifest apply --set profile=demo

 4. Now, deploy the yaml files in the kube folder. Go to the source path of the cloned project
    kubectl apply -f kube
  
 5. Check the pods are in running state using kubectl get pods. Wait till the pods are in running state by checking the command

 6. Determine the IP using -:
    (kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{jsonpath='{.status.loadBalancer.ingress[0].hostname}')

 7. Determine the http port -:
    (kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{jsonpath='{.spec.ports}')
     This will give all the ports. Check for http2 and use it

 8. Run the application from the browser such as -: http://localhost/service-1 // http://localhost/service-2

 9. After all done remove the services -:
    kubectl delete -f kube

10. Remove the manifest -:
    istioctl manifest generate --set profile=demo | kubectl delete -f -
