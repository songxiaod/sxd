package com.bw.service;

import java.util.List;
import java.util.Map;

import com.bw.entity.Brand;
import com.bw.entity.Goods;
import com.bw.entity.Kinds;

public interface GoodsService {

	List<Goods> findAllGoods(Map<String,Object> map);

	List<Brand> findBrand();

	List<Kinds> findkinds();

	int addGoods(Goods goods);

	Goods show(Integer id);

	int updateGoods(Goods goods);

	void deletesGoods(String ids);

}
