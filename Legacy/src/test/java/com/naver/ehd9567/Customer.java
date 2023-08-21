package com.naver.ehd9567;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.naver.ehd9567.dto.Chef;
import com.naver.ehd9567.dto.Restaurant;

// Test코드를 실행할 바탕 Class
@RunWith(SpringJUnit4ClassRunner.class)
// applicationContext가 load할 파일
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Customer {
    // 
    @Autowired
    private Restaurant restaurant;

    @Autowired
    private Chef chef;

    @Test
    public void nullTest() {
	assertNotNull(restaurant.getChef());
    }
// Test붙이기
    @Test
    public void chefBeanTest() {
	assertNotNull("Chef Class는 Null이 아니야!", chef);
    }

    @Ignore
    public void addTest() {
	assertEquals(9, 3 + 5);
    }
}
