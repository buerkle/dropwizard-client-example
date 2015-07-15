package com.thebuerkle.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Environment;

import javax.ws.rs.client.Client;

import com.thebuerkle.dropwizard.resources.TestResource;

public class ClientApplication extends Application<ClientConfiguration> {
    public static void main(String[] args) throws Exception {
        new ClientApplication().run(args);
    }

    @Override
    public String getName() {
        return "client";
    }

    @Override
    public void run(ClientConfiguration configuration, Environment environment) {
        Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration())
            .build(getName());

        environment.jersey().register(new TestResource(client));
    }
}
