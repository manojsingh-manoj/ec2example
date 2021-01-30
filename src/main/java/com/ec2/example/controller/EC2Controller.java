package com.ec2.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;

@RestController
public class EC2Controller {

	@Autowired
	AmazonS3 s3Client;
	
	@GetMapping("/buckets")
	public List<String> getBucketList() {
		List<Bucket> buckets = s3Client.listBuckets();
		List<String> list = new ArrayList<String>();
		System.out.println("Your Amazon S3 buckets:");
		for (Bucket b : buckets) {
			list.add(b.getName());
		}
		return list;
	}
}
