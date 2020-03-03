package ogp.springboot.demo.enumer;

public enum Environment {
	
	DEV("https://apidev.bni.co.id:8067/"),
	BNI("https://apidev.bni.co.id:8067/api/oauth/token"), 
	GET_BALANCE("getbalance"),
	AUTH("MTg2NzAzY2EtMTQxYS00OTZiLWI0M2MtMzk2NDY1Zjk5MzI0OmVkMTRiZjJlLWU2YmEtNGZmYi04OWY2LTYxMjQzOTJiODA0NQ==");
    
	private String url;

	Environment(String envUrl) {
		this.url = envUrl;
	}

	public String getUrl() {
		return url;
	}
	
}
