package com.javaforjava.bootifulelasticsearch.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.javaforjava.bootifulelasticsearch.dal")
@ComponentScan(basePackages = { "com.javaforjava.bootifulelasticsearch.dal" })
public class ElasticSearchConfig {






    @Bean
    public NodeBuilder nodeBuilder() {
        return new NodeBuilder();
    }


    @Bean
    public Client client() throws Exception {
        Settings settings = Settings.settingsBuilder()
                .put("cluster.name", "my-application")
                .put("client.transport.sniff", true).build();
        TransportClient client = new TransportClient.Builder().settings(settings).build();
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
        return client;
    }
    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }
}
