package com.company.support.utils;

public class Pagination {
    int limit;
    int offset;

    public Pagination(int pageSize, int page){
        int _page;
        int _pageSize;

        if(pageSize == 0){
            _pageSize = 100;
        }else{
            _pageSize = pageSize;
        }

        if(page == 0){
            _page = 1;
        }else{
            _page = page;
        }

        int max = _page * _pageSize;

        this.limit = _pageSize;
        this.offset = max - _pageSize;
    }

    public int limit() {
        return limit;
    }

    public int offset() {
        return offset;
    }
}
