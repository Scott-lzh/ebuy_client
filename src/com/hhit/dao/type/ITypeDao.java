package com.hhit.dao.type;

import com.hhit.vo.type.Type;

import java.util.List;

public interface ITypeDao {
    /**
     * 查找类型分类
     * @return 类型对象列表
     */
    List<Type> findType();

    /**
     * 根据类型id查找类型对象
     * @param id 类型id
     * @return 类型对象
     */
    Type findById(int id);
}
