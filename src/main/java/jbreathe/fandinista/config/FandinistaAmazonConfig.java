package jbreathe.fandinista.config;

import org.jets3t.service.S3Service;
import org.jets3t.service.S3ServiceException;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.security.AWSCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by скурихин on 29.01.2017.
 */
@Configuration
@PropertySource("classpath:aws.properties")
public class FandinistaAmazonConfig {

    @Value("${AWS_ACCESS_KEY_ID}")
    private String awsAccessKeyId;
    @Value("${AWS_SECRET_ACCESS_KEY}")
    private String awsSecretAccessKey;

    @Bean
    public S3Service s3Service() throws S3ServiceException {
        AWSCredentials awsCredentials = new AWSCredentials(awsAccessKeyId, awsSecretAccessKey);

        RestS3Service restS3Service = new RestS3Service(awsCredentials);
        return restS3Service;
    }
}
