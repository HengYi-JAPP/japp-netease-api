import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.github.ixtf.japp.core.Constant.MAPPER;

/**
 * 描述：
 *
 * @author jzb 2017-11-11
 */
public class JsonTest {
    static String companies = "[{\"id\":34,\"subcompanyname\":\"香港天逸\",\"supsubcomid\":35},{\"id\":36,\"subcompanyname\":\"恒逸实业\",\"supsubcomid\":35},{\"id\":68,\"subcompanyname\":\"石化销售\",\"supsubcomid\":35},{\"id\":59,\"subcompanyname\":\"逸博投资\",\"supsubcomid\":5}]";
    static String departments = "[{\"id\":321,\"subcompanyid1\":49,\"supdepid\":0,\"departmentname\":\"综合部\",\"fullPathName\":\"恒逸锦纶/综合部\"},{\"id\":65,\"subcompanyid1\":31,\"supdepid\":371,\"departmentname\":\"综合办公室\",\"fullPathName\":\"恒逸化纤/化纤综合部\"},{\"id\":130,\"subcompanyid1\":35,\"supdepid\":0,\"departmentname\":\"营销中心\",\"fullPathName\":\"恒逸石化/营销中心\"},{\"id\":196,\"subcompanyid1\":35,\"supdepid\":0,\"departmentname\":\"财务管理部\",\"fullPathName\":\"恒逸石化/财务管理部\"},{\"id\":5,\"subcompanyid1\":35,\"supdepid\":0,\"departmentname\":\"信息管理部\",\"fullPathName\":\"恒逸石化/信息管理部\"},{\"id\":6,\"subcompanyid1\":35,\"supdepid\":0,\"departmentname\":\"办公室\",\"fullPathName\":\"恒逸石化/办公室\"},{\"id\":8,\"subcompanyid1\":5,\"supdepid\":0,\"departmentname\":\"财务部\",\"fullPathName\":\"恒逸集团/财务部\"},{\"id\":9,\"subcompanyid1\":35,\"supdepid\":0,\"departmentname\":\"审计稽核部\",\"fullPathName\":\"恒逸石化/审计稽核部\"},{\"id\":203,\"subcompanyid1\":35,\"supdepid\":0,\"departmentname\":\"董事会办公室\",\"fullPathName\":\"恒逸石化/董事会办公室\"},{\"id\":461,\"subcompanyid1\":66,\"supdepid\":0,\"departmentname\":\"综合部\",\"fullPathName\":\"太仓逸枫/综合部\"},{\"id\":398,\"subcompanyid1\":5,\"supdepid\":0,\"departmentname\":\"战略投资部\",\"fullPathName\":\"恒逸集团/战略投资部\"},{\"id\":462,\"subcompanyid1\":66,\"supdepid\":0,\"departmentname\":\"财务部\",\"fullPathName\":\"太仓逸枫/财务部\"},{\"id\":14,\"subcompanyid1\":35,\"supdepid\":0,\"departmentname\":\"人力资源部\",\"fullPathName\":\"恒逸石化/人力资源部\"},{\"id\":399,\"subcompanyid1\":59,\"supdepid\":0,\"departmentname\":\"业务部\",\"fullPathName\":\"逸博投资/业务部\"},{\"id\":402,\"subcompanyid1\":60,\"supdepid\":0,\"departmentname\":\"聚合部\",\"fullPathName\":\"嘉兴逸鹏/聚合部\"},{\"id\":149,\"subcompanyid1\":35,\"supdepid\":0,\"departmentname\":\"研发中心\",\"fullPathName\":\"恒逸石化/研发中心\"},{\"id\":406,\"subcompanyid1\":60,\"supdepid\":0,\"departmentname\":\"财务部\",\"fullPathName\":\"嘉兴逸鹏/财务部\"},{\"id\":281,\"subcompanyid1\":41,\"supdepid\":0,\"departmentname\":\"采购管理部/Procurement Dept.\",\"fullPathName\":\"恒逸文莱/采购管理部/Procurement Dept.\"},{\"id\":219,\"subcompanyid1\":33,\"supdepid\":0,\"departmentname\":\"物流财务部\",\"fullPathName\":\"恒逸物流/物流财务部\"},{\"id\":222,\"subcompanyid1\":33,\"supdepid\":0,\"departmentname\":\"综合部\",\"fullPathName\":\"恒逸物流/综合部\"},{\"id\":482,\"subcompanyid1\":58,\"supdepid\":0,\"departmentname\":\"财务部\",\"fullPathName\":\"香港逸天/财务部\"},{\"id\":226,\"subcompanyid1\":35,\"supdepid\":0,\"departmentname\":\"总裁\",\"fullPathName\":\"恒逸石化/总裁\"},{\"id\":483,\"subcompanyid1\":5,\"supdepid\":0,\"departmentname\":\"总裁\",\"fullPathName\":\"恒逸集团/总裁\"},{\"id\":484,\"subcompanyid1\":35,\"supdepid\":0,\"departmentname\":\"综合管理中心\",\"fullPathName\":\"恒逸石化/综合管理中心\"},{\"id\":421,\"subcompanyid1\":61,\"supdepid\":0,\"departmentname\":\"综合部\",\"fullPathName\":\"杭州逸暻/综合部\"},{\"id\":229,\"subcompanyid1\":35,\"supdepid\":0,\"departmentname\":\"投资管理部\",\"fullPathName\":\"恒逸石化/投资管理部\"},{\"id\":172,\"subcompanyid1\":35,\"supdepid\":0,\"departmentname\":\"工程与采购中心\",\"fullPathName\":\"恒逸石化/工程与采购中心\"},{\"id\":434,\"subcompanyid1\":61,\"supdepid\":0,\"departmentname\":\"财务部\",\"fullPathName\":\"杭州逸暻/财务部\"},{\"id\":50,\"subcompanyid1\":7,\"supdepid\":0,\"departmentname\":\"综合部\",\"fullPathName\":\"恒逸聚合/综合部\"},{\"id\":375,\"subcompanyid1\":35,\"supdepid\":0,\"departmentname\":\"总裁办\",\"fullPathName\":\"恒逸石化/总裁办\"},{\"id\":122,\"subcompanyid1\":19,\"supdepid\":0,\"departmentname\":\"综合部\",\"fullPathName\":\"恒逸上海/综合部\"},{\"id\":314,\"subcompanyid1\":35,\"supdepid\":0,\"departmentname\":\"党群工作部\",\"fullPathName\":\"恒逸石化/党群工作部\"},{\"id\":123,\"subcompanyid1\":19,\"supdepid\":0,\"departmentname\":\"财务部\",\"fullPathName\":\"恒逸上海/财务部\"},{\"id\":190,\"subcompanyid1\":24,\"supdepid\":0,\"departmentname\":\"行政人事部-临江综合管理中心\",\"fullPathName\":\"己内酰胺/行政人事部-临江综合管理中心\"},{\"id\":319,\"subcompanyid1\":49,\"supdepid\":0,\"departmentname\":\"锦纶财务部\",\"fullPathName\":\"恒逸锦纶/锦纶财务部\"}]";

    public static void main(String[] args) throws Exception {
        ArrayNode nodes = (ArrayNode) MAPPER.readTree(companies);
        Set<Integer> set = StreamSupport.stream(nodes.spliterator(), false)
                .map(node -> node.get("id").asInt())
                .collect(Collectors.toSet());
        System.out.println(set);

        nodes = (ArrayNode) MAPPER.readTree(departments);
        set = StreamSupport.stream(nodes.spliterator(), false)
                .map(node -> node.get("id").asInt())
                .collect(Collectors.toSet());
        System.out.println(set);
    }
}
