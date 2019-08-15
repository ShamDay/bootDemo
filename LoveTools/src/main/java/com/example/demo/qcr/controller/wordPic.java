package com.example.demo.qcr.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.baidu.aip.ocr.AipOcr;
import com.example.demo.common.Common;

import sun.misc.BASE64Encoder;

public class wordPic {
    //设置APPID/AK/SK
    public static final String APP_ID = "16726917";
    public static final String API_KEY = "PsTMSzq2LR0hK29A8rQ4ei3k";
    public static final String SECRET_KEY = "wfboKsn89gGK4ilatS7lxmGVfzdShiPK";

    public static void main(String[] args)   {
        // 初始化一个AipOcr
//    	AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
//        String image1 = "‪‪E:\\user.jpg";
//        String image2 = "‪E:\\user.jpg";
//        // image1/image2也可以为url或facetoken, 相应的imageType参数需要与之对应。
//        MatchRequest req1 = new MatchRequest(ImageToBase64(image1), "BASE64");
//        MatchRequest req2 = new MatchRequest(ImageToBase64(image2), "BASE64");
//        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
//        requests.add(req1);
//        requests.add(req2);
//
//        JSONObject res = client.match(requests);
//        System.out.println(res.toString(2));
    	String url="https://aip.baidubce.com/oauth/2.0/token?grant_type="
				+ "client_credentials&client_id=PsTMSzq2LR0hK29A8rQ4ei3k&client_secret"
				+ "=wfboKsn89gGK4ilatS7lxmGVfzdShiPK&";
		JSONObject rs=Common.httpGetInfo(url);
		System.out.println(rs);
        
    }
    /**
     * 本地图片转换Base64的方法
     *
     * @param imgPath     
     * @return 
     */

    private static String ImageToBase64(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
        	File file=new File(imgPath);
        	InputStream in =new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        System.out.println("本地图片转换Base64:" + encoder.encode(Objects.requireNonNull(data)));
        return encoder.toString();
    }
}
