package com.hhit.biz.Mesg.impl;

import com.hhit.biz.Mesg.IMesgBiz;
import com.hhit.dao.BaseDao;
import com.hhit.dao.mesg.IMesgDao;
import com.hhit.dao.mesg.impl.MesgDaoImpl;
import com.hhit.vo.mesg.Mesg;

import java.util.List;

public class MesgBizImpl extends BaseDao implements IMesgBiz {
    IMesgDao md = new MesgDaoImpl();

    @Override
    public List<Mesg> showMesgs() {
        List<Mesg> mesgs = md.findMesgs();
        return mesgs;
    }

    @Override
    public List<Mesg> showMesgs(int pageNo, int pageSize) {
        List<Mesg> mesgs = md.findMesgs(pageNo, pageSize);
        return mesgs;
    }

    @Override
    public Mesg getMesgById(int id) {
        Mesg mesg = md.getMesgById(id);
        return mesg;
    }

    @Override
    public int getMesgNum() {
        int count = md.getMesgNum();
        return count;
    }
}
