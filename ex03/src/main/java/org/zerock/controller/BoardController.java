package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

// spring bean 인식
@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
    
    @Autowired
    private BoardService service;
    
//    @GetMapping("list")
//    // 게시물 목록을 전달해야 하므로 Model을 파라미터로 지정하고 전달한다.
//    public void list(Model model) {
//	log.info("list");
//	model.addAttribute("list", service.getList());
//    }
    
    @GetMapping("/list")
    public void list(Criteria cri, Model model) {
        log.info("list: " + cri);
        model.addAttribute("list", service.getList(cri));
        //model.addAttribute("pageMaker", new PageDTO(cri, 123));
        int total = service.getTotal(cri);
        log.info("total: " + total);
        model.addAttribute("pageMaker", new PageDTO(cri, total));
    }

    
    @PostMapping("/register")
    public String register(BoardVO board, RedirectAttributes rttr) {
	
	log.info("register" + board);
	
	service.register(board);
	// 새롭게 등록된 게시물 번호를 목록화면으로 전달해준다
	// 보낸정보를 한번만 사용하기에 도배막기에좋다
	// 모달창을 사용할때 게시물 번호를 가지고있기에 띄울수있다.
	rttr.addFlashAttribute("result", board.getBno());
	// 리턴시 redirect: 사용시 내부적으로 response.sendRedirect()를 처리해준다
	return "redirect:/board/list";
    }
    
    // getmapping,post는 url을 배열로 처리할수있다
    @GetMapping({"/get","/modify"})
    public void get(@RequestParam("bno") Long bno,@ModelAttribute("cri") Criteria cri, Model model)
    {
        log.info("/get or modify");
        model.addAttribute("board", service.get(bno));
    }

    
    @PostMapping("/modify")
    public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
        log.info("modify: " + board);
        if(service.modify(board)) {
            rttr.addFlashAttribute("result", "sucess");
        }
        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount", cri.getAmount());
	rttr.addAttribute("type", cri.getType());	
	rttr.addAttribute("keyword", cri.getKeyword());	
        return "redirect:/board/list";
    }
    
    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
        log.info("remove..." + bno);;
        if(service.remove(bno))
        {
            rttr.addFlashAttribute("result", "success");
        }
        rttr.addAttribute("pageNum", cri.getPageNum());
        rttr.addAttribute("amount", cri.getAmount());
        rttr.addAttribute("type", cri.getType());
	rttr.addAttribute("keyword", cri.getKeyword());
        return "redirect:/board/list";
    }

    
    // 게시물 등록시 입력을 받는 페이지
    @GetMapping("/register")
    public void register() {
	
    }
}
