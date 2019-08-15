package com.example.demo.qcr.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.qcr.service.WordServiceNew;

@RestController
public class WordController {
	@Autowired
	private WordServiceNew service;
	
	@RequestMapping(value="/word/baseWordLoad")
	public Map wordLoad(@RequestParam Map map) {
		return service.BaseWordLoad(map);
	}
}
