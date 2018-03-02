package ie.bwc.myapi.config;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import ie.bwc.myapi.annot.UnitTest;

/**
 * 
 * @author Kieran
 *
 */
@RunWith(JUnit4.class)
@Category({UnitTest.class})
public class JacksonConfigTest {

	/**
	 * 
	 */
	@Test
	public void testJacksonBuilder() {
		JacksonConfig conf = new JacksonConfig();
		Jackson2ObjectMapperBuilder builder = conf.jacksonBuilder();
		assertThat(builder, is(notNullValue()));
	}

}