package com.sucsoft.sample.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sucsoft.sample.service.BaseService;

@Controller
public abstract class BaseCtrl<T extends Serializable> {
	
	@Autowired
	protected BaseService<T> service;

	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	public List<T> list(){
		return service.queryAll();
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> add(@RequestBody T entity){
		Map<String,String> map = new HashMap<String,String>();
		try{
			String id = service.add(entity);
			map.put("id", id);
		}catch(Exception e){
			
		}
		return map;
	}
	
	@RequestMapping(value="/del/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,String> del(@PathVariable String id){
		Map<String,String> map = new HashMap<String,String>();
		try{
			service.del(id);
		}catch(Exception e){
			
		}
		return map;
	}
}
