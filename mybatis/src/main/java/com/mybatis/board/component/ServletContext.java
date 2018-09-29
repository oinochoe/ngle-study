package com.mybatis.board.component;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

public class ServletContext {
    @Bean
    public BeanNameViewResolver beanNameViewResolver() {
        BeanNameViewResolver beanNameViewResolver = BeanNameViewResolver();
        beanNameViewResolver.setOrder(1);
        return beanNameViewResolver;
    }

    @Bean
    public ExcelView excelView() {
        ExcelView excelView = new ExcelView();
        return excelView;
    }

    // 아래 코드는 각자 존재할텐데 이 order보다 위의
    // BeanNameViewResolver의 order가 더 작아야 함
    @Bean
    public UrlBasedViewResolver urlBasedViewResolver() {
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setOrder(2);
        urlBasedViewResolver.setViewClass(JstlView.class);
        urlBasedViewResolver.setPrefix("/WEB-INF/jsp");
        urlBasedViewResolver.setSuffix(".jsp");
        return urlBasedViewResolver;
    }
}
