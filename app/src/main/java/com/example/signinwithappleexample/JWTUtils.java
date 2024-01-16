package com.example.signinwithappleexample;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.*;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.RSAPublicKeySpec;

public class JWTUtils {

    private static PublicKey getPublicKey() throws Exception {
        String publicKeyString = "4dGQ7bQK8LgILOdLsYzfZjkEAoQeVC_aqyc8GC6RX7dq_KvRAQAWPvkam8VQv4GK5T4ogklEKEvj5ISBamdDNq1n52TpxQwI2EqxSk7I9fKPKhRt4F8-2yETlYvye-2s6NeWJim0KBtOVrk0gWvEDgd6WOqJl_yt5WBISvILNyVg1qAAM8JeX6dRPosahRVDjA52G2X-Tip84wqwyRpUlq2ybzcLh3zyhCitBOebiRWDQfG26EH9lTlJhll-p_Dg8vAXxJLIJ4SNLcqgFeZe4OfHLgdzMvxXZJnPp_VgmkcpUdRotazKZumj6dBPcXI_XID4Z4Z3OM1KrZPJNdUhxw";
        String publicKeyExponent = "AQAB";

        BigInteger n = new BigInteger(1, Decoders.BASE64URL.decode(publicKeyString));
        BigInteger e = new BigInteger(1, Decoders.BASE64URL.decode(publicKeyExponent));

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        KeySpec publicKeySpec = new RSAPublicKeySpec(n, e);
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

        return publicKey;
    }

    public static Claims decodeJwt(String jwt) throws Exception {
        PublicKey publicKey = getPublicKey();

        return Jwts.parserBuilder().setSigningKey(publicKey).build().parseClaimsJws(jwt).getBody();

        /*return Jwts.parser()
                .setSigningKey(publicKey)
                .parseClaimsJws(jwt)
                .getBody(); // will throw exception if token is expired, etc.*/
    }
}
