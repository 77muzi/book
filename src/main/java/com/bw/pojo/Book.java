package com.bw.pojo;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 14:08 2017/8/18
 */
public class Book {
    private int id;
    private String bookName;
    private Double bookPrice;
    private int bookCount;
    private String bookImg;

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookNname) {
        this.bookName = bookNname;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookCount=" + bookCount +
                '}';
    }
}
