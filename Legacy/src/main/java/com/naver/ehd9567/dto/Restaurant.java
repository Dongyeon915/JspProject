package com.naver.ehd9567.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class Restaurant {
    private String name;
    private String number;
    private Chef chef;

    @Autowired
    public Chef getChef() {
	return chef;
    }
}
