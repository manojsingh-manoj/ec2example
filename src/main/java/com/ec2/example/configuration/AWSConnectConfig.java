package com.ec2.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;




@Configuration
public class AWSConnectConfig {

	@Bean
	public AmazonS3 gets3Client() {
		AmazonS3 s3Client = null;
		try {
			AWSCredentialsProvider provider = new AWSCredentialsProviderChain(new InstanceProfileCredentialsProvider(true),new ProfileCredentialsProvider());
			s3Client  = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(provider).build();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return s3Client;
	}
}
