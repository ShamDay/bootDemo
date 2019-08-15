package com.example.demo.qcr.tools;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.imageclassify.AipImageClassify;

import sun.misc.BASE64Decoder;

public class ImageCheckTools {
	//设置APPID/AK/SK
    private static final String APP_ID = "15185363";
    private static final String API_KEY = "bxp9OsbNtuaxZGxrkzakLiYt";
    private static final String SECRET_KEY = "Vh53ITaZxE8GGTa11btQU3v9SjcMz1eb";
	private AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
	/**
	 * 通用识别
	 * @throws IOException 
	 */
	public Map ImageBaseLoad(Map map) {
		// 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("baike_num", "5");
		//base64转为二进制
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] b = null;
		try {
			b = decoder.decodeBuffer(map.get("image").toString());
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject res = client.advancedGeneral(b, options);
		Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 菜品识别
	 * @throws IOException 
	 */
	public Map ImageFoodLoad(Map map) {
		// 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("top_num", "3");
	    options.put("filter_threshold", "0.7");
	    options.put("baike_num", "5");
		//base64转为二进制
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] b = null;
		try {
			b = decoder.decodeBuffer(map.get("image").toString());
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject res =  client.dishDetect(b, options);
		Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 车型识别
	 * @throws IOException 
	 */
	public Map ImageCarLoad(Map map) {
		// 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("top_num", "3");
	    options.put("baike_num", "5");
		//base64转为二进制
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] file = null;
		try {
			file = decoder.decodeBuffer(map.get("image").toString());
			for (int i = 0; i < file.length; ++i) {
				if (file[i] < 0) {
					file[i] += 256;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject res =  client.carDetect(file, options);
		Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * logo商标识别
	 * @throws IOException 
	 */
	public Map ImageLogoLoad(Map map) {
		// 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("custom_lib", "false");
		//base64转为二进制
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] file = null;
		try {
			file = decoder.decodeBuffer(map.get("image").toString());
			for (int i = 0; i < file.length; ++i) {
				if (file[i] < 0) {
					file[i] += 256;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject res =  client.logoSearch(file, options);
		Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 动物识别
	 * @throws IOException 
	 */
	public Map ImageAnimalLoad(Map map) {
		// 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("top_num", "3");
	    options.put("baike_num", "5");
		//base64转为二进制
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] file = null;
		try {
			file = decoder.decodeBuffer(map.get("image").toString());
			for (int i = 0; i < file.length; ++i) {
				if (file[i] < 0) {
					file[i] += 256;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject res =  client.animalDetect(file, options);
		Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 植物识别
	 * @throws IOException 
	 */
	public Map ImagePlantLoad(Map map) {
		// 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("baike_num", "5");
		//base64转为二进制
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] file = null;
		try {
			file = decoder.decodeBuffer(map.get("image").toString());
			for (int i = 0; i < file.length; ++i) {
				if (file[i] < 0) {
					file[i] += 256;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block2
			e.printStackTrace();
		}
		JSONObject res =  client.plantDetect(file, options);
		Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
}
