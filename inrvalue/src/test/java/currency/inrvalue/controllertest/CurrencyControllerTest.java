package currency.inrvalue.controllertest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import currency.inrvalue.controller.CurrencyController;
import currency.inrvalue.io.CurrencyRequest;
import currency.inrvalue.io.CurrencyResponse;
import currency.inrvalue.repo.CurrencyRepo;
import currency.inrvalue.service.CurrencyService;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(value = CurrencyController.class)
@ContextConfiguration(classes= {CurrencyService.class})
public class CurrencyControllerTest {

	@InjectMocks
	CurrencyController controller;
	
	@Autowired
	CurrencyService service;
	
	@MockBean
	CurrencyRepo respository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(service);
	}
	
	@Test
	public void create_payment_link_success() throws Exception {
		CurrencyRequest request = CurrencyFactory.createCurrencyRequest();
		CurrencyResponse response = CurrencyFactory.createCurrencyResponse();
		//mock response
		when(service.findById(request)).thenReturn(response);
		//actual response
		ResponseEntity<CurrencyResponse>  actualResponse = controller.getCurrencyInrValueById(request);
		assertEquals("200",actualResponse.getBody().getStatus());
		
	}

	
}
