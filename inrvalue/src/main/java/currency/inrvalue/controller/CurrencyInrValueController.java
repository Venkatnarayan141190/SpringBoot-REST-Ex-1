package currency.inrvalue.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import currency.inrvalue.io.CurrencyRequest;
import currency.inrvalue.io.CurrencyResponse;
import currency.inrvalue.service.CurrencyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value={"/inrvalue"}, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "CurrencyInrValue", description = "REST APIs Convert Currency into inr value!!!!")
public class CurrencyInrValueController {

	@Autowired
	CurrencyService currencyService;
	
	/**
	 * This API is used to get Currency INR value using currency code and date.
	 * @author Venkatnarayan
	 * @param request
	 * @return
	 * @throws 
	 */
	@GetMapping(value = "/fetch")
    @ApiOperation(value = "Get currency inr value by code in the System using code and date ", response = List.class, tags = "fetchcurrencyinrvalue")
	public ResponseEntity<CurrencyResponse> getCurrencyInrValueByIdAndDate(@RequestBody CurrencyRequest request) throws ParseException {
		log.info("CurrencyInrValueController :: getCurrencyInrValueByIdAndDate() :: Init " + request.toString());
		CurrencyResponse response = currencyService.findByIdAndDate(request);
		log.info("CurrencyInrValueController :: getCurrencyInrValueByIdAndDate() :: End " + response.toString());
		return ResponseEntity.ok(response); 
	}
}
