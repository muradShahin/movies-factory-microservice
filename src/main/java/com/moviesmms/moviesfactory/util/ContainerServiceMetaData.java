package com.moviesmms.moviesfactory.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import  org.slf4j.*;


@Service
public class ContainerServiceMetaData {

	
	private static final String ECS_CONTAINER_SERVICE="ECS_CONTAINER_METADATA_URI";
	private static final String DEFAULT_VALUE="EMPTY";
	
	private Logger logger = LoggerFactory.getLogger(ContainerServiceMetaData.class);
	
	@Value("${"+ECS_CONTAINER_SERVICE+":"+DEFAULT_VALUE+"}")
	private String containerMetaDataString;
	
	
	public String getContainer() {
		
		if(containerMetaDataString.contains(DEFAULT_VALUE)) {
			
			logger.info("Env variable is not avbailable - "+ECS_CONTAINER_SERVICE);
			
			return "NA";
		}
		
		return new RestTemplate().getForObject(containerMetaDataString, String.class);
		
	}
}
