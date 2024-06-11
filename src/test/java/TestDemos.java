import elo.pra.vo.ApiInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-05-16 23:01
 */
public class TestDemos {
    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        List<ApiInfo> list = sqlSession.selectList("search", "");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
