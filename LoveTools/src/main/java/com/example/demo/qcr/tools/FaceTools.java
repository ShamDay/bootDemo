package com.example.demo.qcr.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.example.demo.common.Common;
import com.example.demo.common.GsonUtil;
import com.example.demo.common.GsonUtils;
import com.example.demo.common.HttpUtil;

public class FaceTools {
	//设置APPID/AK/SK
    private static final String APP_ID = "16726917";
    private static final String API_KEY = "PsTMSzq2LR0hK29A8rQ4ei3k";
    private static final String SECRET_KEY = "wfboKsn89gGK4ilatS7lxmGVfzdShiPK";
	private AipFace air = new AipFace(APP_ID, API_KEY, SECRET_KEY);
    /**
	 * 人脸对比
	 */
//	public Map FaceComPare(Map map) {
//		Map result=new HashMap();
//		String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
//        try {
//        	System.out.println(map.get("image_left").toString().substring(0, 100));
//            String image1 = (String) map.get("image_left");
//            String image2 = (String) map.get("image_right");
//            List<Map<String, Object>> images = new ArrayList<>();
//            Map<String, Object> map1 = new HashMap<>();
//            map1.put("image", image1);
//            map1.put("image_type", "BASE64");
//            map1.put("face_type", "LIVE");
//            map1.put("quality_control", "LOW");
//            map1.put("liveness_control", "NORMAL");
//            Map<String, Object> map2 = new HashMap<>();
//            map2.put("image", image2);
//            map2.put("image_type", "BASE64");
//            map2.put("face_type", "LIVE");
//            map2.put("quality_control", "LOW");
//            map2.put("liveness_control", "NORMAL");
//            images.add(map1);
//            images.add(map2);
//            String param = GsonUtils.toJson(images);
//            String res = HttpUtil.post(url, map.get("access_token").toString(), "application/json", param);
//            JSONObject jsonObject =new JSONObject(res);
//    	    result.put("result", jsonObject.toString());
//    	    result.put("resCode", "0000");
//            return result;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        result.put("resMsg", "对比失败");
//	    result.put("resCode", "9999");
//        return result;
//	}
	public Map FaceComPare(Map map) {
	    // 传入可选参数调用接口
	    String file_left = String.valueOf(map.get("image_left"));
	    String file_right = String.valueOf(map.get("image_right"));
	    MatchRequest req1 = new MatchRequest(file_left, "BASE64");
	    MatchRequest req2 = new MatchRequest(file_right, "BASE64");
	    ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
	    requests.add(req1);
	    requests.add(req2);
	    JSONObject res =  air.match(requests);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 人脸检测
	 */
	public Map FaceCheck(Map map) {
		// 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("face_field", "age,beauty,expression,face_shape,gender,glasses,race,eye_status,emotion,face_type");
	    options.put("max_face_num", "1");
	    options.put("face_type", "LIVE");
	    options.put("liveness_control", "LOW");
	    String imageType = "BASE64";
	    // 人脸检测
	    JSONObject res = air.detect(map.get("image").toString(), imageType, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
}
