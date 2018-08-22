package com.hengyi.japp.netease.interfaces.oa.dto;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.ixtf.japp.ee.Jee;
import com.hengyi.japp.netease.interfaces.netease.NIDepartment;
import com.hengyi.japp.netease.interfaces.oa.OaService;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

@Data
public class OaDepartment implements NIDepartment {
    private Integer id;
    private Integer subcompanyid1;
    private Integer supdepid;
    private String departmentname;
    @JsonIgnore
    private String canceled;

    public OaDepartment(Map<String, Object> map) {
        id = (Integer) map.get("id");
        subcompanyid1 = (Integer) map.get("subcompanyid1");
        supdepid = (Integer) map.get("supdepid");
        departmentname = (String) map.get("departmentname");
        canceled = (String) map.get("canceled");
    }

    @JsonGetter
    public String getFullPathName() {
        final OaService oaService = Jee.getBean(OaService.class);
        OaCompany company = oaService.findCompany(subcompanyid1);
        return company.getSubcompanyname() + "/" + getFullPathName(oaService);
    }

    private String getFullPathName(OaService oaService) {
        if (isTop()) {
            return departmentname;
        }
        OaDepartment supDep = oaService.findDepartment(supdepid);
        return supDep.getFullPathName(oaService);
    }

    @JsonIgnore
    public boolean isValid() {
        return !Objects.equals("1", canceled);
    }

    @JsonIgnore
    public boolean isTop() {
        return supdepid == null || 0 == supdepid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OaDepartment that = (OaDepartment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String id() {
        return "" + id;
    }

    @Override
    public String parentId() {
        return supdepid == 0 ? ("subcompany-" + subcompanyid1) : ("" + supdepid);
    }

    @Override
    public String name() {
        return departmentname;
    }
}
