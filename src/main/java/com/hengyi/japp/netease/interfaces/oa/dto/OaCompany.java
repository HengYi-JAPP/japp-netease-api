package com.hengyi.japp.netease.interfaces.oa.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hengyi.japp.netease.interfaces.netease.NIDepartment;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

/**
 * 描述：
 *
 * @author jzb 2017-11-10
 */
@Data
public class OaCompany implements NIDepartment {
    private Integer id;
    private String subcompanyname;
    private Integer supsubcomid;
    @JsonIgnore
    private String canceled;

    public OaCompany(Map<String, Object> map) {
        id = (Integer) map.get("id");
        supsubcomid = (Integer) map.get("supsubcomid");
        subcompanyname = (String) map.get("subcompanyname");
        canceled = (String) map.get("canceled");
    }

    @JsonIgnore
    public boolean isTop() {
        return supsubcomid == null || 0 == supsubcomid;
    }

    @JsonIgnore
    public boolean isValid() {
        return !Objects.equals("1", canceled);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OaCompany company = (OaCompany) o;
        return Objects.equals(id, company.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String id() {
        return "subcompany-" + id;
    }

    @Override
    public String parentId() {
        return supsubcomid == 0 ? null : "subcompany-" + supsubcomid;
    }

    @Override
    public String name() {
        return subcompanyname;
    }
}
