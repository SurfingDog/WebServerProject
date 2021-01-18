package com.webserver.servlet;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LoginServlet {
    public void service(HttpRequest request, HttpResponse response){
        System.out.println("LoginServlet:开始处理登陆");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try (
                RandomAccessFile raf = new RandomAccessFile("user.dat","r");
                ){
            for (int i = 0; i < raf.length()/100; i++) {
                raf.seek(i*100);
                byte[] data = new byte[32];
                raf.read(data);
                String name = new String(data,"UTF-8").trim();
                if (name.equals(username)){
                    raf.read(data);
                    String pwd = new String(data,"UTF-8").trim();
                    if (pwd.equals(password)){
                        File file = new File("./webapps/myweb/login_success.html");
                        response.setEntity(file);
                        return;
                    }
                    break;
                }
            }
            File file = new File("./webapps/myweb/login_fail.html");
            response.setEntity(file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
