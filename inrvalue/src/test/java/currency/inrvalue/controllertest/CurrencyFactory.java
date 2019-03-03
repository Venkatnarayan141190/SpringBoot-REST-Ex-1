package currency.inrvalue.controllertest;

import currency.inrvalue.bean.CurrencyMasterEntity;
import currency.inrvalue.io.CurrencyRequest;
import currency.inrvalue.io.CurrencyResponse;
import currency.inrvalue.io.StatusMessage;

public class CurrencyFactory {

	
	public static CurrencyRequest createCurrencyRequest() {
		return CurrencyRequest.builder().currencyCode(Long.parseLong("123")).date("10/12/2019").build();
	}
	
	public static CurrencyResponse createCurrencyResponse() {
		return 	CurrencyResponse.builder().status("200").statusMessage(new StatusMessage("SUCCESS", "Successfully fetched")).build();
	}
	
	public static CurrencyMasterEntity createCurrencyEntityResponse() {
		return 	CurrencyMasterEntity.builder().
				country("US").
				currencycode(Long.parseLong("123"))
				.currencycodeinalpha("USD").
				build();
	}
}
