package com.yanglf.mvc.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yanglf
 * @sine 2019.02.01
 * @descriptipon  servlet 异步非阻塞
 * @see
 */
@WebServlet(urlPatterns = "/my/asy",asyncSupported = true)
public class AsyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext async = req.startAsync();
        async.start(() -> {
            try {
                resp.getWriter().write("Hello,Asy!!");
                // 触发异步
                async.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
