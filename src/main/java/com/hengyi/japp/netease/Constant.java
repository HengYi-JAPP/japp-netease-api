package com.hengyi.japp.netease;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Constant {
    public static final Properties CONFIG;
    // 人员白名单
    public static final String WHITE_SET_PATH;
    // 人员黑名单
    public static final String BLACK_SET_PATH;
    // 部门配置
    public static final String DEPARTMENTS_PATH;
    // 公司配置
    public static final String COMPANIES_PATH;
    public static final String NETEASE_APPKEY;
    public static final String NETEASE_APPSECRET;
    public static final String NETEASE_AUTOLOGINSECRET;
    public static final String OA_DS = "java:/oaDS";
    public static final String NETEASE_API = "neteaseInterfaces";

    static {
        try {
            CONFIG = new Properties();
            CONFIG.load(new FileReader(new File(System.getProperty("NETEASE_API_CONFIG", "/home/japp-netease-api/config.properties"))));

            WHITE_SET_PATH = CONFIG.getProperty("WHITE_SET_PATH", "/home/japp-netease-api/white_set.xlsx");
            BLACK_SET_PATH = CONFIG.getProperty("BLACK_SET_PATH", "/home/japp-netease-api/black_set.xlsx");
            DEPARTMENTS_PATH = CONFIG.getProperty("DEPARTMENTS_PATH", "/home/japp-netease-api/departments.json");
            COMPANIES_PATH = CONFIG.getProperty("COMPANIES_PATH", "/home/japp-netease-api/companies.json");

            NETEASE_APPKEY = CONFIG.getProperty("NETEASE_APPKEY", "14c79da996f34c1bad4e92ec0d58cdd5");
            NETEASE_APPSECRET = CONFIG.getProperty("NETEASE_APPSECRET", "8e5562f00cf878fb930c6bcc0a8e7056");
            NETEASE_AUTOLOGINSECRET = CONFIG.getProperty("NETEASE_AUTOLOGINSECRET", "87a7815300dbf285ad6091b4d1cf2f4b");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
