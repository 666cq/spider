package cn.xj.spider;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class SpiderStarter {

    public static void main(String[] args) {

        //System.out.println("正在生成客户端...");
        HttpClient client = null;
        //System.out.println("客户端生成完毕.");
       // System.out.println("正在生成客户端...");
        client = HttpClientBuilder.create().build();
        //System.out.println("客户端生成完毕.");

        //http://localhost:8083/data/index.php?year=2010&month=03&mday=04&tagname=dtag000899
        String month = "";
        String mday = "";
        String year = "";
        for(int y =2010; y<=2019; y++){
            for (int m=1; m<=12; m++){
                for (int d=1; d<=31; d++){
                    if(m<10){
                        month = "0" + m;
                    }else {
                        month = "" + m;
                    }
                    if(d<10){
                        mday = "0" + d;
                    }else {
                        mday = "" + d;
                    }
                    year = y + "";
                    String url = "http://127.0.0.1:8083/data/index.php?tagname=dtag000899&year="+year+"&month="+month+"&mday="+mday;
                   // String url = "http://127.0.0.1:8083/data/index.php?tagname=dtag000899&year=2010&month=02&mday=29";
                    //System.out.println(url);
                    //System.out.println("正在爬取"+ year + "-" + month + "-" + mday + "的数据");
                    XjSpider.start(url, client);

                }
            }
        }

    }

}
