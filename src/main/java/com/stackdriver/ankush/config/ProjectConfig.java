package com.stackdriver.ankush.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "project")
public class ProjectConfig {

	private String group;

	private String team;

	private String env;

	private String application;


	
	private Gcp gcp;

	public static class Gcp {
		private String credentials;

		public String getCredentials() {
			return credentials;
		}

		public void setCredentials(String credentials) {
			this.credentials = credentials;
		}
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Gcp getGcp() {
		return gcp;
	}

	public void setGcp(Gcp gcp) {
		this.gcp = gcp;
	}


}