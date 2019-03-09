package com.hhit.biz.type.impl;

import com.hhit.biz.type.ITypeBiz;
import com.hhit.dao.type.ITypeDao;
import com.hhit.dao.type.impl.TypeDaoImpl;
import com.hhit.vo.type.Type;

import java.util.List;

public class TypeBizImpl implements ITypeBiz {
    ITypeDao typedao=new TypeDaoImpl();
    @Override
    public List<Type> findFront() {
        List<Type> type = typedao.findType();
        for (Type type1 : type) {
            type1.setName(typedao.findById(type1.getId()).getName());
        }
        return type;
    }
}
