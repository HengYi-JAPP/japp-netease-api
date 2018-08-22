package com.hengyi.japp.netease;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 描述：
 *
 * @author jzb 2017-11-10
 */
public class Util {
    public static Stream<Map<String, Object>> querySql(DataSource ds, String sql) {
        try {
            return new QueryRunner(ds).query(sql, new MapListHandler()).stream();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
