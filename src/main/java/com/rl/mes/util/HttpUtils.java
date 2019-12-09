package com.rl.mes.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;


/**
 * 网络访问工具
 */
public class HttpUtils {


    /**
     * post请求
     *
     * @param url  请求地址
     * @param json 请求参数
     * @return
     */
    public static String post(String url, JSONObject json) {
        return HttpUtils.post(url, json, null);
    }

    /**
     * 服务器发送Post请求
     *
     * @param url          访问地址
     * @param json         请求参数
     * @param headParamMap 放在头部信息的参数
     * @return 返回值
     */
    public static String post(String url, JSONObject json, Map<String, String> headParamMap) {
        HttpClient client = HttpClientBuilder.create().build();
        url = url.replaceAll(" ", "%20");
        HttpPost post = new HttpPost(url);
        JSONObject jsonObject = new JSONObject();
        post.setHeader("Content-Type", "application/json");
        if (headParamMap != null) {
            for (String key : headParamMap.keySet()) {
                post.setHeader(key, headParamMap.get(key));
            }
        }
        try {
            StringEntity s = new StringEntity(json.toString(), "utf-8");
            s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            post.setEntity(s);
            HttpResponse httpResponse = client.execute(post);
            InputStream inStream = httpResponse.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "utf-8"));
            StringBuilder result = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                result.append(line);
                System.out.println(line);
            }
            inStream.close();
            if (httpResponse.getStatusLine().getStatusCode() == 404) {
                jsonObject.put("state", "-1");
                jsonObject.put("msg", "404错误，访问地址未找到");
            }
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                jsonObject.put("state", "1");
                jsonObject.put("msg", result);
            }
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED) {
                jsonObject.put("state", "1");
                jsonObject.put("msg", result);
            }
        } catch (Exception ex) {
            jsonObject.put("state", "-1");
            jsonObject.put("msg", ex.getMessage());
        }
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }


    /**
     * get请求
     *
     * @param url 访问地址
     * @return 返回值
     */
    public static String get(String url) {
        JSONObject jsonObject = null;
        HttpGet httpRequest = new HttpGet(url);
        try {
            /*发送请求并等待响应*/
            HttpResponse httpResponse = HttpClientBuilder.create().build().execute(httpRequest);
            if (httpResponse.getStatusLine().getStatusCode() == 404) {
                jsonObject.put("state", "-1");
                jsonObject.put("msg", "404错误，访问地址未找到");
            }
            /*若状态码为200 ok*/
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                /*读*/
                String strResult = EntityUtils.toString(httpResponse.getEntity());
                return strResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }


    public static void main(String[] args) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        String url = "http://192.168.47.168:8940/api/pick/injectionCollectData/list";
        HttpPost post = new HttpPost(url);
        //head参数
        post.setHeader("Content-Type", "application/json");
        post.setHeader("x-request-datasource", "001");
        //Body参数
        JSONObject json = new JSONObject();
        json.put("barcodeArr", new String[]{"B12015"});
        StringEntity s = new StringEntity(json.toString(), "utf-8");
        post.setEntity(s);
        //发起请求
        HttpResponse httpResponse = client.execute(post);
        InputStream inStream = httpResponse.getEntity().getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "utf-8"));
        StringBuilder result = new StringBuilder();
        String line = null;
        //获取信息并逐行打印
        System.out.println("==============以下是返回结果==================");
        while ((line = reader.readLine()) != null) {
            result.append(line);
            //打印信息
            System.out.println(line);
            //返回数据转换成json对象
            JSONObject resultObj =  JSON.parseObject(line);
        }
        inStream.close();
    }

}
