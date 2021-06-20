package com.liuwohe.crm.settings.web.controller;

import com.liuwohe.crm.settings.domain.User;
import com.liuwohe.crm.settings.service.UserService;
import com.liuwohe.crm.settings.service.impl.UserServiceImpl;
import com.liuwohe.crm.utils.MD5Util;
import com.liuwohe.crm.utils.PrintJson;
import com.liuwohe.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.PrinterIOException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("进入用户控制器");
        String path = req.getServletPath();

        if("/settings/user/login.do".equals(path)){
            login(req,resp);
        }else if ("settrings/user/login.do".equals(path)){

        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
       String loginAct=req.getParameter("loginAct");
       String loginPwd=req.getParameter("loginPwd");
       loginAct = MD5Util.getMD5(loginAct);
       String ip = req.getRemoteAddr();

       //未来业务层开发统一使用代理类形态的接口对象
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());

        try{
            User user = us.login(loginAct,loginPwd,ip);

            req.getSession().setAttribute("user",user);

            PrintJson.printJsonFlag(resp,true);
        }catch(Exception e){
            e.printStackTrace();
            //一旦执行catch块的信息，说明业务层验证登录失败了，为controller抛出了异常
            String msg = e.getMessage();

            Map<String,Object> map = new HashMap<String, Object>();
            map.put("success",false);
            map.put("msg",msg);
            PrintJson.printJsonObj(resp,map);
        }
    }
}
