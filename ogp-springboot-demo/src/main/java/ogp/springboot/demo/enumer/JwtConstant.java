package ogp.springboot.demo.enumer;

public enum JwtConstant {
	
	HEADER("{\"typ\":\"JWT\",\"alg\":\"HS256\"}"), 
	PAYLOAD("{\"clientId\":\"IDBNIU0FOREJPWA==\",\"accountNo\":\"0115476117\"}"),
	SECRET("ab80ff61-bb0e-4f36-8cb1-e5d80796ace9");

	private String value;

	JwtConstant(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
