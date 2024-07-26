package com.easy.archiecture;

import com.alibaba.fastjson.JSON;
import com.easy.archiecture.model.HuangZhong;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/26 17:14
 */
@Slf4j
public class HeroServlet extends HttpServlet {

    private static final long serialVersionUID = -8500219553970116739L;

    @Override
    public void init() throws ServletException {
        log.info("HeroServlet init success");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter printWriter = response.getWriter();
        HuangZhong huangZhong = new HuangZhong();
        huangZhong.setName("黄忠");
        huangZhong.setDesc("百步穿杨，百发百中");
        String result = JSON.toJSONString(huangZhong);
        printWriter.write(result);
        printWriter.flush();
    }

    @Override
    public void destroy() {
        log.info("HeroServlet destroy success");
    }
}
