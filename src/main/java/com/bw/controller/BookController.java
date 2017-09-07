package com.bw.controller;

import com.alibaba.fastjson.JSONObject;
import com.bw.pojo.Book;
import com.bw.service.IBookService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.Oneway;
import javax.jws.WebParam;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 14:16 2017/8/18
 */
@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private IBookService bookService;

    //查询图书信息
    @RequestMapping(value = "queryAllBooks", method = RequestMethod.GET)
    public String queryAllBooks(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        List<Book> books = bookService.getAllBooks();
        session.setAttribute("bookList",books);
        return "book";
    }



    /*//上传
    @RequestMapping(value = "upload.action", method = RequestMethod.POST)
    public String upload(*//*@RequestParam("bookId") int bookId,*//* Model model,
                         MultipartFile file, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String bookid = request.getParameter("bookid");


       *//* JSONObject res = new JSONObject();
        res.put("code", 1);

        //文件实际上传路径
        String realPath = request.getSession().getServletContext().getRealPath("/");
        //设置响应给前台内容的数据格式
        response.setContentType("text/plain;charset=utf-8");
        //设置响应给前台内容的printWriter对象
        PrintWriter out = response.getWriter();
        String fileName = null;

        if (file.isEmpty()) {
            out.print(res.toJSONString());
            out.flush();
        } else {
            fileName = file.getOriginalFilename();
            String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
            //物理路径
            String wlPath = "E:\\java\\book\\web\\resources\\img" + trueFileName;
            //存放数据库表中的字段中(逻辑路径)
            String ljPath = "../resources/img/" + trueFileName;
            //临时路径
            String tempPath = realPath + "resources\\img\\" + trueFileName;

            //bookService.updateImgUrl(bookId, ljPath);
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(wlPath));
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(tempPath));

            res.put("code", 0);
            out.print(res.toJSONString());
            out.flush();
            return null;
        }
*//*

        // 获得原始文件名
        String fileName = file.getOriginalFilename();
        System.out.println("原始文件名:" + fileName);

        // 新文件名
        String newFileName = UUID.randomUUID() + fileName;

        // 获得项目的路径
        ServletContext sc = request.getSession().getServletContext();
        // 上传位置
        String relPath = sc.getRealPath("/img") + "\\"; // 设定文件保存的目录
        String tempPath = null;

        File f = new File(relPath);
        if (!f.exists())
            f.mkdirs();

        if (!file.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream(relPath + newFileName);
                InputStream in = file.getInputStream();
                int b = 0;
                while ((b = in.read()) != -1) {
                    fos.write(b);
                }

                //使用StreamsAPI方式拷贝文件
                Streams.copy(in,fos,true);

                fos.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("上传图片到:" + relPath + newFileName);
        // 保存文件地址，用于JSP页面回显
        model.addAttribute("fileUrl", "/img\\"+newFileName);
        return "upLoadImg";
    }*/



    @RequestMapping( value="/upload", method = RequestMethod.POST)
    public String touXiang(int id,MultipartFile imgfile, Model model, HttpServletRequest request){
        //接受到文件的流；
        //获取流对象相关的信息,图片名称,路径...
        //获取当前毫秒值,修改图片名称
        //放到物理路径上
        //放到临时路径上
        //放到数据库字段
        //调用修改方法修改imgurl(路径)字段的值
        //跳转页面


        //原文件的名称
        String imgname= imgfile.getOriginalFilename();
        //毫秒
        long l = System.currentTimeMillis();
        //新文件名
        String newimgname=l+imgname;
        //物理路径
        String wulipath="E:\\java\\book\\web\\resources\\img";
        //获取编译文件的路径
        ServletContext servletContext = request.getSession().getServletContext();
        String linshipath=servletContext.getRealPath("/resources/img"+"\\");
        File file = new File(linshipath);
        if (!file.exists()){
            file.mkdirs();
        }
        if(!imgfile.isEmpty()){
            FileOutputStream wulifileOutputStream =null;
            FileOutputStream linshifileOutputStream1=null;
            try {
                wulifileOutputStream = new FileOutputStream(wulipath+"\\"+newimgname);
                linshifileOutputStream1=new FileOutputStream(linshipath +"\\"+ newimgname);
                InputStream inputStream = imgfile.getInputStream();
                int len = 0;
                while ((len=inputStream.read())!=-1){
                    wulifileOutputStream.write(len);
                    linshifileOutputStream1.write(len);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String shujukulujing="../resources/img"+"/"+newimgname;

        Book book = new Book();
        book.setId(id);
        book.setBookImg(shujukulujing);
        bookService.updateImgUrl(book);
        return "redirect:/book/queryAllBooks.action";
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>




    }



}



