package com.naver.dong;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.naver.dong.domain.SampleDTO;

@Controller
@RequestMapping("/test")
public class TestController {
    
//    @GetMapping("/ex01")
////  화면에 data를 전달하고싶다면 model에 넣어줘야한다.
//// model에 담는건 다른곳에서 발생한 data를 담기위한 용기
//    public String getTest1(Model model) {
//	String name = "dong";
//	System.out.println(model);
//	model.addAttribute("name",name);
//	return "test";
//    }
//    
//    @GetMapping("/test1")
//    // 객체맵핑
//    public String getTest(SampleDTO dto) {
//	System.out.println(dto);
//	return "test1";
//    }
//    
//    @GetMapping("/test03")
//    public void ex02(SampleDTO dto,@ModelAttribute("page") int page) {
//	System.out.println(page);
//	System.out.println(dto);
//    }
    
    @GetMapping("/ex06")
    public @ResponseBody SampleDTO ex06() {
	SampleDTO dto2 = new SampleDTO();
	dto2.setName("김동연");
	dto2.setAge(29);
	return dto2;
    }
    
    @GetMapping("/exUpload")
    public void exUpload() {
	System.out.println("업로드 완료");
	
    }
    
    @PostMapping("exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {
	files.forEach(file -> {
	    System.out.println(file.getOriginalFilename());
	    System.out.println(file.getSize());
	}); 
    }
}
