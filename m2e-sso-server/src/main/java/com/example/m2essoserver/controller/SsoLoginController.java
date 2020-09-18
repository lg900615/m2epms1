package com.example.m2essoserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/sso")
public class SsoLoginController {
    @Autowired
    private StringRedisTemplate template;

    /**
     * 判断key是否存在
     */
    @RequestMapping("/redis/hasKey/{key}")
    public Boolean hasKey(@PathVariable("key") String key) {
        try {
            return template.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 校验用户名密码，成功则返回通行令牌（这里写死huanzi/123456）
     */
    @RequestMapping("/checkUsernameAndPassword")
    private String checkUsernameAndPassword(String username, String password) {
        //通行令牌
        String flag = null;
        if ("huanzi".equals(username) && "123456".equals(password)) {
            //用户名+时间戳（这里只是demo，正常项目的令牌应该要更为复杂）
            flag = username + System.currentTimeMillis();
            //令牌作为key，存用户id作为value（或者直接存储可暴露的部分用户信息也行）设置过期时间（我这里设置3分钟）
            template.opsForValue().set(flag, "1", (long) (3 * 60), TimeUnit.SECONDS);
        }
        return flag;
    }

    /**
     * 跳转登录页面
     */
    @RequestMapping("/loginPage")
    private ModelAndView loginPage(String url) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("url", url);
        return modelAndView;
    }

    /**
     * 页面登录
     */
    @RequestMapping("/login")
    private String login(HttpServletResponse response, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password, @RequestParam(value = "url") String url) {
        String check = checkUsernameAndPassword(username, password);
        if (!StringUtils.isEmpty(check)) {
            try {
                Cookie cookie = new Cookie("accessToken", check);
                cookie.setMaxAge(60 * 3);
                //设置域
//                cookie.setDomain("huanzi.cn");
                //设置访问路径
                cookie.setPath("/");
                response.addCookie(cookie);
                //重定向到原先访问的页面
                response.sendRedirect("");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return "登录失败";
    }
}

