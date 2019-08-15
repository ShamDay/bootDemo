package com.example.demo.qcr.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.qcr.service.FaceService;

@RestController
public class FaceController {
	@Autowired
	private FaceService service;
	
	@RequestMapping(value="/face/faceCom")
	public Map faceCom(@RequestParam Map map) {
		return service.FaceCom(map);
	}
	@RequestMapping(value="/face/faceCheck")
	public Map faceCheck(@RequestParam Map map) {
		return service.FaceCheck(map);
	}
	@RequestMapping(value="/image/imageCheck")
	public Map imageCheck(@RequestParam Map map) {
		return service.imageCheck(map);
	}
	
}
