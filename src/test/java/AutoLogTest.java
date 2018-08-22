import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.ixtf.japp.core.J;
import com.google.common.collect.ImmutableMap;
import com.hengyi.japp.netease.interfaces.netease.AESCipherUtils;

import static com.github.ixtf.japp.core.Constant.MAPPER;
import static com.hengyi.japp.netease.Constant.NETEASE_APPKEY;
import static com.hengyi.japp.netease.Constant.NETEASE_AUTOLOGINSECRET;

/**
 * 描述：
 *
 * @author jzb 2017-11-08
 */
public class AutoLogTest {
    static String urlTpl = "http://hengyi.study.163.com/api/account/outAutoLogin.do?appId=" + NETEASE_APPKEY + "&value=${value}";

    public static void main(String[] args) throws Exception {
        final ObjectNode node = MAPPER.createObjectNode()
                .put("appId", NETEASE_APPKEY)
                .put("timestamp", System.currentTimeMillis())
                .put("loginId", "12000707")
                .put("url", "http://hengyi.study.163.com");
        final String json = MAPPER.writeValueAsString(node);
        String value = AESCipherUtils.encryptBcdString(json, NETEASE_AUTOLOGINSECRET);
        System.out.println(J.strTpl(urlTpl, ImmutableMap.of("value", value)));
    }
}
