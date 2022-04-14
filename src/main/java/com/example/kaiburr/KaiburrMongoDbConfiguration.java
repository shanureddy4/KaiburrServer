package com.example.kaiburr;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;


@Configuration
public class KaiburrMongoDbConfiguration {
    @Value("${spring.data.mongodb.uri}")
    private String mongouri;
    public @Bean MongoDbFactory getMongoDbFactory() throws UnknownHostException {
        //mongoclient will take 127.0.0.1 ip address if it found null
        return new SimpleMongoDbFactory(new MongoClient("localhost",27017),"mongos");
    }
    public @Bean(name = "mongoTemplate") MongoTemplate getMongoTemplate() throws UnknownHostException {
        MongoTemplate mongoTemplate = new MongoTemplate(getMongoDbFactory());
        return mongoTemplate;
    }
}
