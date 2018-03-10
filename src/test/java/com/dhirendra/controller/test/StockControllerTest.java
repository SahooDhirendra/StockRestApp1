/**
 * 
 */
package com.dhirendra.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.dhirendra.controller.StockController;
import com.dhirendra.service.StockService;

/**
 * @author dhirendra
 *
 */

public class StockControllerTest {

	private MockMvc mockMvc;

	@Mock
	private StockService stockService;

	@InjectMocks
	private StockController stockController;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(stockController).build();
	}

	@Test
	public void testHelloWorldJson() throws Exception {
		mockMvc.perform(get("/app/stocks/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", Matchers.is("1")))
				.andExpect(jsonPath("$.name", Matchers.is("Dhirendras")))
				.andExpect(jsonPath("$.*", Matchers.hasSize(4)));
	}

}
