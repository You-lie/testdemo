package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.impl.BrandServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class brandServlet extends baseServlet {
    private com.itheima.service.brandService brandService=new BrandServiceImpl();
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //调用service
        List<Brand> brands = brandService.selectAll();
        //转为json
        String json = JSON.toJSONString(brands);
        //写数据
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(json);
    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取品牌数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        //转为brand对象
        Brand brand = JSON.parseObject(s, Brand.class);
        //添加数据
        brandService.add(brand);
        //响应
        response.getWriter().write("success");
    }

    /**
     * 批量删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取品牌数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        //转为brand对象
        int[] ints = JSON.parseObject(s, int[].class);
        //添加数据
        brandService.deleteByIds(ints);
        //响应
        response.getWriter().write("success");
    }
    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收 当前页码 和 每页展示条数    url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //2. 调用service查询
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);

        //2. 转为JSON
        String jsonString = JSON.toJSONString(pageBean);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

}
