package com.thebuerkle.dropwizard.core;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

public class Car {

    @NotNull
    private final String _model;

    @NotNull
    private final String _color;

    @JsonCreator
    public Car(@JsonProperty("model") String model,
               @JsonProperty("color") String color) {
        _model = model;
        _color = color;
    }

    public String getModel() {
        return _model;
    }

    public String getColor() {
        return _color;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("model", _model)
            .add("color", _color)
            .toString();
    }
}
