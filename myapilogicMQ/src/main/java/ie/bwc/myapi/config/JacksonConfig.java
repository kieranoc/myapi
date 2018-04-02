package ie.bwc.myapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * 
 * @author Kieran
 *
 */
@Configuration
public class JacksonConfig {

	/**
	 * 
	 * @return
	 */
	@Bean
	public Jackson2ObjectMapperBuilder jacksonBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		// enables wrapping for root elements
		builder.featuresToDisable(SerializationFeature.WRAP_ROOT_VALUE);
		builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		builder.modulesToInstall(new JavaTimeModule());
		return builder;
	}
	
}