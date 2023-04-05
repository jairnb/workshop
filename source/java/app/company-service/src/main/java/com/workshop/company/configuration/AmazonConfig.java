package com.workshop.company.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AmazonConfig {
//    @Value("${cloud.aws.credentials.accessKey}")
    private String AWSAccessKeyId;
//    @Value("${cloud.aws.credentials.secretKey}")
    private String AWSSecretKey;

//    @Value("${cloud.aws.region.static}")
    private String AWSRegion;

//    @Bean
    public AmazonS3 s3() {
        AWSCredentials awsCredentials = new BasicAWSCredentials(AWSAccessKeyId, AWSSecretKey);
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(AWSRegion)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

    }
}
