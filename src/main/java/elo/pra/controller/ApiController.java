package elo.pra.controller;


import elo.pra.service.ApiInfoService;
import elo.pra.vo.ApiInfo;
import elo.pra.vo.ApiInfoPK;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-05-13 13:36
 */
@Controller
public class ApiController {
    @Autowired
    ApiInfoService apiInfoService;
    @GetMapping("/apis")
    public String apis(Model model) throws IOException {
        List<ApiInfo> list = apiInfoService.search("", "");
        model.addAttribute("list",list);
        return "apiInfo/index";
    }
}
