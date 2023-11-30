package com.example.stock.management;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StockAddedEvent implements StockEvent {

	
	private Stock stockDetails;
	
}
