package bni.ogp.integration.enumer;

public enum ResponseCode {

	SUCCESS("200 OK"), BAD_REQUEST("400"), INTERNAL_SERVER_ERROR("500");

	private String httpCode;

	ResponseCode(String httpCode) {
		this.httpCode = httpCode;
	}

	public String getHttpCode() {
		return httpCode;
	}

}
