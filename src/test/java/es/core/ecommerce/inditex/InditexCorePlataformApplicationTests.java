package es.core.ecommerce.inditex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class InditexCorePlataformApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGetPriceByBrandZaraFirst() throws Exception {
		mockMvc.perform(get("/core/ecommerce/inditex/api/price/find")
						.queryParam("productId", "35455")
						.queryParam("brandId", "1")
						.queryParam("date", "2020-06-14T10:00:00"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(35.50))
				.andExpect(jsonPath("$.priceList").value(1))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.productId").value(35455));
	}

	@Test
	void testGetPriceByBrandZaraSecond() throws Exception {
		mockMvc.perform(get("/core/ecommerce/inditex/api/price/find")
						.queryParam("productId", "35455")
						.queryParam("brandId", "1")
						.queryParam("date", "2020-06-14T16:00:00"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(25.45))
				.andExpect(jsonPath("$.priceList").value(2))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.productId").value(35455));
	}

	@Test
	void testGetPriceByBrandZaraThird() throws Exception {
		mockMvc.perform(get("/core/ecommerce/inditex/api/price/find")
						.queryParam("productId", "35455")
						.queryParam("brandId", "1")
						.queryParam("date", "2020-06-14T21:00:00"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(35.50))
				.andExpect(jsonPath("$.priceList").value(1))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.productId").value(35455));
	}

	@Test
	void testGetPriceByBrandZaraFour() throws Exception {
		mockMvc.perform(get("/core/ecommerce/inditex/api/price/find")
						.queryParam("productId", "35455")
						.queryParam("brandId", "1")
						.queryParam("date", "2020-06-15T10:00:00"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(30.50))
				.andExpect(jsonPath("$.priceList").value(3))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.productId").value(35455));
	}

	@Test
	void testGetPriceByBrandZaraFive() throws Exception {
		mockMvc.perform(get("/core/ecommerce/inditex/api/price/find")
						.queryParam("productId", "35455")
						.queryParam("brandId", "1")
						.queryParam("date", "2020-06-16T21:00:00"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(38.95))
				.andExpect(jsonPath("$.priceList").value(4))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.productId").value(35455));
	}

}
