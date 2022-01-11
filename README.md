# Smart Contract Lifecycle Manager

The project encapsulates the Smart Contract Lifecycle Manager module of the 5GZORRO platform.
It is a SpringBoot application with associated documentation built from Swagger annotations. 

The DLT agnostic driver interface is described in the `dlt-driver-api` module, and the corda 
implementation of the marketplace smart contracts is contained under `corda-driver`. With the 
driver implementation at: `corda-driver/driver-impl`

## Getting Started
To run the application using Maven simply execute the following from the command-line:

`./gradlew bootRun`

## Documentation

The default port for the spring api is 8087

You can access swagger-ui by running the API and navigating to `http://localhost:8087/swagger-ui`

An open-api schema is also available under `docs/swagger-ui` from the root of the project.

### Running corda nodes locally

To package and run nodes locally run `./gradlew clean deployNodes` from the root directory
then navigate to `corda-driver/build/nodes` and run `./runnodes` on Mac/Linux or `runnodes.bat` on 
Windows. This broadly follows the steps outlined [here](https://docs.corda.net/docs/corda-os/4.6/generating-a-node.html)

Nodes are configured (for example what nodes to deploy, cordApps included and config properties) 
at `corda-driver/build.gradle` under the deployNodes task 

### Running the Lifecycle Manager API
Once the nodes are up and running, you need to spin up a local postgres instance by 
running `docker-compose up` in `/app/src/`.  Once this has started you can run the `ManagerApplication`.
It should be run with the dev profile active (`-Dspring.profiles.active=dev`) 

### Updating OpenAPI swagger-ui file

This should be completed as a github action but to do manually run 
`gradle clean generateOpenApiDocs` this should output an updated openapi.yaml file at: 
`/docs/swagger-ui/` based on the spring apis rest controllers
