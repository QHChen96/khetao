package com.khetao.auth.util;

import com.google.gson.Gson;
import com.khetao.auth.security.jwt.JwtSettings;
import com.khetao.base.BaseServiceException;
import com.khetao.common.util.DateTimeUtil;
import com.khetao.dto.KhetaoUser;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

/**
 * <p>
 *  jwt 工具类
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-20
 */
@Slf4j
@AllArgsConstructor
@Component
public class JwtUtil {

    private final JwtSettings jwtSettings;

    public String createJwt(KhetaoUser khetaoUser) {
        if (log.isDebugEnabled()) {
            log.debug("create jwt from ''", khetaoUser);
        }
        Assert.notNull(khetaoUser, "User required");
        Assert.notNull(khetaoUser.getUserId(), "User Id required");
        long now = DateTimeUtil.timestampSeconds();
        long exp = now + jwtSettings.getExpireSeconds();
        JwtPayload payload = new JwtPayload();
        payload
                .setJti(UUID.randomUUID().toString())
                .setUid(khetaoUser.getUserId())
                .setSub(khetaoUser.getUsername())
                .setIss(jwtSettings.getIss())
                .setAud(khetaoUser.getClientId())
                .setIat(now)
                .setNbf(now)
                .setExp(exp)
                .setAuthorities(khetaoUser.getAuthorities());
        return encode(payload);
    }

    /**
     * 编码
     * @param jwtPayload
     * @return
     */
    public String encode(JwtPayload jwtPayload) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(jwtPayload);
            if (log.isDebugEnabled()) {
                log.debug("jwt encode json【{}】", json);
            }
            return encode(json);
        } catch (Exception ex) {
            log.error("jwt verify cause {}", ex.getMessage());
        }
        return null;
    }

    /**
     * 编码
     * @param json
     * @return
     */
    public String encode(String json) {
        try {
            JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.HS256).type(JOSEObjectType.JWT).build();
            Payload payload = new Payload(json);
            JWSObject jwsObject = new JWSObject(header, payload);
            JWSSigner signer = new MACSigner(jwtSettings.getSecretKey().getBytes());
            jwsObject.sign(signer);
            return jwsObject.serialize();
        }  catch (Exception ex) {
            log.error("jwt verify cause {}", ex.getMessage());
        }
        return null;
    }

    /**
     * 解码
     * @param token
     * @return
     */
    public JwtPayload decode(String token) {
        try {
            if (log.isDebugEnabled()) {
                log.debug("jwt decode token【{}】", token);
            }
            JWSObject jwsObject = JWSObject.parse(token);
            JWSVerifier verifier = new MACVerifier(jwtSettings.getSecretKey().getBytes());
            boolean isPass = jwsObject.verify(verifier);
            if (!isPass) {
                return null;
            }
            Gson gson = new Gson();
            return gson.fromJson(jwsObject.getPayload().toString(), JwtPayload.class);
        } catch (Exception ex) {
            log.error("jwt decode cause {}", ex.getMessage());
        }
        return null;
    }

    /**
     * 获取用户id
     * @param token
     * @return
     */
    public Long getUserId(String token) {
        JwtPayload payload = decode(token);
        return payload.getUid();
    }

    /**
     * 检查
     * @param payload
     * @return
     */
    public boolean validate(JwtPayload payload) {
        try {
            // 10秒, 消除网络抖动
            long now = LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(8)) + 10;
            if (null == payload) {
                throw new BaseServiceException("token validate illegality!");
            }
            // 验证时间

            if (now < payload.getNbf().longValue() || now > payload.getExp().longValue()) {
                throw new BaseServiceException("token is invalid!");
            }
            return true;
        } catch (BaseServiceException ex) {
            log.error("jwt verify cause {}", ex.getMessage());
        }
        return false;
    }


}
