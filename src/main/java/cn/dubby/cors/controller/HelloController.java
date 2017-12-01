package cn.dubby.cors.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
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

//    @CrossOrigin(origins = "http://localhost:9090")
//    @RequestMapping(value = "simpleXSInvocation")
//    public String simpleXSInvocation(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//        return "simpleXSInvocation";
//    }

    @RequestMapping(value = "simpleXSInvocationWithCookie")
    public String simpleXSInvocationWithCookie(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        httpServletResponse.addHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        //有下面的header，就可以接受带cookie的跨域请求了
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
        return "simpleXSInvocationWithCookie";
    }

//    @CrossOrigin(origins = "http://localhost:9090")
//    @RequestMapping(value = "simpleXSInvocationWithCookie")
//    public String simpleXSInvocationWithCookie(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//        return "simpleXSInvocationWithCookie";
//    }

    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping(value = "preflightInvocation")
    public String preflightInvocation(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return "preflightInvocation";
    }

    @RequestMapping(value = "preflightInvocation2")
    public String preflightInvocation2(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return "preflightInvocation2";
    }

    @RequestMapping(value = "preflightInvocation3")
    public String preflightInvocation3(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        httpServletResponse.addHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        return "preflightInvocation3";
    }
}
