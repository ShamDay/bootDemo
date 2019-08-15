package com.example.demo.qcr.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.Common;
import com.example.demo.qcr.mapper.QcrMapper;
import com.example.demo.qcr.service.FaceService;
import com.example.demo.qcr.tools.FaceTools;
import com.example.demo.qcr.tools.ImageCheckTools;
@Service
public class FaceServiceImpl implements FaceService {
	//设置APPID/AK/SK
	private static final Logger logger =LoggerFactory.getLogger(FaceServiceImpl.class);
    private static final String APP_ID = "16726917";
    private static final String API_KEY = "PsTMSzq2LR0hK29A8rQ4ei3k";
    private static final String SECRET_KEY = "wfboKsn89gGK4ilatS7lxmGVfzdShiPK";
    private Common com=new Common();
    private ImageCheckTools ick=new ImageCheckTools();
	@Autowired
	private QcrMapper dao;
	
	private FaceTools tool=new FaceTools();
	private ImageCheckTools itl=new ImageCheckTools();
	@Override
	public Map FaceCom(Map param) {
		// TODO Auto-generated method stub
//		String access_token=dao.getAccessToken();
//		if(access_token!=null&&access_token!=""&&access_token!="null") {
//			
//		}else {
//			String url="https://aip.baidubce.com/oauth/2.0/token?grant_type="
//					+ "client_credentials&client_id=PsTMSzq2LR0hK29A8rQ4ei3k&client_secret"
//					+ "=wfboKsn89gGK4ilatS7lxmGVfzdShiPK&";
//			JSONObject rs=com.httpGetInfo(url);
//			try {
//				access_token=rs.getString("access_token");
//				dao.insertAccessToken(access_token);
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				logger.info("获取Token失败");
//				Map resul=new HashMap();
//				resul.put("resCode", "9999");
//				resul.put("resMsg", "获取Token失败");
//				return resul;
//			}
//		}
//		param.put("access_token", access_token);
		return tool.FaceComPare(param);
	}
	
	@Override
	public Map FaceCheck(Map param) {
		// TODO Auto-generated method stub
//		System.out.println(dao.getAccessToken());
		return tool.FaceCheck(param);
//		return null;
	}

	@Override
	public Map imageCheck(Map map) {
		// TODO Auto-generated method stub
		String idflag=map.get("idflag").toString();
		Map result=new HashMap();
		switch (idflag) {
		case "1":
			result=itl.ImageBaseLoad(map);
			break;
		case "2":
			result=itl.ImageFoodLoad(map);
			break;
		case "3":
			result=itl.ImageCarLoad(map);
			break;
		case "4":
			result=itl.ImageLogoLoad(map);
			break;
		case "5":
			result=itl.ImageAnimalLoad(map);
			break;
		case "6":
			result=itl.ImagePlantLoad(map);
			break;
		default:
			break;
		}
		return result;
	}
}
