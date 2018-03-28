package com.zkx.house.user.utils;

import java.util.Date;
import java.util.Map;
import java.util.function.BiConsumer;

import org.apache.commons.lang3.time.DateUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.collect.Maps;

public class JwtHelper {
  
  private static final String  SECRET = "session_secret";
  
  private static final String  ISSUER = "zkx_user";
  
  
  public static String genToken(Map<String, String> claims){
    try {
      Algorithm algorithm = Algorithm.HMAC256(SECRET);
      final JWTCreator.Builder builder = JWT.create().withIssuer(ISSUER).withExpiresAt(DateUtils.addDays(new Date(), 1));
      
      claims.forEach(new BiConsumer<String, String>() {
		public void accept(String k, String v) {
			builder.withClaim(k, v);
		}
	});
      return builder.sign(algorithm).toString();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  public static Map<String, String> verifyToken(String token)  {
    Algorithm algorithm = null;
    try {
      algorithm = Algorithm.HMAC256(SECRET);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
    DecodedJWT jwt =  verifier.verify(token);
    Map<String, Claim> map = jwt.getClaims();
    final Map<String, String> resultMap = Maps.newHashMap();
    map.forEach((k,v) -> resultMap.put(k, v.asString()));
    return resultMap;
  }

}
