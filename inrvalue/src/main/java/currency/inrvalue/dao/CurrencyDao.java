package currency.inrvalue.dao;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import currency.inrvalue.bean.CurrencyHistory;
import currency.inrvalue.bean.CurrencyMasterEntity;
import currency.inrvalue.io.CurrencyInrResponse;
import currency.inrvalue.io.CurrencyResponse;
import currency.inrvalue.io.StatusMessage;
import currency.inrvalue.repo.CurrencyInrValueRepo;
import currency.inrvalue.repo.CurrencyRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CurrencyDao {

	@Autowired
	CurrencyInrValueRepo currencyInrValuerepo;
	
	@Autowired
	CurrencyRepo currencyrepo;
	
	
	public CurrencyResponse findById(Long currencycode) {
		CurrencyHistory currencyHistory = null;
		CurrencyResponse responseEntityPage = null;
		boolean gotResults = false;
		CurrencyMasterEntity cme = currencyrepo.findById(currencycode);
		if(cme != null) {
			Date localDate = java.sql.Date.valueOf(LocalDate.now());
			log.info("Date is "+localDate);
			log.info("code in alpha "+cme.getCurrencycodeinalpha()+" date is "+localDate);
			currencyHistory = currencyInrValuerepo.findByCurrencyAndDate(cme.getCurrencycodeinalpha(),localDate);	
			if(currencyHistory != null) {
				gotResults = true;
				StatusMessage statusMessageResponseEntity = StatusMessage.builder()
						.code("SUCCESS")
						.desc("CurrencyInrValue Found for the currency code..!!!")
						.build();

				CurrencyInrResponse currencyInrValueResponse = CurrencyInrResponse.builder()
						.id(currencyHistory.getId())
						.createddate(currencyHistory.getCreateddate())
						.inrvalue(currencyHistory.getInrvalue())
						.currencycodeinalpha(currencyHistory.getCurrencycodeinalpha())
						.build();
				
				responseEntityPage = CurrencyResponse.builder()
						.statusMessage(statusMessageResponseEntity)
						.currencyInrValueResponse(currencyInrValueResponse)
						.status("200").
						build();
			}
		}
		if(gotResults==false) {
			StatusMessage statusMessageResponseEntity = StatusMessage.builder()
					.code("SUCCESS")
					.desc("CurrencyInrValue Not Found for the currency code..!!!")
					.build();

			responseEntityPage = CurrencyResponse.builder()
								.statusMessage(statusMessageResponseEntity)
								.status("200").
								build();
		}
		return responseEntityPage;
	}

	
	
	public CurrencyResponse findByIdAndDate(Long currencycode, Date date) {
		CurrencyHistory currencyHistory = null;
		CurrencyResponse responseEntityPage = null;
		boolean gotResults = false;
		CurrencyMasterEntity cme = currencyrepo.findById(currencycode);
		if(cme != null) {
			Date localDate = java.sql.Date.valueOf(LocalDate.now());
			log.info("Date is "+localDate);
			log.info("code in alpha "+cme.getCurrencycodeinalpha()+" date is "+date);
			currencyHistory = currencyInrValuerepo.findByCurrencyAndDate(cme.getCurrencycodeinalpha(), date);
			if(currencyHistory != null) {
				gotResults = true;
				StatusMessage statusMessageResponseEntity = StatusMessage.builder()
						.code("SUCCESS")
						.desc("CurrencyInrValue Found for the currency code..!!!")
						.build();

				CurrencyInrResponse currencyInrValueResponse = CurrencyInrResponse.builder()
						.id(currencyHistory.getId())
						.createddate(currencyHistory.getCreateddate())
						.inrvalue(currencyHistory.getInrvalue())
						.currencycodeinalpha(currencyHistory.getCurrencycodeinalpha())
						.build();
				
				responseEntityPage = CurrencyResponse.builder()
						.statusMessage(statusMessageResponseEntity)
						.currencyInrValueResponse(currencyInrValueResponse)
						.status("200").
						build();
			}
		}
		if(gotResults==false) {
			StatusMessage statusMessageResponseEntity = StatusMessage.builder()
					.code("SUCCESS")
					.desc("CurrencyInrValue Not Found for the currency code..!!!")
					.build();

			responseEntityPage = CurrencyResponse.builder()
								.statusMessage(statusMessageResponseEntity)
								.status("200").
								build();
		}
		return responseEntityPage;

	}

	
	public void addCurrencyHistory() {
		// TODO Auto-generated method stub
		Date createddate = java.sql.Date.valueOf(LocalDate.now());
		/*CurrencyMasterEntity entity1 = new CurrencyMasterEntity();
		entity1.setCountry("CHINA");
 		entity1.setCurrencycode((long) 156);
 		entity1.setCurrencycodeinalpha("CNY");
 		currencyrepo.save(entity1);*/
		currencyrepo.addCurrencyMaster((long)156,"CHINA", "CNY");
		currencyrepo.addCurrencyMaster((long)036,"AUSTRALIA", "AUD");
		currencyrepo.addCurrencyMaster((long)840,"USA", "USD");
		
		currencyInrValuerepo.addCurrencyHistory(createddate, "CNY", "10.58");
		currencyInrValuerepo.addCurrencyHistory(createddate, "AUD", "50.56");
		currencyInrValuerepo.addCurrencyHistory(createddate, "USD", "71.06");
	}

}
