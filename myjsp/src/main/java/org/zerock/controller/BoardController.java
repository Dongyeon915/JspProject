package org.zerock.controller;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
@Log4j
public class BoardController {

    // @Autowired
    private final BoardService service;

    // url이 존재하고 return타입이 void라면 동일한 주소의 jsp를 찾는다.
//    @GetMapping("/list")
//    // model에 db정보를 가져와야한다
//    public void list(Model model) {
//	log.info("모든 정보 가져오기 list");
//	model.addAttribute("list", service.getList());
//    }
    
    
    
    @GetMapping("/list")
    // model에 db정보를 가져와야한다
    public void list(Criteria criteria,Model model) {
	log.info("모든 정보 가져오기 list");
	model.addAttribute("list", service.getList(criteria));
	model.addAttribute("pageMaker", new PageDTO(criteria,123));
    }
    
    // 화면의 입력을 보여줘야하므로 GET registe.jsp
    @GetMapping("/register")
    public void registerGET() {
	// 리턴이 없으므로 register.jsp를 띄움
    }

    @PostMapping("/register")
    // redirect를 위한 String
    public String register(BoardVO boardVO,RedirectAttributes rttr) {
	log.info("추가 로그 확인" + boardVO);
	
	service.register(boardVO);
	System.out.println(boardVO.getBno());
	log.error(boardVO.getBno());
	
	// 아주 잠깐 결과가 보이는 FlashAttribute
	rttr.addFlashAttribute("result",boardVO.getBno());
	
	return "redirect:/board/list";
    }
    
    // 두개의 링크를 처리
    // 수정시 http://localhost:8080/board/modify?bno=4
    @GetMapping({"/get","/modify"})
    // void로 해줘야 가능
    public void get(@RequestParam("bno")int bno,Model model) {
	model.addAttribute("board",service.get(bno));
    }
    
    
    
    
    @PostMapping("/modify")
    public String modify(BoardVO boardVO,RedirectAttributes rttr) {
	//servic의 리턴 int값
	int count = service.modify(boardVO);
	
	// 성공적일때
	if (count == 1) {
	    rttr.addFlashAttribute("result","success");
	}
	return "redirect:/board/list";
    }
    
    // delete로 할시 오류 주소 mapping문제인듯
    @GetMapping("/remove")
    public String remove(@RequestParam("bno")int bno,RedirectAttributes rttr) {
	//servic의 리턴 int값
	int count = service.remove(bno);
	// 성공적일때
	if (count == 1) {
	    rttr.addFlashAttribute("result","success");
	}
	return "redirect:/board/list";
    }

}
