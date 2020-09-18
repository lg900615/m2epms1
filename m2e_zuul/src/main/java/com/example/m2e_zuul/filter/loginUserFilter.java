package com.example.m2e_zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

@Component
public class loginUserFilter extends ZuulFilter {

//    private Logger logger = LoggerFactory.getLogger(loginUserFilter.class);

    @Override
    public String filterType() {//过滤器类型
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {//同级别优先级
        return 0;
    }

    @Override
    public boolean shouldFilter() {//过滤器是否使用
        RequestContext currentContext = RequestContext.getCurrentContext();
//        return currentContext.sendZuulResponse();
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getHeader("token");
        if (token == null||"".equals(token)) {
            System.out.println("————————身份认证失败——————————IP地址:  "+getIpAddr(request));
            System.out.println("token为空!");
            currentContext.setSendZuulResponse(true);
            currentContext.setResponseStatusCode(401);
            currentContext.setResponseBody("token非法无效!");
//            logger.info("————————身份认证失败——————————IP地址:  "+ IPUtils.getIpAddr(request));
//            logger.info("token为空!");
//            throw new AuthenticationException("token为空!");
        }

        return null;
    }
    /**
     * 获取Ip地址
     *
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
