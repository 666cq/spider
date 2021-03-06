package cn.xj.spider.client;

import cn.xj.spider.model.Xidata;
import cn.xj.spider.utils.HTTPUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class URLHandle {

    public static List<Xidata> urlParser(HttpClient client, String url) throws IOException {

        List<Xidata> data = new ArrayList<Xidata>();

        //获取响应资源
        HttpResponse response = HTTPUtils.getHtml(client,url);

        //获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
       // System.out.println(statusCode);
        if(statusCode == 200) {
            //页面编码
            String entity = EntityUtils.toString(response.getEntity(),"gbk");
           // System.out.println("开始解析...");

            data = xiParse.getData(entity);
           // System.out.println("URL解析完成.");
        } else {
            EntityUtils.consume(response.getEntity());//释放资源实体
        }
        //System.out.println("返回数据.");
        return data;

    }
}
