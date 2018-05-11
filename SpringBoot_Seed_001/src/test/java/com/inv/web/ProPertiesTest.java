package com.inv.web;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inv.util.InvProperties;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProPertiesTest {

	
	@Autowired
    private InvProperties invProperties;


    @Test
    public void getHello() throws Exception {
    	System.out.println(invProperties.getTitle());
        Assert.assertEquals(invProperties.getTitle(), "This is 我的 Title");
        Assert.assertEquals(invProperties.getDescription(), "This is 我的 Description");
    }

    
    @Test
    public void testMap() throws Exception {
    	Map<String, Long> orderMinTime=new HashMap<String, Long>();
    	long xx=orderMinTime.get("123");
    }

}