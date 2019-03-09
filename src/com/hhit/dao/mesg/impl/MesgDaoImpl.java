package com.hhit.dao.mesg.impl;

import com.hhit.dao.BaseDao;
import com.hhit.dao.mesg.IMesgDao;
import com.hhit.vo.mesg.Mesg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MesgDaoImpl extends BaseDao implements IMesgDao {

    @Override
    public List<Mesg> findMesgs() {
        Mesg mesg = null;
        List<Mesg> mesgList = new ArrayList<Mesg>();
        ;
        String sql = "select eb_msgid, eb_msgtitle, eb_msgtime, eb_msgauthor, " +
                " eb_msgclicknum, eb_msgtext, eb_msgaid from eb_message";
        Object[] params = null;

        res = super.executeQuery(sql, params);
        try {
            while (res.next()) {
                mesg = new Mesg();
                mesg.setId(res.getInt("eb_msgid"));
                mesg.setTitle(res.getString("eb_msgtitle"));
                mesg.setTime(res.getDate("eb_msgtime"));
                mesg.setAuthor(res.getString("eb_msgauthor"));
                mesg.setClickNum(res.getInt("eb_msgclicknum"));
                mesg.setText(res.getString("eb_msgtext"));
                mesg.setAId(res.getInt("eb_msgaid"));
                mesgList.add(mesg);
//                System.out.println(mesg.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return mesgList;
    }

    @Override
    public List<Mesg> findMesgs(int pageNo, int pageSize) {
        List<Mesg> mesgList = new ArrayList<Mesg>();
        String sql = "select * FROM( " +
                " select mes.*,ROWNUM rn FROM (\n" +
                " select eb_msgid, eb_msgtitle, eb_msgtime, eb_msgauthor, eb_msgclicknum, eb_msgtext, eb_msgaid \n" +
                " FROM eb_message inner join eb_user u on eb_message.eb_msgaid=u.eb_userid ) mes\n" +
                " where rownum<=(?*?) ) where rn>(?-1)*?";
        Mesg mesg = null;
        Object[] params = {pageNo, pageSize, pageNo, pageSize};
        res = super.executeQuery(sql, params);
        try {
            while (res.next()) {
                mesg = new Mesg();
                mesg.setId(res.getInt("eb_msgid"));
                mesg.setTitle(res.getString("eb_msgtitle"));
                mesg.setTime(res.getDate("eb_msgtime"));
                mesg.setAuthor(res.getString("eb_msgauthor"));
                mesg.setClickNum(res.getInt("eb_msgclicknum"));
                mesg.setText(res.getString("eb_msgtext"));
                mesg.setAId(res.getInt("eb_msgaid"));
                mesgList.add(mesg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {


            this.closeAll();
        }
        return mesgList;
    }

    @Override
    public Mesg getMesgById(int id) {
        Mesg mesg = null;
        String sql = "select eb_msgid, eb_msgtitle, eb_msgtime, eb_msgauthor, " +
                " eb_msgclicknum, eb_msgtext, eb_msgaid from eb_message where eb_msgid = ?";
        Object[] params = {id};
        res = super.executeQuery(sql, params);
        try {
            if (res.next()) {
                mesg = new Mesg();
                mesg.setId(res.getInt("eb_msgid"));
                mesg.setTitle(res.getString("eb_msgtitle"));
                mesg.setTime(res.getDate("eb_msgtime"));
                mesg.setAuthor(res.getString("eb_msgauthor"));
                mesg.setClickNum(res.getInt("eb_msgclicknum"));
                mesg.setText(res.getString("eb_msgtext"));
                mesg.setAId(res.getInt("eb_msgaid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return mesg;
    }

    @Override
    public int getMesgNum() {
        String sql = "select count(1) count from eb_message";
        Object[] params = null;
        int count = 0;
        res = super.executeQuery(sql, params);
        try {
            if (res.next()) {
                count = res.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return count;
    }
}
