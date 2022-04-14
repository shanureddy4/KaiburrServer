package com.example.kaiburr;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;
import java.sql.SQLOutput;


@Configuration
public class KaiburrMongoDbConfiguration {
    private final String databasename = System.getenv("MONGO_INITDB_DATABASE");
    private final String username = System.getenv("MONGO_INITDB_ROOT_USERNAME");
    private final String password = System.getenv("MONGO_INITDB_ROOT_PASSWORD");


    public @Bean MongoDbFactory getMongoDbFactory() throws UnknownHostException {

        final String mongouri= "mongodb://"+username+":"+password+"@localhost:27017/"+databasename;
        return new SimpleMongoDbFactory(new MongoClientURI(mongouri));
    }
    public @Bean(name = "mongoTemplate") MongoTemplate getMongoTemplate() throws UnknownHostException {
        MongoTemplate mongoTemplate = new MongoTemplate(getMongoDbFactory());
        return mongoTemplate;
    }
}
