package cn.xj.spider.client;

import cn.xj.spider.mapper.XidataMapper;
import cn.xj.spider.model.Xidata;

import cn.xj.spider.utils.SessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class xiParse {

    public static List<Xidata> getData(String entity){


        SqlSession sqlSession = SessionUtils.getSqlSession();
        XidataMapper xidataMapper = sqlSession.getMapper(XidataMapper.class);

        ArrayList<Xidata> data = new ArrayList<>();
        Document doc = Jsoup.parse(entity);
        final Elements table = doc.select("table");
        if(!"".equals(table.toString())){
            /*System.out.println(doc.body().text().toString());
            System.out.println(doc.select("div").toString()+"--------");
            */
            Elements trs = table.get(4).select("tr");
            for(int i = 0;i<trs.size();i++){
                Elements tds = trs.get(i).select("td");
                Xidata xidata = new Xidata();
                ArrayList<String> arr = new ArrayList<>();

                for(int j = 0;j<tds.size();j++){

                    String text = tds.get(j).text();
                    arr.add(text);
                    //System.out.println(text);
                }

                if (!"".equals(arr.get(0)) && !"".equals(arr.get(1))&& !"".equals(arr.get(2))){
                    xidata.setTime(arr.get(0));
                    xidata.setValue(arr.get(1));
                    xidata.setState(arr.get(2));
                    xidata.setEquipmentId(1);
                    xidataMapper.insert(xidata);


                    data.add(xidata);
                }

            }
            sqlSession.commit();


        }


        return data;

    }

}
