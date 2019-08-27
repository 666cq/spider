package cn.xj.spider.utils;

import cn.xj.spider.mapper.XidataMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SessionUtils {

    public static SqlSessionFactory getSqlSessionFactory(){
        /**
         * 读取mybatis配置文件
         */
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * 得到连接对象注册sqlsession
         */
       return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession getSqlSession(){
        return getSqlSessionFactory().openSession();
    }

}
