package com.hengyi.japp.netease.interfaces.oa.dto;


import com.hengyi.japp.netease.interfaces.netease.NIMember;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

@Data
public class OaMember implements NIMember {
    private final Integer id;
    private final String workcode;
    private final String name;
    private final String mobile;
    private final String email;
    // 职级
    private final Integer jobcall;
    // 岗位
    private final Integer jobtitle;
    private final Integer subcompanyid1;
    private final Integer departmentid;

    public OaMember(Map<String, Object> map) {
        id = (Integer) map.get("id");
        workcode = (String) map.get("workcode");
        name = (String) map.get("lastname");
        mobile = (String) map.get("mobile");
        email = (String) map.get("email");
        jobcall = (Integer) map.get("jobcall");
        jobtitle = (Integer) map.get("jobtitle");
        subcompanyid1 = (Integer) map.get("subcompanyid1");
        departmentid = (Integer) map.get("departmentid");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OaMember oaMember = (OaMember) o;
        return Objects.equals(id, oaMember.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String phoneNumber() {
        return mobile;
    }

    @Override
    public String appUserLoginId() {
        return workcode;
    }

    @Override
    public String id() {
        return workcode;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String remarkName() {
        return null;
    }

    @Override
    public String dept() {
        return "" + departmentid;
    }

    @Override
    public String station() {
        return "" + jobtitle;
    }

    @Override
    public String email() {
        return email;
    }
}
