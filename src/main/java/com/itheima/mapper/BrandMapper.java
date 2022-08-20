package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
        //查询所有
        @Select("select * from tb_brand;")
        @ResultMap("brandResultMap")
        List <Brand>selectAll();
        //添加语句
        /**
         * 添加数据
         * @param brand
         */
        @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
        void add(Brand brand);

        /**
         * 批量删除
         * @param ids
         */
        void deleteByIds(@Param("ids") int[] ids);

        /**
         * 分页查询
         *
         * @param begin
         * @param size
         * @return
         */
        @Select("select * from tb_brand limit #{begin},#{size}")
        @ResultMap("brandResultMap")
        List<Brand> selectByPage(@Param("begin") int begin,@Param("size")int size);
        /**
         * 总记录数
         */
        @Select("select count(*) from tb_brand ")
        int selectTotalCount();

}
