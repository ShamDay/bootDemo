package com.example.demo.qcr.tools;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import com.baidu.aip.ocr.AipOcr;

public class Tools {
    //设置APPID/AK/SK
    private static final String APP_ID = "15093065";
    private static final String API_KEY = "sXpCpcynO4vyBnI2RYyikC0T";
    private static final String SECRET_KEY = "USHfY674TOGuRlj9HIbFx1xNX81Ns6hX";
    private HexUtils hex=new HexUtils();
    //初始化AipOcr
    private AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
	/**
	 * 通用文字识别工具
	 * @return
	 */
	public Map BaseWordLoad(Map map) {
		// 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("language_type", "CHN_ENG");
	    options.put("detect_direction", "true");
	    options.put("detect_language", "true");
	    options.put("probability", "true");
	    // 参数为本地图片二进制数组
	    byte[] file = hex.decode(map.get("image").toString());
	    JSONObject res = client.basicGeneral(file, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 通用文字识别（高精度版）
	 * 用户向服务请求识别某张图中的所有文字，相对于通用文字识别该产品精度更高，但是识别耗时会稍长。
	 */
	public Map WordAccurate(Map map) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("detect_direction", "true");
	    options.put("probability", "true");
	    // 参数为本地图片二进制数组
	    byte[] file = hex.decode(map.get("image").toString());
	    JSONObject res = client.basicAccurateGeneral(file, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 通用文字识别（含位置信息版）
	 * 用户向服务请求识别某张图中的所有文字，并返回文字在图中的位置信息。
	 */
	public Map WordGeneral(Map map) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("recognize_granularity", "big");
	    options.put("language_type", "CHN_ENG");
	    options.put("detect_direction", "true");
	    options.put("detect_language", "true");
	    options.put("vertexes_location", "true");
	    options.put("probability", "true");
    	// 参数为本地图片二进制数组
	    byte[] file = hex.decode(map.get("image").toString());
	    JSONObject res = client.general(file, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 通用文字识别（含位置高精度版）
	 * 用户向服务请求识别某张图中的所有文字，并返回文字在图片中的坐标信息，相对于通用文字识别（含位置信息版）该产品精度更高，但是识别耗时会稍长。
	 */
	public Map WordAccurateGeneral(Map map) {
		// 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("recognize_granularity", "big");
	    options.put("detect_direction", "true");
	    options.put("vertexes_location", "true");
	    options.put("probability", "true");
    	// 参数为本地图片二进制数组
	    byte[] file = hex.decode(map.get("image").toString());
	    JSONObject res = client.accurateGeneral(file, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 通用文字识别（含生僻字版）
	 * 某些场景中，图片中的中文不光有常用字，还包含了生僻字，这时用户需要对该图进行文字识别，应使用通用文字识别（含生僻字版）。
	 */
	public Map WordEnhanced(Map map) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("language_type", "CHN_ENG");
	    options.put("detect_direction", "true");
	    options.put("detect_language", "true");
	    options.put("probability", "true");
    	// 参数为本地图片二进制数组
	    byte[] file = hex.decode(map.get("image").toString());
	    JSONObject res = client.enhancedGeneral(file, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 网络图片文字识别
	 * 用户向服务请求识别一些网络上背景复杂，特殊字体的文字。
	 */
	public Map WordWebImage(Map map) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("detect_direction", "true");
	    options.put("detect_language", "true");
    	// 参数为本地图片二进制数组
	    byte[] file = hex.decode(map.get("image").toString());
	    JSONObject res = client.webImage(file, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 身份证识别
	 * 用户向服务请求识别身份证，身份证识别包括正面和背面。
	 */
	public Map WordIdcard(Map map) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("detect_direction", "true");
	    options.put("detect_risk", "false");
	    //front - 身份证含照片的一面back - 身份证带国徽的一面
	    String idCardSide = map.get("idCardSide ").toString();
    	// 参数为本地图片二进制数组
	    byte[] file = hex.decode(map.get("image").toString());
	    JSONObject res =  client.idcard(file, idCardSide, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 银行卡识别
	 * 识别银行卡并返回卡号和发卡行。
	 */
	public Map WordBankCard(Map map) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
    	// 参数为本地图片二进制数组
	    byte[] file = hex.decode(map.get("image").toString());
	    JSONObject res =  client.bankcard(file, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 驾驶证识别
	 * 对机动车驾驶证所有关键字段进行识别
	 */
	public Map WordDrivingLicense(Map map) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("detect_direction", "true");
    	// 参数为本地图片二进制数组
	    byte[] file = hex.decode(map.get("image").toString());
	    JSONObject res =  client.drivingLicense(file, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 行驶证识别
	 * 对机动车行驶证正本所有关键字段进行识别
	 */
	public Map WordVehicleLicense(Map map) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("detect_direction", "true");
	    options.put("accuracy", "normal");
    	// 参数为本地图片二进制数组
	    byte[] file = hex.decode(map.get("image").toString());
	    JSONObject res =  client.vehicleLicense(file, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 车牌识别
	 * 识别机动车车牌，并返回签发地和号牌。
	 */
	public Map WordPlateLicense(Map map) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("multi_detect", "true");
    	// 参数为本地图片二进制数组
	    byte[] file = hex.decode(map.get("image").toString());
	    JSONObject res =  client.plateLicense(file, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 营业执照识别
	 * 识别营业执照，并返回关键字段的值，包括单位名称、法人、地址、有效期、证件编号、社会信用代码等。
	 */
	public Map WordBusinessLicense(Map map) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
    	// 参数为本地图片二进制数组
	    byte[] file = hex.decode(map.get("image").toString());
	    JSONObject res =  client.businessLicense(file, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 通用票据识别
	 * 用户向服务请求识别医疗票据、发票、的士票、保险保单等票据类图片中的所有文字，并返回文字在图中的位置信息。
	 */
	public Map WordReceipt(Map map) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("recognize_granularity", "big");
	    options.put("probability", "true");
	    options.put("accuracy", "normal");
	    options.put("detect_direction", "true");
    	// 参数为本地图片二进制数组
	    byte[] file = hex.decode(map.get("image").toString());
	    JSONObject res =  client.receipt(file, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 自定义模版文字识别   暂时不用
	 * 自定义模版文字识别，是针对百度官方没有推出相应的模版，但是当用户需要对某一类卡证/票据（如房产证、军官证、火车票等）进行结构化的提取内容时，可以使用该产品快速制作模版，进行识别。
	 */
	public Map WordCustom(Map map) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    //模板标识
	    String templateSign = "";
    	// 参数为本地图片二进制数组
	    byte[] file = hex.decode(map.get("image").toString());
	    JSONObject res =  client.custom(file, templateSign, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "1111");
		return result;
	}
	/**
	 * 表格文字识别同步接口
	 * 自动识别表格线及表格内容，结构化输出表头、表尾及每个单元格的文字内容。
	 */
	public Map WordForm(Map map) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
    	// 参数为本地图片二进制数组
	    byte[] file = hex.decode(map.get("image").toString());
	    JSONObject res =  client.form(file, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 表格文字识别
	 * 自动识别表格线及表格内容，结构化输出表头、表尾及每个单元格的文字内容。表格文字识别接口为异步接口，分为两个API：提交请求接口、获取结果接口。
	 */
	public Map WordTableRecognitionAsync(Map map) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
    	// 参数为本地图片二进制数组
	    byte[] file = hex.decode(map.get("image").toString());
	    JSONObject res =  client.tableRecognitionAsync(file, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
	/**
	 * 表格识别结果
	 * 获取表格文字识别结果
	 */
	public Map WordTableResultGet(Map map) {
	    // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    String requestId = map.get("requestId").toString();
	    // 参数为本地图片二进制数组
	    byte[] file = hex.decode(map.get("image").toString());
	    JSONObject res =  client.tableResultGet(requestId, options);
	    Map result=new HashMap();
	    result.put("result", res.toString());
	    result.put("resCode", "0000");
		return result;
	}
}
