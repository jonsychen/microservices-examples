package com.example.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;

/**
 * @author Jonsy
 *
 */
@Component
public class MyFilter extends ZuulFilter{

    private static Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
    	
    	LOGGER.info("..................................");
    	LOGGER.info("in filter ....");
        return null;
    }
}