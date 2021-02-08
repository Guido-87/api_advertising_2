package com.api.advertising;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;

import com.api.advertising.model.Ad;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.test.utility.Order;
import com.hackerrank.test.utility.OrderedTestRunner;
import com.hackerrank.test.utility.ResultMatcher;

@RunWith(OrderedTestRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AdsControllerTest {
	@ClassRule
	public static final SpringClassRule springClassRule = new SpringClassRule();

	@Rule
	public final SpringMethodRule springMethodRule = new SpringMethodRule();

	@Autowired
	private MockMvc mockMvc;

	/**
	 *
	 * @throws Exception
	 *
	 *                   It tests creating a ad
	 */
	@Test
	@Order(1)
	public void createAd() throws Exception {
		/**
		 *
		 * Create ad with id 1
		 *
		 * The request body is:
		 * {"id":1,"registered":true,"segmentation":{"id":1,"country":"England","age":38,"gender":"Male"},"title":"Football
		 * Manager
		 * 2020","description":"Simulator","printing_cost":100.0,"max_printing_cost":150.0,"end_date":"2020-10-25"}
		 */
		String json = "{\"id\":1,\"registered\":true,\"segmentation\":{\"id\":1,\"country\":\"England\",\"age\":38,\"gender\":\"Male\"},\"title\":\"Football Manager 2020\",\"description\":\"Simulator\",\"printing_cost\":100.0,\"max_printing_cost\":150.0,\"end_date\":\"2020-10-25\"}";

		mockMvc.perform(post("/ads").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isCreated());

		/**
		 *
		 * Create ad with id 2
		 *
		 * {"id":2,"registered":true,"segmentation":{"id":2,"country":"Japan","age":26,"gender":"Male"},"title":"Final
		 * Fantasy
		 * VI","description":"RPG","printing_cost":150.0,"max_printing_cost":200.0,"end_date":"2020-10-26"}
		 */
		json = "{\"id\":2,\"registered\":true,\"segmentation\":{\"id\":2,\"country\":\"Japan\",\"age\":26,\"gender\":\"Male\"},\"title\":\"Final Fantasy VI\",\"description\":\"RPG\",\"printing_cost\":150.0,\"max_printing_cost\":200.0,\"end_date\":\"2020-10-26\"}";

		mockMvc.perform(post("/ads").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isCreated());

		/**
		 *
		 * Create ad with id 3
		 *
		 * {"id":3,"registered":true,"segmentation":{"id":3,"country":"USA","age":0,"gender":"Male"},"title":"Mafia
		 * Definitive
		 * Edition","description":"Action-Adventure","printing_cost":300.0,"max_printing_cost":350.0,"end_date":"2020-10-25"}
		 */
		json = "{\"id\":3,\"registered\":true,\"segmentation\":{\"id\":3,\"country\":\"USA\",\"age\":0,\"gender\":\"Male\"},\"title\":\"Mafia Definitive Edition\",\"description\":\"Action-Adventure\",\"printing_cost\":300.0,\"max_printing_cost\":350.0,\"end_date\":\"2020-10-25\"}";

		mockMvc.perform(post("/ads").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isCreated());

		/**
		 *
		 * Create ad with id 4
		 *
		 * The request body is:
		 * {"id":4,"registered":true,"segmentation":{"id":4,"country":"Poland","age":5,"gender":"Male"},"title":"The
		 * Witcher 3","description":"Action
		 * RPG","printing_cost":500.0,"max_printing_cost":550.0,"end_date":"2020-10-25"}
		 */
		json = "{\"id\":4,\"registered\":true,\"segmentation\":{\"id\":4,\"country\":\"Poland\",\"age\":5,\"gender\":\"Male\"},\"title\":\"The Witcher 3\",\"description\":\"Action RPG\",\"printing_cost\":500.0,\"max_printing_cost\":550.0,\"end_date\":\"2020-10-25\"}";

		mockMvc.perform(post("/ads").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isCreated());

		/**
		 *
		 * Create ad with id 5
		 *
		 * The request body is:
		 * {"id":5,"registered":true,"segmentation":{"id":5,"country":"Japan","age":5,"gender":"Male"},"title":"Saint
		 * Seiya Soldier's
		 * Soul","description":"Fight","printing_cost":1000.0,"max_printing_cost":1050.0,"end_date":"2020-10-25"}
		 */
		json = "{\"id\":5,\"registered\":true,\"segmentation\":{\"id\":5,\"country\":\"Japan\",\"age\":5,\"gender\":\"Male\"},\"title\":\"Saint Seiya Soldier's Soul\",\"description\":\"Fight\",\"printing_cost\":1000.0,\"max_printing_cost\":1050.0,\"end_date\":\"2020-10-25\"}";

		mockMvc.perform(post("/ads").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isCreated());

		/**
		 *
		 * Create ad with id 6
		 *
		 * The request body is: {"id":6,"registered":false,"title":"Age of Empires
		 * Definitive
		 * Edition","description":"RTS","printing_cost":500.0,"max_printing_cost":600.0,"end_date":"2020-10-25"}
		 */
		json = "{\"id\":6,\"registered\":false,\"title\":\"Age of Empires Definitive Edition\",\"description\":\"RTS\",\"printing_cost\":500.0,\"max_printing_cost\":600.0,\"end_date\":\"2020-10-25\"}";

		mockMvc.perform(post("/ads").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isCreated());

		/**
		 *
		 * Create ad with id 7
		 *
		 * The request body is:
		 * {"id":7,"registered":true,"segmentation":{"id":6,"country":"Japan","age":3,"gender":"Male"},"title":"Marvel
		 * vs Capcom:
		 * Infinite","description":"Fight","printing_cost":700.0,"max_printing_cost":800.0,"end_date":"2020-10-25"}
		 */
		json = "{\"id\":7,\"registered\":true,\"segmentation\":{\"id\":6,\"country\":\"Japan\",\"age\":3,\"gender\":\"Male\"},\"title\":\"Marvel vs Capcom: Infinite\",\"description\":\"Fight\",\"printing_cost\":700.0,\"max_printing_cost\":800.0,\"end_date\":\"2020-10-25\"}";

		mockMvc.perform(post("/ads").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isCreated());
	}

	/**
	 *
	 * @throws Exception
	 *
	 *                   It tests creating a ad
	 */
	@Test
	@Order(2)
	public void createAdWithExistingId() throws Exception {
		/**
		 *
		 * Create ad with existing id 1
		 *
		 * The request body is:
		 * {"id":1,"registered":true,"segmentation":{"id":1,"country":"England","age":38,"gender":"Male"},"title":"Football
		 * Manager
		 * 2020","description":"Simulator","printing_cost":100.0,"max_printing_cost":150.0,"end_date":"25/10/2020"}
		 */
		String json = "{\"id\":1,\"registered\":true,\"segmentation\":{\"id\":1,\"country\":\"England\",\"age\":38,\"gender\":\"Male\"},\"title\":\"Football Manager 2020\",\"description\":\"Simulator\",\"printing_cost\":100.0,\"max_printing_cost\":150.0,\"end_date\":\"25/10/2020\"}";

		mockMvc.perform(post("/ads").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isBadRequest());
	}

	/**
	 *
	 * @throws Exception
	 *
	 *                   It tests getting three random ads
	 */
	@Test
	@Order(3)
	public void getThreeRandomAds() throws Exception {
		/**
		 *
		 * Get three random ads
		 * 
		 * Checks if request response contains 3 elements
		 */
		String response = mockMvc.perform(get("/ads/getThreeRandomAds")).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString();
		Ad[] responseArray = new ObjectMapper().readValue(response, Ad[].class);
		assertEquals(3, responseArray.length);
	}

	/**
	 *
	 * @throws Exception
	 *
	 *                   It tests getting all ads
	 */
	@Test
	@Order(4)
	public void getAll() throws Exception {
		/**
		 *
		 * Get all ads
		 * 
		 * The request response is:
		 * [{"id":1,"registered":true,"segmentation":{"id":1,"country":"England","age":38,"gender":"Male"},"title":"Football
		 * Manager
		 * 2020","description":"Simulator","printing_cost":100.0,"max_printing_cost":150.0,"end_date":"2020-10-25"},{"id":2,"registered":true,"segmentation":{"id":2,"country":"Japan","age":26,"gender":"Male"},"title":"Final
		 * Fantasy
		 * VI","description":"RPG","printing_cost":150.0,"max_printing_cost":200.0,"end_date":"2020-10-26"},{"id":3,"registered":true,"segmentation":{"id":3,"country":"USA","age":0,"gender":"Male"},"title":"Mafia
		 * Definitive
		 * Edition","description":"Action-Adventure","printing_cost":300.0,"max_printing_cost":350.0,"end_date":"2020-10-25"},{"id":4,"registered":true,"segmentation":{"id":4,"country":"Poland","age":5,"gender":"Male"},"title":"The
		 * Witcher 3","description":"Action
		 * RPG","printing_cost":500.0,"max_printing_cost":550.0,"end_date":"2020-10-25"},{"id":5,"registered":true,"segmentation":{"id":5,"country":"Japan","age":5,"gender":"Male"},"title":"Saint
		 * Seiya Soldier's
		 * Soul","description":"Fight","printing_cost":1000.0,"max_printing_cost":1050.0,"end_date":"2020-10-25"},{"id":6,"registered":false,"title":"Age
		 * of Empires Definitive
		 * Edition","description":"RTS","printing_cost":500.0,"max_printing_cost":600.0,"end_date":"2020-10-25"},{"id":7,"registered":true,"segmentation":{"id":6,"country":"Japan","age":3,"gender":"Male"},"title":"Marvel
		 * vs Capcom:
		 * Infinite","description":"Fight","printing_cost":700.0,"max_printing_cost":800.0,"end_date":"2020-10-25"}]
		 */
		String res = "[{\"id\":1,\"registered\":true,\"segmentation\":{\"id\":1,\"country\":\"England\",\"age\":38,\"gender\":\"Male\"},\"title\":\"Football Manager 2020\",\"description\":\"Simulator\",\"printing_cost\":100.0,\"max_printing_cost\":150.0,\"end_date\":\"2020-10-25\"},{\"id\":2,\"registered\":true,\"segmentation\":{\"id\":2,\"country\":\"Japan\",\"age\":26,\"gender\":\"Male\"},\"title\":\"Final Fantasy VI\",\"description\":\"RPG\",\"printing_cost\":150.0,\"max_printing_cost\":200.0,\"end_date\":\"2020-10-26\"},{\"id\":3,\"registered\":true,\"segmentation\":{\"id\":3,\"country\":\"USA\",\"age\":0,\"gender\":\"Male\"},\"title\":\"Mafia Definitive Edition\",\"description\":\"Action-Adventure\",\"printing_cost\":300.0,\"max_printing_cost\":350.0,\"end_date\":\"2020-10-25\"},{\"id\":4,\"registered\":true,\"segmentation\":{\"id\":4,\"country\":\"Poland\",\"age\":5,\"gender\":\"Male\"},\"title\":\"The Witcher 3\",\"description\":\"Action RPG\",\"printing_cost\":500.0,\"max_printing_cost\":550.0,\"end_date\":\"2020-10-25\"},{\"id\":5,\"registered\":true,\"segmentation\":{\"id\":5,\"country\":\"Japan\",\"age\":5,\"gender\":\"Male\"},\"title\":\"Saint Seiya Soldier's Soul\",\"description\":\"Fight\",\"printing_cost\":1000.0,\"max_printing_cost\":1050.0,\"end_date\":\"2020-10-25\"},{\"id\":6,\"registered\":false,\"title\":\"Age of Empires Definitive Edition\",\"description\":\"RTS\",\"printing_cost\":500.0,\"max_printing_cost\":600.0,\"end_date\":\"2020-10-25\"},{\"id\":7,\"registered\":true,\"segmentation\":{\"id\":6,\"country\":\"Japan\",\"age\":3,\"gender\":\"Male\"},\"title\":\"Marvel vs Capcom: Infinite\",\"description\":\"Fight\",\"printing_cost\":700.0,\"max_printing_cost\":800.0,\"end_date\":\"2020-10-25\"}]";

		assertTrue(ResultMatcher.matchJsonArray(
				mockMvc.perform(get("/ads")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString(),
				res, true));
	}

}
