package com.thebuerkle.dropwizard.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thebuerkle.dropwizard.core.Car;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

    private static final Logger log = LoggerFactory.getLogger(TestResource.class);

    private final Client _client;

    public TestResource(Client client) {
        _client = client;
    }

    @Path("/produce")
    @GET
    public Car produce() {
        return new Car("Elantra", "gray");
    }

    @Path("/consume")
    @GET
    public void consume(@QueryParam("string") boolean asString) {
        WebTarget target = _client.target("http://localhost:8080/produce");
        Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
        Response response = invocation.get();

        log.info("Status code: " + Response.Status.fromStatusCode(response.getStatus()));

        if (asString) {
            log.info("Response as string: " + response.readEntity(String.class));
        }
        else {
            log.info("Response as car: " + response.readEntity(Car.class).toString());
        }
    }
}
