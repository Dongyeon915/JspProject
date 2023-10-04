package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;


import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
    // rest 방식
//    // produces 해당 메서드가 생산하는 MIME 타입
//    @GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
//    public String getText() {
//	log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
//	return "안녕";
//    }
//
//    // produces 속성이 반드시 필요한건 아니다
//    @GetMapping(value = "/getSample", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
//	    MediaType.APPLICATION_XML_VALUE })
//    public SampleVO getSample() {
//	return new SampleVO(123, "김", "동연");
//    }
//    
//    // 키에 속하는 데이터는 xml로 변환되는 경우에 태그의 이름이 되므로 string으로 지정해야한다.
//    @GetMapping(value = "/getMap")
//    public Map<String, SampleVO> getMap() {
//	
//	Map<String, SampleVO> map = new HashMap<String, SampleVO>();
//	map.put("first", new SampleVO(111,"동","연"));
//	return map;
//    }
//    
//    // 데이터와 함께 http 헤더의 상태 메시지 등을 같이 전달하는 용도로 사용한다.
//    @GetMapping(value = "/check", params = {"height","weight"})
//    public ResponseEntity<SampleVO> check(Double height, Double weight) {
//	SampleVO vo = new SampleVO(0, "" + height, "" + weight);
//	ResponseEntity<SampleVO> result = null;
//	
//	if (height > 150) {
//	    result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
//	} else {
//	    result = ResponseEntity.status(HttpStatus.OK).body(vo);
//	}
//	return result;
//    }
//    
//    // url에서 {}로 처리된 부분은 컨트롤러의 메서드에서 변수로 처리가 가능하다.
//    // 기본 자료형은 사용할수없다.
//    @GetMapping("/product/{cat}/{pid}")
//    public String[] getPath(@PathVariable("cat") String cat, @PathVariable Integer pid) {
//	return new String[] {"category" + cat, "productid:" + pid};
//    }
//    
//    @PostMapping("/ticket")
//    public Ticket convert(@RequestBody Ticket ticket) {
//	log.info("convert......ticket" + ticket);
//	return ticket;
//    }
    
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
