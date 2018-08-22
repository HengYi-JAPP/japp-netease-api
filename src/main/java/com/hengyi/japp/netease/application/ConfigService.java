package com.hengyi.japp.netease.application;

import com.hengyi.japp.netease.interfaces.oa.dto.OaCompany;
import com.hengyi.japp.netease.interfaces.oa.dto.OaDepartment;

import java.util.stream.Stream;

public interface ConfigService {
    void addCompany(Integer id);

    void removeCompany(Integer id);

    Stream<OaCompany> listCompany();

    void addDepartment(Integer id);

    void removeDepartment(Integer id);

    Stream<OaDepartment> listDepartment();

    Stream<String> listWhiteSet() throws Exception;

    Stream<String> listBlackSet() throws Exception;
}
