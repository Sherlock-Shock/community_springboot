package com.lee.community.serviceimpl;

import com.alibaba.excel.util.DateUtils;
import com.lee.community.service.CrawlerService;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CrawlerServiceImpl implements CrawlerService {



    @Override
    public void csdnBlog() {
        for (int i = 0; i < 10; i++) {
            Map m = new HashMap();
            m.put(1,1);
        }
//            List<String> urlList = new ArrayList<>();
//
//            for (int i = 1; i < 10; i++) {
//                urlList.add("https://www.zhipin.com/c101280100/?query=Java&page="+i);
//            }
//
//            urlList.forEach((i)->{
//                System.out.println(i.toString());
//            });

            String Url = "https://comment.bilibili.com/181080562.xml";
            String cid = "https://api.bilibili.com/x/web-interface/view?bvid=BV17Z4y1K7SS";
            String danMuUrl = "https://comment.bilibili.com/181080562.xml";
            String FILE_PATH = "d:/pachongtupian";

                Document document = null;
                try {
                    document = Jsoup.connect(cid)
                            .timeout(10000)
                            .ignoreContentType(true)
                            .ignoreHttpErrors(true)
                            .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
//                            .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
//                            .header("Accept-Encoding", "gzip, deflate, br")
//                            .header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                            .get();
                    System.out.println(document.toString());
                    downDanMuXml(FILE_PATH,document.toString());
                    Elements links = document.select("d");

//                    System.out.println("开始下载....");
                    for (Element e:links
                    ) {
                        System.out.println(e.text());
                        //downImg(FILE_PATH,e.attr("abs:src"));
                    }
//                    System.out.println("下载结束....");

                } catch (IOException e) {
                    e.printStackTrace();
                }


}

    private void downDanMuXml(String FILE_PATH, String document){
        File dir = new File(FILE_PATH);
        if (!dir.exists()){
            dir.mkdirs();
        }
        String fileName = String.valueOf(System.currentTimeMillis()+".xml");
        File file = new File(FILE_PATH+File.separator+fileName);
        try {
            FileWriter fileWriter = new FileWriter(file,true);
            fileWriter.write(document);
            fileWriter.flush();
            fileWriter.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private String getCidFromBv(String url){
        Document document = null;
        try {
            document = Jsoup.connect(url)
                        .timeout(10000)
                        .ignoreContentType(true)
                        .ignoreHttpErrors(true)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
                        .get();
            Elements cids = document.select("body");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void downImg(String FILE_PATH, String imgUrl){
        File dir = new File(FILE_PATH);
        if (!dir.exists()){
            dir.mkdirs();
        }
        String fileName = String.valueOf(System.currentTimeMillis()+".jpg");
        File file = new File(FILE_PATH+File.separator+fileName);
        try {
            URL url = new URL(imgUrl);
            URLConnection urlConnection = url.openConnection();
            InputStream in =urlConnection.getInputStream();
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
            byte[] buf =new byte[1024];
            int size;
            while(-1 != (size = in.read(buf))){
                out.write(buf,0,size);
            }
            in.close();
            out.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
