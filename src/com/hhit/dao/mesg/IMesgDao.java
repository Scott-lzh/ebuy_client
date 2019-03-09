package com.hhit.dao.mesg;

import com.hhit.vo.mesg.Mesg;

import java.util.List;

public interface IMesgDao {
    /**
     * 获取所有资讯对象
     * @return
     */
    List<Mesg> findMesgs();

    /**
     * 分页显示数据
     * @param pageNo
     * @param sumSize
     * @return
     */
    List<Mesg> findMesgs(int pageNo, int sumSize);

    /**
     * 根据id获取对应mesg对象
     * @param id
     * @return
     */
    Mesg getMesgById(int id);

    /**
     * 获得Mesg对象的数量
     * @return
     */
    int getMesgNum();
}
