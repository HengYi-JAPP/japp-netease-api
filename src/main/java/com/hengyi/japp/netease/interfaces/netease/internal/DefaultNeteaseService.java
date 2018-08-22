package com.hengyi.japp.netease.interfaces.netease.internal;

import com.github.ixtf.japp.core.J;
import com.hengyi.japp.netease.application.ConfigService;
import com.hengyi.japp.netease.interfaces.netease.NIDepartment;
import com.hengyi.japp.netease.interfaces.netease.NIMember;
import com.hengyi.japp.netease.interfaces.netease.NIPosition;
import com.hengyi.japp.netease.interfaces.netease.NeteaseService;
import com.hengyi.japp.netease.interfaces.oa.OaService;
import com.hengyi.japp.netease.interfaces.oa.dto.OaCompany;
import com.hengyi.japp.netease.interfaces.oa.dto.OaDepartment;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Stateless
public class DefaultNeteaseService implements NeteaseService {
    @Inject
    private OaService oaService;
    @Inject
    private ConfigService configService;

    @Override
    public long countDepartment() throws Exception {
        return listDepartment().count();
    }

    private Stream<NIDepartment> listDepartment() {
        Stream<? extends NIDepartment> stream1 = oaService.listCompany();
        Stream<? extends NIDepartment> stream2 = oaService.listDepartment();
        return Stream.concat(stream1, stream2);
    }

    @Override
    public Stream<NIDepartment> listDepartment(int currentPage, int pageSize) throws Exception {
        int skip = (currentPage - 1) * pageSize;
        return listDepartment().skip(skip).limit(pageSize);
    }

    @Override
    public long countPosition() throws Exception {
        return oaService.listJobTitle().count();
    }

    @Override
    public Stream<NIPosition> listPosition(int currentPage, int pageSize) throws Exception {
        int skip = (currentPage - 1) * pageSize;
        return oaService.listJobTitle().skip(skip).limit(pageSize).map(Function.identity());
    }

    @Override
    public long countMember() throws Exception {
        return listMember().count();
    }

    @Override
    public Stream<NIMember> listMember() throws Exception {
        final Set<String> whiteSet = configService.listWhiteSet().collect(Collectors.toSet());
        final Set<String> blackSet = configService.listBlackSet().collect(Collectors.toSet());
        final Set<Integer> comps = configService.listCompany()
                .map(OaCompany::getId)
                .collect(Collectors.toSet());
        final Set<Integer> deps = configService.listDepartment()
                .flatMap(this::querySelfAndAllSub)
                .map(OaDepartment::getId)
                .collect(Collectors.toSet());
        return oaService.listMember()
                .filter(member -> {
                    final String id = member.id();
                    Boolean b = J.isBlank(id);
                    if (b) {
                        return false;
                    }
                    b = blackSet.contains(id);
                    if (b) {
                        return false;
                    }
                    b = whiteSet.contains(id);
                    if (b) {
                        return true;
                    }
                    b = comps.contains(member.getSubcompanyid1());
                    if (b) {
                        return true;
                    }
                    return deps.contains(member.getDepartmentid());
                }).map(Function.identity());
    }

    private Stream<OaDepartment> querySelfAndAllSub(OaDepartment dep) {
        Stream<OaDepartment> result = Stream.of(dep);
        final Stream<OaDepartment> subStream = oaService.listDepartmentBySupdepId(dep.getId())
                .flatMap(this::querySelfAndAllSub);
        return Stream.concat(result, subStream);
    }

    @Override
    public Stream<NIMember> listMember(int currentPage, int pageSize) throws Exception {
        int skip = (currentPage - 1) * pageSize;
        return listMember().skip(skip).limit(pageSize);
    }
}
