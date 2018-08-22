package com.hengyi.japp.netease.interfaces.netease;

import java.util.stream.Stream;

public interface NeteaseService {

    /**
     * @param currentPage 从 1 开始
     * @param pageSize
     * @return
     * @throws Exception
     */
    Stream<NIDepartment> listDepartment(int currentPage, int pageSize) throws Exception;

    long countDepartment() throws Exception;

    long countPosition() throws Exception;

    Stream<NIPosition> listPosition(int currentPage, int pageSize) throws Exception;

    Stream<NIMember> listMember() throws Exception;

    Stream<NIMember> listMember(int currentPage, int pageSize) throws Exception;

    long countMember() throws Exception;
}
