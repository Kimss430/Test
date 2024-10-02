package com.example.test1.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test1.dao.BoardService;
import com.google.gson.Gson;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	// 게시글 목록
	@RequestMapping("/board/board.do")
	public String boardList(Model model) throws Exception{
		return "/board/board-list";
	}
	// 게시글 작성
	@RequestMapping("/board/board-insert.do") 
    public String boardInsert(Model model) throws Exception{

        return "/board/board-insert";
    }
	// 게시글 상세보기
	@RequestMapping("/board/board-view.do") 
    public String boardView(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception{
		request.setAttribute("boardNo", map.get("boardNo"));
        return "/board/board-view";
    }
	
	
	// 게시글 목록 
	@RequestMapping(value = "/board/board-list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String searchBoard(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = boardService.searchBoardList(map);
		return new Gson().toJson(resultMap);
	}

	// 게시글 작성
	@RequestMapping(value = "/board/board-add.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String board_add(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
			= new HashMap<String, Object>();
		resultMap = boardService.addBoard(map);
		
		return new Gson().toJson(resultMap);
	}
	// 댓글 작성
	@RequestMapping(value = "/board/add-comment.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String Commnets_add(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
			= new HashMap<String, Object>();
		resultMap = boardService.addComment(map);
		
		return new Gson().toJson(resultMap);
	}
	// 게시글 삭제
	@RequestMapping(value = "/board/board-remove.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String board_remove(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
			= new HashMap<String, Object>();
		resultMap = boardService.removeBoard(map);
		
		return new Gson().toJson(resultMap);
	}
	// 댓글 삭제
	@RequestMapping(value = "/board/comment-delete.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String comment_remove(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
		= new HashMap<String, Object>();
		resultMap = boardService.removeComment(map);
		
		return new Gson().toJson(resultMap);
	}
	// 게시글 상세보기
	@RequestMapping(value = "/board/board-view.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String board_view(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
			= new HashMap<String, Object>();
		resultMap = boardService.searchBoardInfo(map);
		
		return new Gson().toJson(resultMap);
	}
	// 게시글 상세보기 삭제
	@RequestMapping(value = "/board/view-delete.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String view_delete(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
		= new HashMap<String, Object>();
		resultMap = boardService.deleteContents(map);
		
		return new Gson().toJson(resultMap);
	}
	// 게시글 수정
	@RequestMapping(value = "/board/view-update.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String view_update(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
		= new HashMap<String, Object>();
		resultMap = boardService.updateContents(map);
		
		return new Gson().toJson(resultMap);
	}
	// 댓글 수정
	@RequestMapping(value = "/board/comment-update.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String comment_update(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap 
		= new HashMap<String, Object>();
		resultMap = boardService.updateComment(map);
		
		return new Gson().toJson(resultMap);
	}
}
