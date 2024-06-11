package elo.pra.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-06-11 20:46
 */
@Configuration
public class PageHelperConfiguration {
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
        properties.setProperty("pageSizeZero","true"); //当设置为true的时候，如果pagesize设置为0（或RowBounds的limit=0），就不执行分页，返回全部结果
        properties.setProperty("supportMethodsArguments","true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
