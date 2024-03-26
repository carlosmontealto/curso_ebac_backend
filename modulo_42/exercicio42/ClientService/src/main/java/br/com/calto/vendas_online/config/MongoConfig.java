package br.com.calto.vendas_online.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.calto.vendas_online.repository")
public class MongoConfig {}
