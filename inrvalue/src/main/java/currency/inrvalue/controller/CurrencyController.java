package currency.inrvalue.controller;

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
@RequestMapping(value={"/rate-exchange"}, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "CurrencyController", description = "REST APIs Convert Currency into inr value!!!!")
public class CurrencyController {
	
	@Autowired
	CurrencyService currencyService;
	
	/**
	 * This API is used to get Currency INR value using currency code.
	 * @author Venkatnarayan
	 * @param request
	 * @return
	 * @throws 
	 */
	@GetMapping(value = "/currency")
    @ApiOperation(value = "Get currency inr value by code in the System ", response = List.class, tags = "fetchcurrencyinrvalue")
	public ResponseEntity<CurrencyResponse> getCurrencyInrValueById(@RequestBody CurrencyRequest request) {
		log.info("CurrencyController :: getCurrencyInrValueById() :: Init" + request.toString());
		CurrencyResponse response = currencyService.findById(request);
		log.info("CurrencyController :: getCurrencyInrValueById() :: End" + response.toString());
        return ResponseEntity.ok(response);
	}	
}
