package currency.inrvalue.controllertest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import currency.inrvalue.bean.CurrencyMasterEntity;
import currency.inrvalue.io.CurrencyRequest;
import currency.inrvalue.io.CurrencyResponse;
import currency.inrvalue.repo.CurrencyRepo;
import currency.inrvalue.service.CurrencyService;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(value = CurrencyService.class)
@ContextConfiguration(classes= {CurrencyRepo.class})
public class CurrencyServiceTest {

	@InjectMocks
	CurrencyService service;
	
	@MockBean
	CurrencyRepo repository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(repository);
	}
	
	@Test
	public void create_payment_link_success() throws Exception {
		CurrencyRequest request = CurrencyFactory.createCurrencyRequest();
		CurrencyMasterEntity entity = CurrencyFactory.createCurrencyEntityResponse();
		//mock response
		when(repository.findById(request.getCurrencyCode())).thenReturn(entity);
		//actual response
		CurrencyResponse actualResponse = service.findById(request);
		assertEquals("200",actualResponse.getStatus());
		
	}

	
}
