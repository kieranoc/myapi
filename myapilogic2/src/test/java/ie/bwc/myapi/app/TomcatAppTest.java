package ie.bwc.myapi.app;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import ie.bwc.myapi.annot.UnitTest;

/**
 * 
 * @author Kieran
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = {"eureka.client.enabled:false"})
@Category({UnitTest.class})
public class TomcatAppTest {

	@Autowired
	private TestRestTemplate restTemplate;

	/**
	 * 
	 */
	@Test
	public void testBootstrap() {
		String body = this.restTemplate.getForObject("/", String.class);
		assertThat(body, containsString("something"));
	}

}