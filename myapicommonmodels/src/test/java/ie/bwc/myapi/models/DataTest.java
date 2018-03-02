package ie.bwc.myapi.models;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import ie.bwc.myapi.annot.UnitTest;

/**
 * 
 * @author Kieran
 *
 */
@RunWith(JUnit4.class)
@Category({ UnitTest.class })
public class DataTest {

	/**
	 * 
	 */
	@Test
	public void testFluent() {
		LocalDateTime now = LocalDateTime.now();

		Data d = Data.builder().withId(1).withSomething("a").withTimestamp(now).build();
		assertThat(d.getId(), is(1));
		assertThat(d.getSomething(), is("a"));
		assertThat(d.getTimestamp(), is(now));
	}

	/**
	 * 
	 */
	@Test
	public void testConstructor() {
		LocalDateTime now = LocalDateTime.of(2018, Month.MARCH, 1, 2, 44);

		Data d = new Data(2, "b", now);
		assertThat(d.getId(), is(2));
		assertThat(d.getSomething(), is("b"));
		assertThat(d.getTimestamp(), is(now));
	}

	/**
	 * 
	 * @throws JsonProcessingException
	 */
	@Test
	public void jsonProduction() throws JsonProcessingException {

		LocalDateTime now = LocalDateTime.of(2018, Month.MARCH, 1, 2, 44);
		Data d = Data.builder().withId(1).withSomething("a").withTimestamp(now).build();

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		String result = mapper.writeValueAsString(d);

		//test @JsonRootName
		assertThat(result, containsString("outer"));
		//test @JsonIgnoreProperties
		assertThat(result, not(containsString("id")));
		//test timestamp format
		assertThat(result, containsString("2018-03-01T02:44:00"));
		//test @JsonInclude
		Data d2 = Data.builder().withId(1).withTimestamp(LocalDateTime.now()).build();
		String result2 = mapper.writeValueAsString(d2);
		assertThat(result2, not(containsString("something")));		
	}

}