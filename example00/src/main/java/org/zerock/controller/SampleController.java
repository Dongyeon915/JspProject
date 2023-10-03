package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
    
    @RequestMapping("")
    public void basic() {
	log.info("basic................");
    }
    
    @GetMapping("/basicOnlyGet")
    public void basicGet2() {
	log.info("basic get only");
    }
    
    @GetMapping("/ex01")
    // 타입과 관계없이 무조건 Model에 담겨서 전달되므로 화면에서 사용할수있다.
    // String 타입은 상황에 따라 다른 화면을 보여줄 필요가 있을 겨우에 유용하다. String타입은 현재 프로젝트이 jsp파일이름을 의미한다.
    public String ex01(SampleDTO sampleDTO,@ModelAttribute("page") int page) {
	log.info(sampleDTO);
	log.info(page);
	return "/sample/ex01";
    }
    
    @GetMapping("/ex02")
    public void ex02() {
	log.info("리턴 타입이 void일 경우 해당 url경로 그대로인 jsp파일을 호출한다.");
    }
    
    @GetMapping("ex03")
    public @ResponseBody SampleDTO ex03() {
	log.info("json 타입을 받을때 @Responsebody");
	SampleDTO dto = new SampleDTO();
	dto.setAge(10);
	dto.setName("김동연");
	return dto;
    }
    
    @GetMapping("/exUpload")
    public void exUpload() {
	log.info("/exUpload..........");
    }
    
    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {
	
	files.forEach(file -> {
	    log.info("--------------------------------");
	    log.info(file.getOriginalFilename());
	});
    }
}
