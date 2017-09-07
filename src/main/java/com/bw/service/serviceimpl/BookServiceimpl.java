package com.bw.service.serviceimpl;

import com.bw.dao.BookMapper;
import com.bw.pojo.Book;
import com.bw.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 14:14 2017/8/18
 */
@Service
@Transactional
public class BookServiceimpl implements IBookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    @Override
    public void updateImgUrl(Book book) {
        bookMapper.updateImgUrl(book);
    }

}
