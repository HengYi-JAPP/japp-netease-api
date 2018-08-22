package com.hengyi.japp.netease.interfaces.res.resource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.ixtf.japp.core.J;
import com.github.ixtf.japp.poi.Jpoi;
import org.apache.commons.collections4.MapUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

import static com.github.ixtf.japp.core.Constant.MAPPER;
import static com.hengyi.japp.netease.Constant.BLACK_SET_PATH;
import static com.hengyi.japp.netease.Constant.WHITE_SET_PATH;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.MULTIPART_FORM_DATA;

/**
 * 描述：
 *
 * @author jzb 2017-11-10
 */
@Path("uploads")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class UploadResource {
    @Path("whiteSet")
    @POST
    @Consumes(MULTIPART_FORM_DATA)
    public JsonNode whiteSet(@Context SecurityContext sc, MultipartFormDataInput mfdi) throws Exception {
        save(WHITE_SET_PATH, mfdi);
        return whiteSet(sc);
    }

    private void save(String path, MultipartFormDataInput mfdi) throws IOException {
        Map<String, List<InputPart>> uploadForm = mfdi.getFormDataMap();
        if (MapUtils.isEmpty(uploadForm)) {
            throw new RuntimeException();
        }
        List<InputPart> inputParts = uploadForm.get("file");
        if (J.isEmpty(inputParts)) {
            throw new RuntimeException();
        }
        try (InputStream is = inputParts.get(0).getBody(InputStream.class, null);
             Workbook wb = new XSSFWorkbook(is);
             FileOutputStream fos = new FileOutputStream(path)) {
            wb.write(fos);
        }
    }

    @Path("whiteSet")
    @GET
    public JsonNode whiteSet(@Context SecurityContext sc) throws Exception {
        return get(WHITE_SET_PATH);
    }

    private JsonNode get(String path) throws IOException {
        final ArrayNode result = MAPPER.createArrayNode();
        try (Workbook wb = new XSSFWorkbook(path)) {
            IntStream.range(0, wb.getNumberOfSheets())
                    .mapToObj(wb::getSheetAt)
                    .map(this::toNode)
                    .forEach(result::add);
        }
        return result;
    }

    private JsonNode toNode(Sheet sheet) {
        final ObjectNode result = MAPPER.createObjectNode()
                .put("sheetName", sheet.getSheetName());
        final ArrayNode rowsNode = MAPPER.createArrayNode();
        result.set("rows", rowsNode);
        StreamSupport.stream(sheet.spliterator(), false)
                .map(row -> {
                    Cell cell = row.getCell(0);
                    final String hrId = Jpoi.stringValue(cell);
                    if (J.isBlank(hrId)) {
                        return null;
                    }
                    final ObjectNode node = MAPPER.createObjectNode();
                    node.put("hrId", hrId);
                    cell = row.getCell(1);
                    final String name = Jpoi.stringValue(cell);
                    node.put("name", name);
                    return node;
                })
                .filter(Objects::nonNull)
                .forEach(rowsNode::add);
        return result;
    }

    @Path("blackSet")
    @POST
    @Consumes(MULTIPART_FORM_DATA)
    public JsonNode blackSet(@Context SecurityContext sc, MultipartFormDataInput mfdi) throws Exception {
        save(BLACK_SET_PATH, mfdi);
        return blackSet(sc);
    }

    @Path("blackSet")
    @GET
    @Consumes(MULTIPART_FORM_DATA)
    public JsonNode blackSet(@Context SecurityContext sc) throws Exception {
        return get(BLACK_SET_PATH);
    }
}
