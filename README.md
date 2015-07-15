# dropwizard-client-example

*A really simple dropwizard client example*

## Running

```
mvn package
java -jar target/dropwizard-0.0.1-SNAPSHOT.jar server config.yml
```

## Test

```
curl localhost:8080/consume
```

The /consume URL loads a Car object from the /produce URL and prints the Car to the application log.
