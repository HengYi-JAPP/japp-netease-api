package com.hengyi.japp.netease.interfaces.res.resource;

import com.hengyi.japp.netease.interfaces.netease.NIMember;
import com.hengyi.japp.netease.interfaces.netease.NeteaseService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import java.util.Collection;
import java.util.stream.Collectors;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * 描述：
 *
 * @author jzb 2017-11-10
 */
@Path("test")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class TestResource {
    @Inject
    private NeteaseService neteaseService;

    @Path("members")
    @GET
    public Collection<NIMember> members(@Context SecurityContext sc) throws Exception {
        return neteaseService.listMember().collect(Collectors.toList());
    }
}
