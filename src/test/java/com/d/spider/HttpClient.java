package com.d.spider;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.*;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by regex
 *
 * @author xh.d
 * @since 2018/2/28 17:07
 */
public class HttpClient {

    public String doPost(String url, Map<String,String> map, String charset){
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try{
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            httpPost.setHeader("Content-type", "application/json;charset=utf-8");
            //设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String,String> elem = (Map.Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
            }
            if(list.size() > 0){
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        HttpClient client = new HttpClient();
        String url = "http://admin.tingwen.me/index.php/api/interfaceXykj/touList";
        Map<String, String> map = new HashMap<String, String>(0);
        map.put("page","4");
        String result = client.doPost(url, map, "gbk");
        System.out.println(result);
        System.out.println(UnicodeToString(result));
    }

    public static String UnicodeToString(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            if (hex[i].endsWith("!")){
                hex[i] = hex[i].replace("!", "");
            }
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }
        return string.toString();
    }
}
