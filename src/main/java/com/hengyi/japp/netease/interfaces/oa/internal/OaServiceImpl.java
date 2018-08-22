package com.hengyi.japp.netease.interfaces.oa.internal;

import com.github.ixtf.japp.core.J;
import com.google.common.collect.ImmutableMap;
import com.hengyi.japp.netease.Constant;
import com.hengyi.japp.netease.Util;
import com.hengyi.japp.netease.interfaces.oa.OaService;
import com.hengyi.japp.netease.interfaces.oa.dto.OaCompany;
import com.hengyi.japp.netease.interfaces.oa.dto.OaDepartment;
import com.hengyi.japp.netease.interfaces.oa.dto.OaJobTitle;
import com.hengyi.japp.netease.interfaces.oa.dto.OaMember;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.util.stream.Stream;

@Stateless
public class OaServiceImpl implements OaService {
    @Resource(lookup = Constant.OA_DS)
    private DataSource oaDS;

    @Override
    public Stream<OaCompany> listCompany() {
        return Util.querySql(oaDS, "SELECT * FROM HrmSubCompany").map(OaCompany::new).filter(OaCompany::isValid);
    }

    @Override
    public OaCompany findCompany(Integer id) {
        final String sqlTpl = "SELECT * FROM HrmSubCompany WHERE id=${id}";
        final String sql = J.strTpl(sqlTpl, ImmutableMap.of("id", "" + id));
        return Util.querySql(oaDS, sql).map(OaCompany::new).filter(OaCompany::isValid).findFirst().orElse(null);
    }

    @Override
    public Stream<OaDepartment> listDepartment() {
        return Util.querySql(oaDS, "SELECT * FROM HrmDepartment").map(OaDepartment::new).filter(OaDepartment::isValid);
    }

    @Override
    public Stream<OaDepartment> queryDepartment(String q) {
        if (J.isBlank(q)) {
            return listDepartment();
        }
        final String sqlTpl = "SELECT * FROM HrmDepartment WHERE departmentname LIKE '%${q}%'";
        final String sql = J.strTpl(sqlTpl, ImmutableMap.of("q", q));
        return Util.querySql(oaDS, sql).map(OaDepartment::new).filter(OaDepartment::isValid);
    }

    @Override
    public OaDepartment findDepartment(Integer id) {
        final String sqlTpl = "SELECT * FROM HrmDepartment WHERE id=${id}";
        final String sql = J.strTpl(sqlTpl, ImmutableMap.of("id", "" + id));
        return Util.querySql(oaDS, sql).map(OaDepartment::new).filter(OaDepartment::isValid).findFirst().orElse(null);
    }

    @Override
    public Stream<OaDepartment> listDepartmentBySupdepId(Integer supdepid) {
        final String sqlTpl = "SELECT * FROM HrmDepartment WHERE supdepid=${supdepid}";
        final String sql = J.strTpl(sqlTpl, ImmutableMap.of("supdepid", "" + supdepid));
        return Util.querySql(oaDS, sql).map(OaDepartment::new).filter(OaDepartment::isValid);
    }

    @Override
    public Stream<OaJobTitle> listJobTitle() {
        return Util.querySql(oaDS, "SELECT * FROM HrmJobTitles").map(OaJobTitle::new);
    }

    @Override
    public Stream<OaMember> listMember() {
        return Util.querySql(oaDS, "SELECT * FROM HrmResource WHERE status=1").map(OaMember::new);
    }
}
