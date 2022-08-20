package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface brandService {
    //查询所有对象
    List<Brand> selectAll();
    //添加
    void add(Brand brand);
    //批量删除
    void deleteByIds(int[] ids);

    PageBean<Brand> selectByPage(int currentPage, int pageSize);


}
