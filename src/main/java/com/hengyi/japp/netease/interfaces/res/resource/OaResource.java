package com.hengyi.japp.netease.interfaces.res.resource;

import com.hengyi.japp.netease.interfaces.oa.OaService;
import com.hengyi.japp.netease.interfaces.oa.dto.OaCompany;
import com.hengyi.japp.netease.interfaces.oa.dto.OaDepartment;

import javax.inject.Inject;
import javax.ws.rs.*;
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
@Path("oas")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class OaResource {
    @Inject
    private OaService oaService;

    @Path("companies")
    @GET
    public Collection<OaCompany> companies(@Context SecurityContext sc) throws Exception {
        return oaService.listCompany().collect(Collectors.toList());
    }

    @Path("departments")
    @GET
    public Collection<OaDepartment> departments(@Context SecurityContext sc, @QueryParam("q") String q) throws Exception {
        return oaService.queryDepartment(q).collect(Collectors.toList());
    }
}
