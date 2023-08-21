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
////  ȭ�鿡 data�� �����ϰ�ʹٸ� model�� �־�����Ѵ�.
//// model�� ��°� �ٸ������� �߻��� data�� ������� ���
//    public String getTest1(Model model) {
//	String name = "dong";
//	System.out.println(model);
//	model.addAttribute("name",name);
//	return "test";
//    }
//    
//    @GetMapping("/test1")
//    // ��ü����
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
	dto2.setName("�赿��");
	dto2.setAge(29);
	return dto2;
    }
    
    @GetMapping("/exUpload")
    public void exUpload() {
	System.out.println("���ε� �Ϸ�");
	
    }
    
    @PostMapping("exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {
	files.forEach(file -> {
	    System.out.println(file.getOriginalFilename());
	    System.out.println(file.getSize());
	}); 
    }
}
