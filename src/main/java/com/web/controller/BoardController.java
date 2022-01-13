package com.web.controller;

import com.web.domain.Board;
import com.web.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping({"","/"})
    public String board(@RequestParam(value="idx", defaultValue = "0") Long idx, Model model){
        model.addAttribute("board", boardService.findBoardByIdx(idx));
        return "/board/form";
    }

    @GetMapping("/list")
    public Page<Board> list(@PageableDefault Pageable pageable, Model model){
       return boardService.findBoardList(pageable);
    }
}
