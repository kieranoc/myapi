package ie.bwc.myapi.tierweb.endpoint;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import ie.bwc.myapi.annot.UnitTest;
import ie.bwc.myapi.models.Data;
import ie.bwc.myapi.tierservice.Logic2;

/**
 * 
 * @author Kieran
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(Logic2RestController.class)
@ContextConfiguration(classes = Logic2RestController.class)
@Category({UnitTest.class})
public class Logic2RestControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private Logic2 service;

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEndpoint() throws Exception {
		given(this.service.buildResult()).willReturn(Data.builder().withSomething("zzz").build());
		this.mvc.perform(get("/")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("{\"something\":\"zzz\"}"));
	}

}