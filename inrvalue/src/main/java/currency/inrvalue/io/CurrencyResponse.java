package currency.inrvalue.io;

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
public class CurrencyResponse {

	private String status;
	private StatusMessage statusMessage;
	private CurrencyInrResponse currencyInrValueResponse;
}
