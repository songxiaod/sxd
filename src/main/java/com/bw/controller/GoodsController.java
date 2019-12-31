package com.bw.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bw.entity.Brand;
import com.bw.entity.Goods;
import com.bw.entity.Kinds;
import com.bw.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class GoodsController {

	@Resource
	private GoodsService goodsService;
	
	@RequestMapping("list")
	public ModelAndView list(@RequestParam(defaultValue="1") Integer pageNum,
			@RequestParam(defaultValue="") String name){
		
		ModelAndView modelAndView = new ModelAndView();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", name);
		
		PageHelper.startPage(pageNum, 2);
		
		List<Goods> list = goodsService.findAllGoods(map);
		
		PageInfo<Goods> page = new PageInfo<Goods>(list);
		
		modelAndView.setViewName("list");
		
		modelAndView.getModelMap().addAttribute("page", page);
		
		return modelAndView;
	}
	
	@RequestMapping("findBrand")
	@ResponseBody
	public List<Brand> findBrand(){
		
		List<Brand> brands = goodsService.findBrand();
		
		return brands;
	} 
	
	@RequestMapping("findkinds")
	@ResponseBody
	public List<Kinds> findkinds(){
		
		List<Kinds> brands = goodsService.findkinds();
		
		return brands;
	} 
	
	@RequestMapping("show")
	@ResponseBody
	public Object show(@RequestParam(defaultValue="") Integer id){
		
		Goods goods = goodsService.show(id);
		
		return goods;
	} 
	
	@RequestMapping("deletesGoods")
	@ResponseBody
	public boolean deletesGoods(@RequestParam(defaultValue="") String ids){
		
		try {
			goodsService.deletesGoods(ids);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
			return false;
		}

	} 
	
	@RequestMapping("addGoods")
	public String addGoods(Goods goods,@RequestParam(value="multipartResolver")MultipartFile file
			,HttpServletRequest request) throws IllegalStateException, IOException{
		
		//获取物理路径
		String path = request.getServletContext().getRealPath("/image/");
		//真实路径
		String filename = file.getOriginalFilename();
		//保存
		file.transferTo(new File(path+filename));
		
		goods.setImage(filename);
		
		int add = goodsService.addGoods(goods);
		
		if(add > 0){
			
			return "redirect:list";
		}else{
			return "redirect:addGoods.jsp";
		}
		
	} 
	
	@RequestMapping("updateGoods")
	public String updateGoods(Goods goods,@RequestParam(value="multipartResolver")MultipartFile file
			,HttpServletRequest request) throws IllegalStateException, IOException{
		
		//获取物理路径
		String path = request.getServletContext().getRealPath("/image/");
		//真实路径
		String filename = file.getOriginalFilename();
		//保存
		file.transferTo(new File(path+filename));
		
		goods.setImage(filename);
		
		int update = goodsService.updateGoods(goods);
		
		if(update > 0){
			
			return "redirect:list";
		}else{
			return "redirect:updateGoods.jsp";
		}
		
	} 
}
