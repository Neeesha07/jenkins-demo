package com.controller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.AppService;

@Controller
@RequestMapping("/blog")
public class PageController {

	@Autowired
	private AppService appService;
	@GetMapping("comment")
	public String commentPage() {
		return "comment";
	}
	@ResponseBody
	@PostMapping("comment")
	public void commentAdded(@RequestParam("blogId")int blogId,@RequestParam("comment")String comment) {
	appService.addComment(blogId,comment);
	
}
//	@KafkaListener(topics = "comment", groupId = "abc")
//	public String kafkaListener(String data) {
//		String data1=data;
//		System.out.println(data1);
//		return "commentAdded";
//	}

}
