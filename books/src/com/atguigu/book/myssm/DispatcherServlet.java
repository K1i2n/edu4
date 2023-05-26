package com.atguigu.book.myssm;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class DispatcherServlet extends ViewBaseServlet {
    //Map<String,Object> map = new HashMap<>();
    private  BeanFactory beanFactory;

    public DispatcherServlet(){}
    @Override
    public void init() throws ServletException {
        super.init();
        //beanFactory = new ClassPathXmlApplicationContext();
        ServletContext application = getServletContext();
        Object beanFactoryObj = application.getAttribute("beanFactory");
        if(beanFactoryObj!=null){
            beanFactory = (BeanFactory) beanFactoryObj;
        }else{
            throw new RuntimeException("获取失败");
        }
    }



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operate = req.getParameter("operate");
        Object o = beanFactory.getBean(operate);
        for(Method methods : o.getClass().getDeclaredMethods()){
            if(operate.equals(methods)){
                Parameter[] parameters = methods.getParameters();
                Object[] parameterValue = new Object[parameters.length];
                for(int i=0;i< parameters.length;i++){
                    Parameter parameter=parameters[i];
                    String parameterName = parameter.getName();
                    if("req".equals(parameterName)){
                        parameterValue[i]=req;
                    }else if ("resp".equals(parameterName)){
                        parameterValue[i]=resp;
                    }else if("session".equals(parameterName)){
                        parameterValue[i] =req.getSession();
                    }else{
                        String parameter1 = req.getParameter(parameterName);
                        String typeName = parameter.getType().getName();
                        Object obj=null;
                        if(parameter1!=null){
                            if("java.lang.Integer".equals(typeName)){
                                obj= Integer.parseInt(parameter1);

                            }else{
                                obj = parameter1;
                            }
                            parameterValue[i] =obj;
                        }
                    }
                }

                methods.setAccessible(true);
                try {
                    Object invoke = methods.invoke(o, parameterValue);
                    if(invoke!=null){

                        String str = (String) invoke;
                        if(str.startsWith("redirect")){
                            String redirectStr = str.substring("redirect".length());
                            resp.sendRedirect(redirectStr);
                        }else{
                            super.processTemplate(str,req,resp);
                        }

                    }else{
                        throw new RuntimeException("不存在");
                    }

                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    throw new ServletException("111");

                }
            }
        }

    }

}

