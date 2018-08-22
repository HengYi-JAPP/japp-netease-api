package com.hengyi.japp.netease.interfaces.res.resource.netease;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hengyi.japp.netease.interfaces.netease.NIPosition;
import com.hengyi.japp.netease.interfaces.netease.NeteaseService;
import com.netease.edu.util.DataApiCipherUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.stream.Stream;

import static com.github.ixtf.japp.core.Constant.MAPPER;
import static com.hengyi.japp.netease.Constant.*;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Stateless
@Path(NETEASE_API + "/positions")
public class NIPositionResource {
    @Inject
    private NeteaseService neteaseService;

    @POST
    @Consumes(APPLICATION_FORM_URLENCODED)
    @Produces(APPLICATION_JSON)
    public JsonNode list(@Valid @Min(1) @FormParam("pageSize") int pageSize,
                         @Valid @Min(0) @FormParam("currentPage") int currentPage,
                         @Valid @FormParam("nonce") String nonce,
                         @Valid @FormParam("sign") String sign) {
        if (!DataApiCipherUtils.checkReq(sign, nonce, NETEASE_APPKEY, NETEASE_APPSECRET)) {
            throw new NotAuthorizedException(Response.status(Response.Status.UNAUTHORIZED).build());
        }

        ObjectNode res = MAPPER.createObjectNode().put("code", 200);
        try {
            Stream<NIPosition> positions = neteaseService.listPosition(currentPage, pageSize);
            res.set("data", getData(pageSize, positions));
        } catch (Exception e) {
            res.put("code", 500);
        }
        return res;
    }

    private JsonNode getData(int pageSize, Stream<NIPosition> positionStream) throws Exception {
        ObjectNode data = MAPPER.createObjectNode();

        long totalResults = neteaseService.countPosition();
        data.put("totalResults", totalResults);

        long totalPages = totalResults / pageSize;
        if (totalResults % pageSize != 0) {
            totalPages++;
        }
        data.put("totalPages", totalPages);

        ArrayNode result = MAPPER.createArrayNode();
        data.set("result", result);
        positionStream.map(position -> MAPPER.createObjectNode()
                        .put("id", position.id())
//                        .put("parentId", position.getParentId())
                        .put("name", position.name())
        ).forEach(result::add);
        return data;
    }

}
