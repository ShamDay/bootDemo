package com.example.demo.qcr.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.qcr.service.WordServiceNew;
import com.example.demo.qcr.tools.Tools;
@Service
public class WordServiceImpl implements WordServiceNew{
	
	private Tools tool=new Tools();
	@Override
	public Map BaseWordLoad(Map map) {
		// TODO Auto-generated method stub
		String idflag=map.get("idflag").toString();
		Map result=new HashMap();
		switch (idflag) {
		case "1":
			result=tool.BaseWordLoad(map);
			break;
		case "2":
			result=tool.WordAccurate(map);
			break;
		case "3":
			result=tool.WordGeneral(map);
			break;
		case "4":
			result=tool.WordAccurateGeneral(map);
			break;
		case "5":
			result=tool.WordEnhanced(map);
			break;
		case "6":
			result=tool.WordWebImage(map);
			break;
		case "7":
			result=tool.WordTableRecognitionAsync(map);
			break;
		case "8":
			result=tool.WordIdcard(map);
			break;
		case "9":
			result=tool.WordDrivingLicense(map);
			break;
		case "10":
			result=tool.WordVehicleLicense(map);
			break;
		case "11":
			result=tool.WordBusinessLicense(map);
			break;
		case "12":
			result=tool.WordBankCard(map);
			break;
		case "13":
			result=tool.WordPlateLicense(map);
			break;
		case "14":
			result=tool.WordBusinessLicense(map);
			break;
		case "15":
			result=tool.WordReceipt(map);
			break;
		default:
			break;
		}
		return result;
	}
}
