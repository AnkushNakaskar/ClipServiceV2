package com.stackdriver.ankush.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.spotify.asyncdatastoreclient.Datastore;
import com.spotify.google.cloud.pubsub.client.Pubsub;

@Configuration
public class DataStoreConfiguration {

	@Autowired
	private ProjectConfig projectConfig;
	
	@Autowired
	private Pubsub pubSub;
	
	@Value("${project.gcp.credentials}")
	private String gcpAccessKey;

	@Value("${spring.cloud.gcp.project-id}")
	private String projectId;


	@Autowired
	private Datastore dataStore;
	
//	@Value("{spring.profiles.active}")
	@Value("${spring.profiles.active}")
	private String profiles;
	// check project config content-caas
	// @Bean
	@PostConstruct
	public void init() {
		System.out.println("In post construct..!!!");
		System.out.println(profiles);
		System.out.println(projectConfig.getEnv());
		System.out.println(projectConfig.getApplication());
		System.out.println(projectConfig.getGroup());
		System.out.println(projectConfig.getTeam());
		System.out.println(projectConfig.getGcp().getCredentials());
	}

//	public Datastore cloudDatastoreService() throws IOException {
//		GoogleCredentials credentials = ServiceAccountCredentials.fromStream(new ByteArrayInputStream(gcpAccessKey.getBytes(StandardCharsets.UTF_8)));
//		System.out.println("Data store configuration...!!!");
//		System.out.println(credentials);
//		DatastoreOptions.newBuilder().setCredentials(credentials);
//		return DatastoreOptions.getDefaultInstance().getService();
//	}
	

}
