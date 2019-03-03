package currency.inrvalue.io;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyInrResponse {

	private Long id;
	private String currencycodeinalpha;
	private String inrvalue;
	private Date createddate;
	
}
