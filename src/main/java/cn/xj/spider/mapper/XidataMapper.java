package cn.xj.spider.mapper;



import cn.xj.spider.model.Xidata;

import java.util.List;

public interface XidataMapper {
    void insert(Xidata jobs);

    List<Xidata> findAll();
}
