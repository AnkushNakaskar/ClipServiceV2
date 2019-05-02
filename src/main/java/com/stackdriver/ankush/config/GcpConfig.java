package com.stackdriver.ankush.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.spotify.asyncdatastoreclient.Datastore;
import com.spotify.asyncdatastoreclient.DatastoreConfig;
import com.spotify.google.cloud.pubsub.client.Pubsub;

@Configuration
public class GcpConfig {

	@Value("${project.gcp.credentials}")
	private String gcpAccessKey;

	@Value("${spring.cloud.gcp.project-id}")
	private String projectId;

	@Bean
	public Pubsub pubsubPublisher() throws GeneralSecurityException, IOException {
		System.out.println("Pubsub ...connector....");
		System.out.println(projectId);
		System.out.println(gcpAccessKey);
		HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
		final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();

		GoogleCredential credential = GoogleCredential.fromStream(
				new ByteArrayInputStream(gcpAccessKey.getBytes(StandardCharsets.UTF_8)), transport, jacksonFactory);
		
		System.out.println("Credentials ..!!!");
		System.out.println(credential);
//		System.out.println(credential.getServiceAccountProjectId());
		return Pubsub.builder().credential(credential).build();
	}

	@Bean
	public Datastore cloudDatastoreService() throws IOException, GeneralSecurityException {
		System.out.println("In data store object creation..!!!");
		HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
		final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();

		GoogleCredential credential = GoogleCredential.fromStream(
				new ByteArrayInputStream(gcpAccessKey.getBytes(StandardCharsets.UTF_8)), transport, jacksonFactory).createScoped(DatastoreConfig.SCOPES);
		
		

		final DatastoreConfig config = DatastoreConfig.builder()
		        .connectTimeout(5000)
		        .requestTimeout(1000)
		        .maxConnections(5)
		        .requestRetry(3)
		        .project(projectId)
		        .credential(credential)
		            .build();

		System.out.println("Data store config : "+config);
		    final Datastore datastore = Datastore.create(config);
			return datastore;
	}
	
}
