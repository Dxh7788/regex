package com.d.spider;

import com.d.spider.entity.Loan;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by regex
 * 海投汇数据抓取器
 * @author xh.d
 * @since 2018/2/28 15:35
 */
public class HtouhuiCratcher {

    public static void main(String[] args) {
        HtouhuiCratcher cratcher = new HtouhuiCratcher();
        Map<String, String> map = new HashMap<String, String>();
        map.put("size", "4");
        map.put("charset", "utf-8");
        //获取网页数据
        String url = "https://www.htouhui.com/web-api/iloans";
        String value = new String();
        String html = cratcher.parserHtouhui(url, map);
        System.out.println(html);
        //定位包含待挖掘的数据块
//        List<String> datas = cratcher.dinerHtouhui(html);
//        for (String data:datas){
//            System.out.println(data);
//        }
//        //解析数据块并返回初步的挖掘数据
//        List<Loan> loans = cratcher.wrapperHtouhui(datas);
    }

    private String parserHtouhui(String url, Map<String, String> map) {
        CloseableHttpClient clients = HttpClients.createDefault();
        //超时时间不设置
        try {
            HttpPost post = new HttpPost(url);
            //构造消息头
            post.setHeader("Content-type", "application/json; charset=utf-8");
            post.setHeader("Connection", "keep-alive");
            // 构建消息实体
            // 发送Json格式的数据请求
            //装填参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            if(map!=null){
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
            }
            post.setEntity(new UrlEncodedFormEntity(nvps, "utf-9"));

            CloseableHttpResponse response = clients.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK){
                System.out.println("error");
            }else {
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line = "";
                while ((line =reader.readLine())!=null){
                    System.out.println(line);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                clients.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    private List<String> dinerHtouhui(String content) {
        String regex = "(?<=<div class=\"selectPeriodicalList project-float fl\")[\\W]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        int step = 0;

        List<String> values = new ArrayList<String>(0);
        while (matcher.find()){
            values.add(matcher.group(0));
        }
        return values;
    }

    private List<Loan> wrapperHtouhui(List<String> datas) {
        return null;
    }
}
