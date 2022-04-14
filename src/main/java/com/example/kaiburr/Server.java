package com.example.kaiburr;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Server {
    @Id
    private  String id;
    private String name;
    private String language;
    private String framework;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }






    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Server{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", language='" + language + '\'' +
                ", framework='" + framework + '\'' +
                '}';
    }



}
