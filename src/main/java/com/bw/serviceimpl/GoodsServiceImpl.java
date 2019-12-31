package com.bw.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.entity.Brand;
import com.bw.entity.Goods;
import com.bw.entity.Kinds;
import com.bw.mapper.GoodsDao;
import com.bw.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Resource
	private GoodsDao goodsDao;
	
	public List<Goods> findAllGoods(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return goodsDao.findAllGoods(map);
	}

	public List<Brand> findBrand() {
		// TODO Auto-generated method stub
		return goodsDao.findBrand();
	}

	public List<Kinds> findkinds() {
		// TODO Auto-generated method stub
		return goodsDao.findkinds();
	}

	public int addGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.addGoods(goods);
	}

	public Goods show(Integer id) {
		// TODO Auto-generated method stub
		return goodsDao.show(id);
	}

	public int updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.updateGoods(goods);
	}

	public void deletesGoods(String ids) {
		// TODO Auto-generated method stub
		goodsDao.deletesGoods(ids);
	}

}
