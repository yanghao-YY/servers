package com.yanghao.servers.service;

import com.yanghao.servers.entity.Server;
import com.yanghao.servers.mapper.ServerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerServiceImpl implements ServerService {
    @Autowired
    ServerMapper serverMapper;
    @Override
    public List<Server> findByName(String servername) {
        return serverMapper.findByName(servername);
    }

    @Override
    public List<Server> query(String servername, String ip, String port, String remark) {
        return serverMapper.query(servername,ip,port,remark);
    }

    @Override
    public void insert(String servername, String ip, String port, String remark) {
        serverMapper.insertServer(servername,ip,port,remark);
    }

    @Override
    public void update(int id, String servername, String ip, String port, String remark) {
        serverMapper.updateServer(id,servername, ip, port, remark);
    }

    @Override
    public void delete(int id) {
        serverMapper.deleteServer(id);
    }
}
