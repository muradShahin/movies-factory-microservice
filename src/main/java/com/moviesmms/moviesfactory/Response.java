package com.moviesmms.moviesfactory;

import java.util.List;

public class Response {

	private List<Movie> movies ;
	private String ec2_metadataString;

	
	public Response() {
	
	}
	
	public Response(List<Movie> movies, String ec2_metadataString) {
		super();
		this.movies = movies;
		this.ec2_metadataString = ec2_metadataString;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public String getEc2_metadataString() {
		return ec2_metadataString;
	}

	public void setEc2_metadataString(String ec2_metadataString) {
		this.ec2_metadataString = ec2_metadataString;
	}
	
	
	
	
	
}
