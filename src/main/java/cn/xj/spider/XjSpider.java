package cn.xj.spider;

import cn.xj.spider.client.URLHandle;
import cn.xj.spider.model.Xidata;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;

public class XjSpider {

    public static void start(String url, HttpClient client){

        //String url = "http://127.0.0.1:8083/data/index.php?tagname=dtag000899";
        List<Xidata> jobsList = null;

        //开始解析
        try {
            //System.out.println("开始响应客户端...");
            try {
                Thread.sleep(200);
                //将客户端和url传过去先获取url解析接着来获取数据
                jobsList = URLHandle.urlParser(client, url);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("响应完成.");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("开始输出结果...");
        /*for (Xidata data:jobsList) {
           // System.out.println(data.toString());

        }*/

    }



  /*
    public static void main(String[] args) {

        System.out.println("正在生成客户端...");
        HttpClient client = null;
        System.out.println("客户端生成完毕.");



        String url = "http://127.0.0.1:8083/data/index.php?tagname=dtag000899";

        System.out.println(url);

        List<Xidata> jobsList = null;

        System.out.println("正在生成客户端...");
        client = HttpClientBuilder.create().build();
        System.out.println("客户端生成完毕.");


        //开始解析
        try {
            System.out.println("开始响应客户端...");
            try {
                Thread.sleep(200);
                //将客户端和url传过去先获取url解析接着来获取数据
                jobsList = URLHandle.urlParser(client, url);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("响应完成.");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("开始输出结果...");
        for (Xidata data:jobsList) {
            System.out.println(data.toString());

        }

    }
*/
}
