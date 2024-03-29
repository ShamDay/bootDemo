package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages="com.example.demo.qcr.mapper")
public class LoveToolsApplication  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(LoveToolsApplication.class, args);
	}

}
