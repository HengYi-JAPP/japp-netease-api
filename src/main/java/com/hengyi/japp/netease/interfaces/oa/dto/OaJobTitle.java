package com.hengyi.japp.netease.interfaces.oa.dto;

import com.hengyi.japp.netease.interfaces.netease.NIPosition;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

@Data
public class OaJobTitle implements NIPosition {
    private final Integer id;
    private final String name;
    private Integer parentId;

    public OaJobTitle(Map<String, Object> map) {
        id = (Integer) map.get("id");
        name = (String) map.get("jobtitlename");
    }

    public String getNIName() {
        int i = name.indexOf("/");
        if (i > -1) {
            return name.substring(0, i);
        }
        i = name.indexOf("、");
        if (i > -1) {
            return name.substring(0, i);
        }
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OaJobTitle that = (OaJobTitle) o;
        return id == that.id;
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
        return null;
    }

    @Override
    public String name() {
        return name;
    }
}
