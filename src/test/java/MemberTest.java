import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.github.ixtf.japp.core.Constant.MAPPER;

/**
 * 描述：
 *
 * @author jzb 2017-11-09
 */
public class MemberTest {
    public static final OkHttpClient OK_CLIENT = new OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.HOURS)
            .writeTimeout(1, TimeUnit.HOURS)
            .readTimeout(1, TimeUnit.HOURS)
            .build();
    public static MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");

    public static void main(String[] args) throws IOException {
        final RequestBody body = RequestBody.create(mediaType, "pageSize=1000&currentPage=1&nonce=nonce&sign=sign");
        Request request = new Request.Builder()
                .url("http://localhost:8080/netease/api/neteaseInterfaces/members")
                .post(body)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache")
                .build();
        final JsonNode res = MAPPER.readTree(OK_CLIENT.newCall(request).execute().body().byteStream());
        final ArrayNode array = (ArrayNode) res.get("data").get("result");
        Workbook wb = new XSSFWorkbook();
        final Sheet sheet = wb.createSheet("人员列表");
        for (int i = 0; i < array.size(); i++) {
            final JsonNode node = array.get(i);
            final Row row = sheet.createRow(i);
            String value = node.get("id").asText();
            Cell cell = row.createCell(0);
            cell.setCellValue(value);
            value = node.get("name").asText();
            cell = row.createCell(1);
            cell.setCellValue(value);
        }
        FileOutputStream fos = new FileOutputStream("/home/jzb/桌面/hr.xlsx");
        wb.write(fos);
    }
}
