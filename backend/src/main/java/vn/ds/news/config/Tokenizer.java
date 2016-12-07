package vn.ds.news.config;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.impl.compression.CompressionCodecs;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class Tokenizer {
	public final static int EXPIRED = 120;
	private static Key KEY = MacProvider.generateKey();

	public static String generate(String username) {
		if (username == null) {
			throw new NullPointerException("null user is illegal");
		}
		Claims claims = new DefaultClaims();
		claims.setSubject(username);
		claims.setIssuedAt(new Date());
		claims.setExpiration(getExpired());
		return Jwts.builder().setClaims(claims).compressWith(CompressionCodecs.DEFLATE)
				.signWith(SignatureAlgorithm.HS512, KEY).compact();
	}

	public static JWTPrincipal parse(String token)
			throws ExpiredJwtException, MalformedJwtException, SignatureException, IllegalArgumentException {
		Claims claims = (Claims) Jwts.parser().setSigningKey(KEY).parse(token).getBody();
		return new JWTPrincipal(claims.getSubject());
	}

	private static Date getExpired() {
		Calendar expired = Calendar.getInstance();
		expired.add(Calendar.SECOND, EXPIRED);
		return expired.getTime();
	}

}
