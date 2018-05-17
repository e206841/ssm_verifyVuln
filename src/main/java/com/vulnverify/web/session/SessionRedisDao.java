package com.vulnverify.web.session;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;

import com.vulnverify.core.redis.RedisDb;



public class SessionRedisDao extends EnterpriseCacheSessionDAO {
	
	/**会话有效期30分钟*/
	private int expireTime = 30*60;
	
    /**
     * 创建session，存在redis中
     */
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.doCreate(session);
        RedisDb.setObject(sessionId.toString(), sessionToByte(session));
        RedisDb.expireObject(sessionId.toString(),expireTime);
        return sessionId;
    }
    
    public Session readSession(Serializable sessionId) throws UnknownSessionException {
        /*Session s = getCachedSession(sessionId);
        if (s == null) {
            s = super.readSession(sessionId);
        }
        return s;*/
        return doReadSession(sessionId);
    }

    // 获取session
    @Override
    protected Session doReadSession(Serializable sessionId) {
        // 先从缓存中获取session，如果没有再去数据库中获取
    	byte[] bytes = RedisDb.getObject(sessionId.toString());
    	Session session = null;
        if(bytes != null && bytes.length > 0){
            session = byteToSession(bytes);
        }
        return session;
    }

    // 更新session的最后一次访问时间
    @Override
    protected void doUpdate(Session session) {
    	super.doUpdate(session);
        RedisDb.setObject(session.getId().toString(), sessionToByte(session));
        RedisDb.expireObject(session.getId().toString(),expireTime);
    }

    // 删除session
    @Override
    protected void doDelete(Session session) {
        super.doDelete(session);
        RedisDb.delString(session.getId() + "");
    }

    // 把session对象转化为byte保存到redis中
    public byte[] sessionToByte(Session session){
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        byte[] bytes = null;
        try {
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(session);
            bytes = bo.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
    
    // 把byte还原为session
    public Session byteToSession(byte[] bytes){
        ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
        ObjectInputStream in;
        SimpleSession session = null;
        try {
            in = new ObjectInputStream(bi);
            session = (SimpleSession) in.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return session;
    }
    
}