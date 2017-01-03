package com.pingan.web.study.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhyy on 2017/1/3.
 */
@WebServlet(name = "LoginController",value = "/LoginController")
public class LoginController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("这个是初始化方法");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("看看有没有进来");

    }
}
