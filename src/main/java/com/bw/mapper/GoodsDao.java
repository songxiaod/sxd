package com.bw.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bw.entity.Brand;
import com.bw.entity.Goods;
import com.bw.entity.Kinds;

public interface GoodsDao {

	List<Goods> findAllGoods(Map<String,Object> map);

	List<Brand> findBrand();

	List<Kinds> findkinds();

	int addGoods(Goods goods);

	Goods show(@Param("id") Integer id);

	int updateGoods(Goods goods);

	void deletesGoods(@Param("ids") String ids);
}
