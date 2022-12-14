package com.fiap.hackaton.attendance.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SQSProviderConfiguration {

    @Value("${amazon.region}")
    private String region;

    @Value("${amazon.access.accesskey}")
    private String accessKey;

    @Value("${amazon.access.secretkey}")
    private String secretKey;

    @Bean
    public AmazonSQS createSQSClient() {
        return AmazonSQSClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(accessKey,secretKey)
                ))
                .withRegion(region)
                .build();
    }
}
