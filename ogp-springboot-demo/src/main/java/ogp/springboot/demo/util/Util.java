package ogp.springboot.demo.util;

import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

import ogp.springboot.demo.enumer.JwtConstant;

@Component
public class Util {

	public String generateJWTToken() throws RuntimeException {
		String header = JwtConstant.HEADER.getValue();
		String base64UrlHeader = Base64.getUrlEncoder().withoutPadding().encodeToString(header.getBytes());

		// JWT token expires 60 seconds from now
		// long timeSecs = (System.currentTimeMillis() / 1000) + 60;

		String payload = JwtConstant.PAYLOAD.getValue();
		String base64UrlPayload = Base64.getUrlEncoder().withoutPadding().encodeToString(payload.getBytes());

		try {
			String base64UrlSignature = hmacEncode(base64UrlHeader + "." + base64UrlPayload,
					JwtConstant.SECRET.getValue());
			return base64UrlHeader + "." + base64UrlPayload + "." + base64UrlSignature;

		} catch (Exception e) {
			throw new RuntimeException("Unable to generate a JWT token.");
		}
	}

	/**
	 * Helper method that encodes data using HmacSHA256 and key.
	 * 
	 * @param data data to encode
	 * @param key  Secret key used during encoding.
	 * @return Base64UrlEncoded string without padding
	 */
	private String hmacEncode(String data, String key) throws Exception {
		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(), "HmacSHA256");
		sha256_HMAC.init(secret_key);

		return Base64.getUrlEncoder().withoutPadding().encodeToString(sha256_HMAC.doFinal(data.getBytes()));
	}
}
