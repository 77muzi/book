package com.bw.pojo;

import sun.nio.ch.SelectorImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author:lihongqiong
 * @Description:
 * @Date:create in 11:00 2017/8/16
 */
public class User {
    private int id;
    private String userName;
    private String userPassword;
    private String reUserPassword;

    private int userSex;
    private Date userBirthday;
    private int age;

    public int getAge() throws Exception {
        if (getUserBirthday()==null){
            return 0;
        }
        return getAge(getUserBirthday());
    }

    public void setAge(int age) {
        this.age = age;
    }

    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy:Mm:dd");

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getReUserPassword() {
        return reUserPassword;
    }

    public void setReUserPassword(String reUserPassword) {
        this.reUserPassword = reUserPassword;
    }

    //由出生日期获得年龄
    public  int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            }else{
                age--;
            }
        }
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", reUserPassword='" + reUserPassword + '\'' +
                ", userSex=" + userSex +
                ", userBirthday=" + userBirthday +
                ", age=" + age +
                '}';
    }
}
