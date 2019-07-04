package com.khetao.auth.jwt;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.jwt.crypto.sign.Signer;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-06-15
 */
public class JwtTokenConverter implements TokenEnhancer, AccessTokenConverter, InitializingBean {

    public static final String TOKEN_ID = AccessTokenConverter.JTI;

    private String verifierKey = new RandomValueStringGenerator().generate();

    private Signer signer = new MacSigner(verifierKey);

    private AccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();

    /**
     * @param tokenConverter the tokenConverter to set
     */
    public void setAccessTokenConverter(AccessTokenConverter tokenConverter) {
        this.tokenConverter = tokenConverter;
    }

    /**
     * @return the tokenConverter in use
     */
    public AccessTokenConverter getAccessTokenConverter() {
        return tokenConverter;
    }

    /**
     * Unconditionally set the signer to use (if needed). The signer key is then ignored.
     *
     * @param signer the value to use
     */
    public void setSigner(Signer signer) {
        this.signer = signer;
    }




    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public Map<String, ?> convertAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        return tokenConverter.convertAccessToken(token, authentication);
    }

    @Override
    public OAuth2AccessToken extractAccessToken(String value, Map<String, ?> map) {
        return tokenConverter.extractAccessToken(value, map);
    }

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        return tokenConverter.extractAuthentication(map);
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        DefaultOAuth2AccessToken result = new DefaultOAuth2AccessToken(accessToken);
        Map<String, Object> info = new LinkedHashMap<String, Object>(accessToken.getAdditionalInformation());
        String tokenId = result.getValue();
        if (!info.containsKey(TOKEN_ID)) {
            info.put(TOKEN_ID, tokenId);
        }
        else {
            tokenId = (String) info.get(TOKEN_ID);
        }
        result.setAdditionalInformation(info);
        result.setValue(JSON.toJSONString(tokenConverter.convertAccessToken(accessToken, authentication)));

        OAuth2RefreshToken refreshToken = result.getRefreshToken();
        if (refreshToken != null) {
            DefaultOAuth2AccessToken encodedRefreshToken = new DefaultOAuth2AccessToken(accessToken);
            encodedRefreshToken.setValue(refreshToken.getValue());
            // Refresh tokens do not expire unless explicitly of the right type
            encodedRefreshToken.setExpiration(null);

        }


        return null;
    }



   /* protected JwtPayload decode(String token) {
        try {
            JWSObject jwsObject = JWSObject.parse(token);
            Payload payload = jwsObject.getPayload();
            JSONObject jsonObject = payload.toJSONObject();
            JwtPayload jwtPayload = null;
            if (null != jsonObject) {
                jwtPayload = JSON.parseObject(jsonObject.toJSONString(), JwtPayload.class);
            }
            if (null == jwtPayload) {
                throw new InvalidTokenException("token invalid...");
            }

            String claimsStr = jwt.getClaims();
            Map<String, Object> claims = objectMapper.parseMap(claimsStr);
            if (claims.containsKey(EXP) && claims.get(EXP) instanceof Integer) {
                Integer intValue = (Integer) claims.get(EXP);
                claims.put(EXP, new Long(intValue));
            }
            this.getJwtClaimsSetVerifier().verify(claims);
            return claims;
        }
        catch (Exception e) {
            throw new InvalidTokenException("Cannot convert access token to JSON", e);
        }

    }*/


}
