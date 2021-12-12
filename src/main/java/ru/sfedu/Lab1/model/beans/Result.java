package ru.sfedu.Lab1.model.beans;

import java.util.Objects;

public class Result<T> {
    private final T data;
    private final Status status;

    public Result(T data, Status status) {
        this.data = data;
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", status=" + status +
                '}';
    }
}