package ie.bwc.myapi.tierservice;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import ie.bwc.myapi.models.Data;

/**
 * 
 * @author Kieran
 *
 */
@Service
public class Logic2 {

	/**
	 * 
	 * @return
	 */
	public Data buildResult() {
		return Data.builder().withId(1).withSomething("a").withTimestamp(LocalDateTime.now()).build();
	}
	
}