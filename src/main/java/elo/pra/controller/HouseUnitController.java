package elo.pra.controller;

import elo.pra.constants.SaleStatusEnum;
import elo.pra.constants.TypeEnum;
import elo.pra.service.HouseUnitService;
import elo.pra.utils.FileUtils;
import elo.pra.vo.HouseUnit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-06-11 20:36
 */
@Controller
@RequestMapping("/admin/houses")
public class HouseUnitController {
    @Autowired
    public HouseUnitService houseUnitService;
    @Value("${app.url.houseBeaura_GZ.prefix}")
    private String prefix;
    //    @Value("${app.url.houseBeaura_GZ.cname}")
//    private String cname;
    @Value("${app.url.houseBeaura_GZ.suffix}")
    private String suffix;

    @RequestMapping(value = "/{presaleCertId}/{date}", method = RequestMethod.PUT)
    @ResponseBody
    public List houses(@PathVariable("presaleCertId") String presaleCertId, @PathVariable("date") String date) throws IOException {
        HouseUnit currentHouseUnit = new HouseUnit();
        String qualifiedName = prefix + presaleCertId + "_" + date + suffix;
        System.out.println("qualifiedName = " + qualifiedName);
        String line;
        StringBuilder sb = new StringBuilder();
        File testFile = new File(qualifiedName);
        if (!testFile.exists()) {
            System.out.println(testFile.getName() + " does NOT exist !!!");
            throw new FileNotFoundException(testFile.getName() + " is not found");
        }
        // 使用try-resource方式
        sb = FileUtils.extracted(testFile, sb);
        ArrayList<HouseUnit> huList = new ArrayList<>();
        Document doc = Jsoup.parse(sb.toString(), "UTF-8");

        // 选择所有 class 为 "floor" 的 td 元素
        Elements floorTds = doc.select("td.box_tab_style02_td");
        ArrayList<TypeEnum> typeList = new ArrayList<TypeEnum>();
        // 遍历 td 元素
        for (int i = 0; i < floorTds.size(); i++) {

            Element floorTd = floorTds.get(i);
            // 仅处理序号为偶数且包含子 table 的 td 元素
            if (i % 2 == 1 && floorTd.select("table").size() > 0) {
                Element floorEle = floorTd.siblingElements().get(0).attr("width", "10%");
                // 获取 td 元素的子 table
                Element table = floorTd.selectFirst("table");
                // 获取子 table 中的所有 td 元素
                Elements innerTds = table.select("td");
                StringBuilder record = new StringBuilder();
                // 遍历子 table 的 td 元素，对所有 td 进行数据封装
                for (Element innerTd : innerTds) {
                    currentHouseUnit = new HouseUnit();
                    typeList = new ArrayList<TypeEnum>();
                    currentHouseUnit.setFloor(floorEle.text().replace("层", ""));
                    String floorAndStatus = innerTd.text();
                    currentHouseUnit.setPresalePermitNumber(presaleCertId);
                    String[] s = floorAndStatus.split(" ");
                    // 情况1: 506 ◆■； 2: 505 （即后面没有类型图案）
                    if (s.length > 2 || s.length < 1) {
                        throw new IllegalArgumentException("房屋信息有误, 方块里除了房号和类型码还有其他内容");
                    }
                    if (s.length == 1) { //情况2: 该if判断是后者，查封&抵押都：否
                        currentHouseUnit.setSaleStatusEnum(SaleStatusEnum.PRE_SALE);
                        currentHouseUnit.setRoomNumber(s[0]);
                        currentHouseUnit.setSealed(false);
                        currentHouseUnit.setMortgaged(false);
                    } else if (s.length == 2) { //
                        currentHouseUnit.setRoomNumber(s[0]);//设置房号
                        for (int j = 0; j < s[1].length(); j++) {
                            TypeEnum typeEnum = TypeEnum.traverseMatch(String.valueOf(s[1].charAt(j)));
                            typeList.add(typeEnum);
                        }
                        currentHouseUnit.setTypes(typeList);
                    }

                    SaleStatusEnum colorEnumElement = SaleStatusEnum.traverseMatch(innerTd.attr("bgcolor"));
                    currentHouseUnit.setSaleStatusEnum(colorEnumElement);
                    String attr = innerTd.getElementsByTag("a").attr("title");
                    attr = attr.replace("详细信息请点击房号显示", "");
                    attr = attr.replace("户型", ",户型").replace("套内面积", ",套内面积").replace("总面积", ",总面积").replace("当前状态", ",当前状态").replace("查封", ",查封").replace("抵押", ",抵押");
                    String[] split = attr.split(",");
                    for (int j = 0; j < split.length; j++) {
                        String[] split1 = split[j].split("：");
                        if ("类型".equalsIgnoreCase(split1[0])) {
                            currentHouseUnit.setCategory(split1[1]);
                        } else if ("户型".equalsIgnoreCase(split1[0])) {
                            currentHouseUnit.setDesign(split1[1]);
                        } else if ("套内面积".equalsIgnoreCase(split1[0])) {
                            currentHouseUnit.setInteriorSize(Double.parseDouble(split1[1].replace("平方米", "")));
                        } else if ("总面积".equalsIgnoreCase(split1[0])) {
                            currentHouseUnit.setFullConstructSize(Double.parseDouble(split1[1].replace("平方米", "")));
                        } else if ("当前状态".equalsIgnoreCase(split1[0])) {
                            //currentHouseUnit.setStatus(split1[1]);
                        } else if ("查封".equalsIgnoreCase(split1[0])) {
                            currentHouseUnit.setSealed("是".equalsIgnoreCase(split1[1]) ? true : false);
                        } else if ("抵押".equalsIgnoreCase(split1[0])) {
                            currentHouseUnit.setMortgaged("是".equalsIgnoreCase(split1[1]) ? true : false);
                        }
                    }
                    huList.add(currentHouseUnit);
                }
            }
        }
        houseUnitService.insertBatch(huList);
        return huList;
    }

    @RequestMapping(value = "/{presaleCertId}/{date}", method = RequestMethod.GET)
    public String index(Model model
            , @RequestParam(defaultValue = "1") int pageNum
            , @RequestParam(defaultValue = "50") int pageSize
            , String key
            , @PathVariable("presaleCertId") String presaleCertId) {
        List<HouseUnit> list = houseUnitService.getAll(presaleCertId);
        System.out.println("list = " + list);
        model.addAttribute("presaleCertId", presaleCertId);
        model.addAttribute("key", key);
        model.addAttribute("list", list);
        return "/house/index";
    }
    @RequestMapping(value = "/{presaleCertId}/{date}/list", method = RequestMethod.GET)
    @ResponseBody
    public List<HouseUnit> list(@PathVariable("presaleCertId") String presaleCertId) {
        List<HouseUnit> list = houseUnitService.getAll(presaleCertId);
        return list;
    }
}
