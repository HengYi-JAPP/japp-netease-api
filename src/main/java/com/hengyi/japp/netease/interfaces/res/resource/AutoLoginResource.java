package com.hengyi.japp.netease.interfaces.res.resource;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.ixtf.japp.core.J;
import com.google.common.collect.ImmutableMap;
import com.hengyi.japp.netease.interfaces.netease.AESCipherUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.net.URI;

import static com.github.ixtf.japp.core.Constant.MAPPER;
import static com.hengyi.japp.netease.Constant.NETEASE_APPKEY;
import static com.hengyi.japp.netease.Constant.NETEASE_AUTOLOGINSECRET;

/**
 * 描述：
 *
 * @author jzb 2017-11-08
 */
@Path("autologin")
public class AutoLoginResource {
    public static final String AUTO_LOGIN_URL_TPL = "http://hengyi.study.163.com/api/account/outAutoLogin.do?appId=" + NETEASE_APPKEY + "&value=${value}";
    public static final String INDEX_URL = "http://hengyi.study.163.com";

    @GET
    public Response autoLogin(@Context SecurityContext sc) throws Exception {
        final String loginId = sc.getUserPrincipal().getName();
        final ObjectNode node = MAPPER.createObjectNode()
                .put("appId", NETEASE_APPKEY)
                .put("timestamp", System.currentTimeMillis())
                .put("loginId", loginId)
                .put("url", INDEX_URL);
        final String json = MAPPER.writeValueAsString(node);
        String value = AESCipherUtils.encryptBcdString(json, NETEASE_AUTOLOGINSECRET);
        final String url = J.strTpl(AUTO_LOGIN_URL_TPL, ImmutableMap.of("value", value));
        return Response.seeOther(URI.create(url)).build();
    }

    @Path("italent")
    @GET
    public Response autoLoginItalent(@Context SecurityContext sc) throws Exception {
        final String loginId = sc.getUserPrincipal().getName();
        final ObjectNode node = MAPPER.createObjectNode()
                .put("appId", NETEASE_APPKEY)
                .put("timestamp", System.currentTimeMillis())
                .put("loginId", loginId)
                .put("url", INDEX_URL);
        final String json = MAPPER.writeValueAsString(node);
        String value = AESCipherUtils.encryptBcdString(json, NETEASE_AUTOLOGINSECRET);
        final String url = J.strTpl(AUTO_LOGIN_URL_TPL, ImmutableMap.of("value", value));
        return Response.seeOther(URI.create(url)).build();
    }
}
