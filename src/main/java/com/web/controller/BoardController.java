package com.web.controller;

import com.web.domain.Board;
import com.web.domain.User;
import com.web.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4000/")
@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

//    @GetMapping({"","/"})
//    public String board(@RequestParam(value="idx", defaultValue = "0") Long idx, Model model){
//        model.addAttribute("board", boardService.findBoardByIdx(idx));
//        return "/board/form";
//    }

    @GetMapping("/list")
    public Page<Board> list(Pageable pageable, @RequestParam int pageNum){
        System.out.println("pageNum = " + pageNum);
        return boardService.findBoardList(pageable, pageNum);
    }

    @PostMapping("/example")
    @ResponseBody
    public void test(@RequestBody User user){
        System.out.println("User == " + user.getName());
    }

    @PostMapping("/write")
    @ResponseBody
    public void write(@RequestBody Board board){
        System.out.println("boardType == " + board.getBoardType());
        System.out.println("title == " + board.getTitle());
        System.out.println("content == " + board.getContent());
    }
}
