package com.hengyi.japp.netease.interfaces.oa;

import com.hengyi.japp.netease.interfaces.oa.dto.OaCompany;
import com.hengyi.japp.netease.interfaces.oa.dto.OaDepartment;
import com.hengyi.japp.netease.interfaces.oa.dto.OaJobTitle;
import com.hengyi.japp.netease.interfaces.oa.dto.OaMember;

import java.util.stream.Stream;

public interface OaService {
    Stream<OaCompany> listCompany();

    OaCompany findCompany(Integer id);

    Stream<OaDepartment> listDepartment();

    Stream<OaDepartment> queryDepartment(String q);

    Stream<OaDepartment> listDepartmentBySupdepId(Integer id);

    OaDepartment findDepartment(Integer id);

    Stream<OaJobTitle> listJobTitle();

    Stream<OaMember> listMember();
}
