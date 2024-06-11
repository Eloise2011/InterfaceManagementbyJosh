package elo.pra.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-06-11 15:09
 */
//@MapperScan(basePackages = { "elo.pra.dao" }, annotationClass = Repository.class)
//@Configuration
public class MybatisConfiguration {

    /**
     * 权限数据源
     *
     * @return
     */
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {

        DruidDataSource dataSource = (DruidDataSource) DataSourceBuilder.create().type(DruidDataSource.class).build();

        if (null == dataSource.getProxyFilters()) {
            dataSource.setProxyFilters(new ArrayList<Filter>());
        }

        List<Filter> filters = dataSource.getProxyFilters();

        Slf4jLogFilter loggerFilter = new Slf4jLogFilter();
        loggerFilter.setResultSetLogEnabled(false);
        loggerFilter.setStatementExecutableSqlLogEnable(true);

        filters.add(loggerFilter);

        return dataSource;

    }

    /**
     * 权限数据源session
     *
     * @return
     * @throws Exception
     */
    @Primary
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //sessionFactory.setMapperLocations(resolver.getResources("classpath:mappers/**/*.xml"));
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //configuration.getTypeHandlerRegistry().register(TypeEnumListTypeHandler.class);
        configuration.getTypeHandlerRegistry().register(SaleStatusEnumListSaleStatusHandler.class);
        return sessionFactory.getObject();
    }

}