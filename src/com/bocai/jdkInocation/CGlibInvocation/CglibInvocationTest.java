package com.bocai.jdkInocation.CGlibInvocation;

/**
 * @author Bocai
 * @version V1.0
 * @ClassName: ${file_name}
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Date ${date} ${time}
 */
public class CglibInvocationTest {
    public  static  void main(String[] args){
        CglibBookFacade cglibBookFacade  = new CglibBookFacade();
        BookFadeService bookCglib =(BookFadeService)cglibBookFacade.getInstance( new BookFadeService());
        bookCglib.addBook();
    }
}
