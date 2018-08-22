package com.hengyi.japp.netease.interfaces.res.resource;

import com.hengyi.japp.netease.application.ConfigService;
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
@Path("configs")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class ConfigResource {
    @Inject
    private OaService oaService;
    @Inject
    private ConfigService configService;

    @Path("companies")
    @GET
    public Collection<OaCompany> companies(@Context SecurityContext sc) throws Exception {
        return configService.listCompany().collect(Collectors.toList());
    }

    @Path("companies/{id}")
    @PUT
    public void addCompany(@Context SecurityContext sc, @PathParam("id") int id) throws Exception {
        configService.addCompany(id);
    }

    @Path("companies/{id}")
    @DELETE
    public void deleteCompany(@Context SecurityContext sc, @PathParam("id") int id) throws Exception {
        configService.removeCompany(id);
    }

    @Path("departments")
    @GET
    public Collection<OaDepartment> departments(@Context SecurityContext sc) throws Exception {
        return configService.listDepartment().collect(Collectors.toList());
    }

    @Path("departments/{id}")
    @PUT
    public void addDepartment(@Context SecurityContext sc, @PathParam("id") int id) throws Exception {
        configService.addDepartment(id);
    }

    @Path("departments/{id}")
    @DELETE
    public void deleteDepartment(@Context SecurityContext sc, @PathParam("id") int id) throws Exception {
        configService.removeDepartment(id);
    }
}
