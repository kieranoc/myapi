package ie.bwc.myapi.tierweb.endpoint;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ie.bwc.myapi.annot.UnitTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 
 * @author Kieran
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(InstanceRestController.class)
@ContextConfiguration(classes = InstanceRestController.class)
@Category({UnitTest.class})
public class InstanceRestControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private DiscoveryClient discoveryClient;

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEndpoint() throws Exception {
		this.mvc.perform(get("/instances/myapilogic")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("[]"))
				.andExpect(header().string("Content-Type", "application/json;charset=UTF-8"));
	}

}