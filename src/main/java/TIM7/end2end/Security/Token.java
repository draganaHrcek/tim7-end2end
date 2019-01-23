package TIM7.end2end.Security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;



import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Token {
	
	public static String generateToken(String userDetails) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("sub", userDetails);
		claims.put("created", new Date(System.currentTimeMillis()));
		return Jwts.builder().setClaims(claims)
				.setExpiration(new Date(System.currentTimeMillis() + 18000 * 1000))
				.signWith(SignatureAlgorithm.HS512, "myXAuthSecret").compact();
	}

}
