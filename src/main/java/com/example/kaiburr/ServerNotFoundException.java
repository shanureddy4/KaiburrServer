package com.example.kaiburr;

public class ServerNotFoundException extends RuntimeException {
    public ServerNotFoundException(String id) {
        super("Could not find server(s) "+id);
    }



}
