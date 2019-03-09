package com.hhit.biz.type;

import com.hhit.vo.type.Type;

import java.util.List;

public interface ITypeBiz {
    /**
     * 获得分类信息
     * @return
     */
    List<Type> findFront();

}
