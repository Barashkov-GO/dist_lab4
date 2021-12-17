package ru.barashkov.distributed.lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MessageGetResult {
    private final String Id;

    public MessageGetResult(
            @JsonProperty("packageId") String packageId) {
        this.Id = packageId;
    }

    public String getId() {
        return this.Id;
    }
}
