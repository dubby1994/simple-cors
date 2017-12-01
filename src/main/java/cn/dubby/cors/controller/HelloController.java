package cn.dubby.cors.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by teeyoung on 17/12/1.
 */
@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @RequestMapping(value = "simpleXSInvocation")
    public String simpleXSInvocation(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        //下面这个即便有，也不能接受带有cookie的跨域请求，因为上面使用了 *
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
        return "simpleXSInvocation";
    }

    @RequestMapping(value = "simpleXSInvocation2")
    public String simpleXSInvocation2(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        httpServletResponse.addHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        //有下面的header，就可以接受带cookie的跨域请求了
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
        return "simpleXSInvocation2";
    }
}
