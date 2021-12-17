package ru.barashkov.distributed.lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MessageGetResult {
    private final Integer Id;

    public MessageGetResult(
            @JsonProperty("packageId") String packageId) {
        this.Id = Integer.valueOf(packageId);
    }

    public Integer getId() {
        return this.Id;
    }
}
