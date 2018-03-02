package ie.bwc.myapi.tierservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.bwc.myapi.models.Data;

/**
 * 
 * @author Kieran
 *
 */
@Service
public class Logic {

	@Autowired
	private Logic2Client logic2Client;
	
	/**
	 * 
	 * @return
	 */
	public Data buildResult() {
		return logic2Client.get();
	}
	
}