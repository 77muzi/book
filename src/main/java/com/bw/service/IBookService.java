package com.bw.service;

import com.bw.pojo.Book;

import java.util.List;
import java.util.Map;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 14:13 2017/8/18
 */
public interface IBookService {
    //查询图书信息
    public List<Book> getAllBooks();


    //修改图片路径
    public void updateImgUrl(Book book);
}
