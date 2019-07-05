package com.yanghao.servers.service;

import com.yanghao.servers.entity.Server;

import java.util.List;

public interface ServerService {
    List<Server> findByName(String servername);
    List<Server> query(String servername,String ip,String port,String remark);
    void insert(String servername,String ip,String port,String remark);
    void update(int id,String servername,String ip,String port,String remark);
    void delete(int id);
}
