package org.ebsoft.study4week.mvc.domain;

import lombok.Data;

@Data
public class Search {

    private Integer page;         //현재 페이지 번호
    private Integer recordSize;    //페이지당 출력할 데이터 개수
    private Integer pageLength;
    private String startDate;
    private String endDate;
    private String keyword;             //검색 키워드
    private String category;            //검색 카테고리

    public Search(Integer page, Integer recordSize, Integer pageLength, String startDate, String endDate, String keyword, String category) {
        this.page = 1;
        this.recordSize = 5;
        this.pageLength = 5;
        this.startDate = "";
        this.endDate = "";
        this.keyword = "";
        this.category = "";
    }


    //Limit 쿼리의 처음
    public int getOffset(){
        return (page -1) * recordSize;
    }
}
