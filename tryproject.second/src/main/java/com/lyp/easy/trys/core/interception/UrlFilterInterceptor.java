package com.lyp.easy.trys.core.interception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by lyp on 2016/10/20.
 * 记录请求信息
 */
public class UrlFilterInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(UrlFilterInterceptor.class.getName());
    private long startTime;

    /**
     * 该方法在目标方法之前被调用
     * 若返回值为true,则继续调用后续的拦截器和目标方法
     * 若返回值为false,则不会调用后续的拦截器和目标方法
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuilder sbUrl = new StringBuilder();
        sbUrl.append(String.format("RemoteAddr:[%s]", request.getRemoteAddr()));
        sbUrl.append(String.format(" Method:[%s]", request.getMethod()));
        sbUrl.append(" RequestURI:" + request.getRequestURI());
        sbUrl.append(" QueryString:" + request.getQueryString());
//        try {
//            BufferedReader bufferedReader = request.getReader();
//            String line;
//            StringBuilder sbBody = new StringBuilder();
//            while ((line = bufferedReader.readLine()) != null) {
//                sbBody.append(line);
//            }
//            sbUrl.append(" Body:" + sbBody.toString());
//        } catch (Exception ex) {
//
//        }
        logger.debug(sbUrl.toString());
        startTime=System.currentTimeMillis();
        return true;
    }

    /**
     * 在调用目标方法之后, 渲染视图之前调用
     * 可以对请求域中的属性或视图做修改
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在渲染视图之后被调用
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long endTime=System.currentTimeMillis();
        logger.debug(request.getRemoteAddr()+"访问了"+request.getRequestURI()+",总用时 "+ (endTime-startTime)+"毫秒。");
    }
}
