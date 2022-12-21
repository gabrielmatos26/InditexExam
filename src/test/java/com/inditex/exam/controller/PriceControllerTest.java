package com.inditex.exam.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.exam.dto.PriceDTO;
import com.inditex.exam.service.PriceService;

@SpringBootTest
@AutoConfigureMockMvc
//@Sql(value = "classpath:data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class PriceControllerTest {
	
	@Autowired
    MockMvc mockMvc;
	
    @Autowired
    ObjectMapper mapper;
    
    @Autowired
    PriceService priceService;
	

	@Autowired
    private ObjectMapper objMapper;
    
    
    @Test
    public void getProductTestByProductId_caseDate1() throws Exception {
    	Long productId = 35455L;
    	int brandId = 1;
    	LocalDateTime date = LocalDateTime.parse("2020-06-14T10:00:00");
    	PriceDTO expectedPrice = new PriceDTO(1L, 1, LocalDateTime.parse("2020-06-14T00:00:00"),
    			LocalDateTime.parse("2020-12-31T23:59:59"), 35455L, new BigDecimal(35.50).setScale(2, RoundingMode.HALF_UP), "EUR");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
			        		.get(String.format("/api/prices/price?product=%d&brand=%d&date=%s", 
			        				productId, brandId, date))
			                .contentType(MediaType.APPLICATION_JSON))
			                .andExpect(MockMvcResultMatchers.status().isOk())
			                .andReturn();
        String json = result.getResponse().getContentAsString();
        PriceDTO resultPrice = objMapper.readValue(json, PriceDTO.class);
        assertTrue(resultPrice.equals(expectedPrice));
    }
    
    @Test
    public void getProductTestByProductId_caseDate2() throws Exception {
    	Long productId = 35455L;
    	int brandId = 1;
    	LocalDateTime date = LocalDateTime.parse("2020-06-14T16:00:00");
    	PriceDTO expectedPrice = new PriceDTO(2L, 1, LocalDateTime.parse("2020-06-14T15:00:00"),
    			LocalDateTime.parse("2020-06-14T18:30:00"), 35455L, new BigDecimal(25.45).setScale(2, RoundingMode.HALF_UP), "EUR");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
			        		.get(String.format("/api/prices/price?product=%d&brand=%d&date=%s",
			        				productId, brandId, date))
			                .contentType(MediaType.APPLICATION_JSON))
			                .andExpect(MockMvcResultMatchers.status().isOk())
			                .andReturn();
        String json = result.getResponse().getContentAsString();
        PriceDTO resultPrice = objMapper.readValue(json, PriceDTO.class);
        assertTrue(resultPrice.equals(expectedPrice));
    }
    
    @Test
    public void getProductTestByProductId_caseDate3() throws Exception {
    	Long productId = 35455L;
    	int brandId = 1;
    	LocalDateTime date = LocalDateTime.parse("2020-06-14T21:00:00");
    	PriceDTO expectedPrice = new PriceDTO(1L, 1, LocalDateTime.parse("2020-06-14T00:00:00"),
    			LocalDateTime.parse("2020-12-31T23:59:59"), 35455L, new BigDecimal(35.50).setScale(2, RoundingMode.HALF_UP), "EUR");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
			        		.get(String.format("/api/prices/price?product=%d&brand=%d&date=%s",
			        				productId, brandId, date))
			                .contentType(MediaType.APPLICATION_JSON))
			                .andExpect(MockMvcResultMatchers.status().isOk())
			                .andReturn();
        String json = result.getResponse().getContentAsString();
        PriceDTO resultPrice = objMapper.readValue(json, PriceDTO.class);
        assertTrue(resultPrice.equals(expectedPrice));
    }
    
    @Test
    public void getProductTestByProductId_caseDate4() throws Exception {
    	Long productId = 35455L;
    	int brandId = 1;
    	LocalDateTime date = LocalDateTime.parse("2020-06-15T10:00:00");
    	PriceDTO expectedPrice = new PriceDTO(3L, 1, LocalDateTime.parse("2020-06-15T00:00:00"),
    			LocalDateTime.parse("2020-06-15T11:00:00"), 35455L, new BigDecimal(30.50).setScale(2, RoundingMode.HALF_UP), "EUR");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
			        		.get(String.format("/api/prices/price?product=%d&brand=%d&date=%s",
			        				productId, brandId, date))
			                .contentType(MediaType.APPLICATION_JSON))
			                .andExpect(MockMvcResultMatchers.status().isOk())
			                .andReturn();
        String json = result.getResponse().getContentAsString();
        PriceDTO resultPrice = objMapper.readValue(json, PriceDTO.class);
        assertTrue(resultPrice.equals(expectedPrice));
    }
    
    @Test
    public void getProductTestByProductId_caseDate5() throws Exception {
    	Long productId = 35455L;
    	int brandId = 1;
    	LocalDateTime date = LocalDateTime.parse("2020-06-16T21:00:00");
    	PriceDTO expectedPrice = new PriceDTO(4L, 1, LocalDateTime.parse("2020-06-15T16:00:00"),
    			LocalDateTime.parse("2020-12-31T23:59:59"), 35455L, new BigDecimal(38.95).setScale(2, RoundingMode.HALF_UP), "EUR");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
			        		.get(String.format("/api/prices/price?product=%d&brand=%d&date=%s",
			        				productId, brandId, date))
			                .contentType(MediaType.APPLICATION_JSON))
			                .andExpect(MockMvcResultMatchers.status().isOk())
			                .andReturn();
        String json = result.getResponse().getContentAsString();
        PriceDTO resultPrice = objMapper.readValue(json, PriceDTO.class);
        System.out.println(expectedPrice.getPrice());
        System.out.println(resultPrice.getPrice());
        assertTrue(resultPrice.equals(expectedPrice));
    }
    

}
