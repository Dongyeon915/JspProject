package org.zerock.domain;

import lombok.Data;

@Data
// 검색의 기준이되는 클래스
public class Criteria {
    private int pageNum;
    private int amount;
    
    private String type;
    private String keyword;
    
    public Criteria() {
	this(1,10);
    }

    public Criteria(int pageNum, int amount) {
	this.pageNum = pageNum;
	this.amount = amount;
    }
    //검색 처리시 mysql의 동적 처리를위해 설계
    public String[] getTypeArr() {
	return type == null? new String[] {} : type.split("");
    }
}
