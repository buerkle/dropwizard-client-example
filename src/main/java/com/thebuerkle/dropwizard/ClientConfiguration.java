package com.thebuerkle.dropwizard;

import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientConfiguration extends Configuration {
    @Valid
    @NotNull
    private final JerseyClientConfiguration _http;

    @JsonCreator
    public ClientConfiguration(@JsonProperty("httpClient") JerseyClientConfiguration http) {
        _http = http;
    }

    public JerseyClientConfiguration getJerseyClientConfiguration() {
        return _http;
    }
}
