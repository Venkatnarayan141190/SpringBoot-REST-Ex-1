package currency.inrvalue.service;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import currency.inrvalue.dao.CurrencyDao;
import currency.inrvalue.io.CurrencyRequest;
import currency.inrvalue.io.CurrencyResponse;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CurrencyService {

	@Autowired
	CurrencyDao currencyDao;
	
	public CurrencyResponse findById(CurrencyRequest request) {
		log.info("in get find currency inr value using currency code");
		CurrencyResponse responseEntityPage = currencyDao.findById(request.getCurrencyCode());
		return responseEntityPage;
	}
	
	public CurrencyResponse findByIdAndDate(CurrencyRequest request) {
		LocalDate date01 = LocalDate.parse(request.getDate());  
		Date date1 = java.sql.Date.valueOf(date01);
		log.info("in get find currency inr value using currency code and date");
		return currencyDao.findByIdAndDate(request.getCurrencyCode(),date1);
	}
	
	public void addCurrencyHistory() {
		currencyDao.addCurrencyHistory();
	}

}
