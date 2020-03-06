package bni.ogp.integration.enumer;

public enum Environment {
	
	GET_BALANCE("getbalance"),
	GET_HOUSE_INQUIRY("getinhouseinquiry"),
	GET_PAYMENT_STATUS("getpaymentstatus"),
	
	DEV("https://apidev.bni.co.id:8067/H2H/v2/"),
	BNI("https://apidev.bni.co.id:8067/api/oauth/token"), 
	AUTH("MTg2NzAzY2EtMTQxYS00OTZiLWI0M2MtMzk2NDY1Zjk5MzI0OmVkMTRiZjJlLWU2YmEtNGZmYi04OWY2LTYxMjQzOTJiODA0NQ==");
    
	private String url;

	Environment(String envUrl) {
		this.url = envUrl;
	}

	public String getUrl() {
		return url;
	}
	
}
