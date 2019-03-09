package com.hhit.biz.Mesg;

import com.hhit.vo.mesg.Mesg;

import java.util.List;

public interface IMesgBiz {
    /**
     * 显示所有资讯
     * @return
     */
    List<Mesg> showMesgs();
    /**
     * 根据分页显示所有资讯
     * @return
     */
    List<Mesg> showMesgs(int pageNo, int pageSize);

    /**
     * 根据id得到mesg对象
     * @param id
     * @return
     */
    Mesg getMesgById(int id);

    /**
     * 获得mesg对象个数
     * @return
     */
    int getMesgNum();
}
