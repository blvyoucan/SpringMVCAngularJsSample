package com.sucsoft.sample.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sucsoft.sample.entity.Book;
import com.sucsoft.sample.entity.Bookself;
import com.sucsoft.sample.service.BookselfService;

@Controller
@RequestMapping("/book")
public class BookCtrl extends BaseCtrl<Book>{
	
	@Resource
	private BookselfService bservice;
	
	@RequestMapping(value="/toList",method=RequestMethod.GET)
	public ModelAndView toList(){
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("test","哈哈1");
		mav.setViewName("list");
		
		return mav;
	}
	
	@RequestMapping(value="/addToSelf",method=RequestMethod.POST)
	@ResponseBody
	@Transactional
	public Map<String,String> addToSelf(@RequestParam(required=true) String sid,@RequestBody Book book){
		Map<String,String> map = new HashMap<String,String>();
		
		try{
			Bookself bs = bservice.query(sid);
			
			if( bs != null ){
				
				book.setBookself(bs);
				
				service.add(book);
				
				map.put("status", "success");
			}
			
		}catch(Exception e){
			
		}
		
		return map;
	}
}
