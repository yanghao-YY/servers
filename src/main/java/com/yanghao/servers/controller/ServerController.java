package com.yanghao.servers.controller;

import com.github.pagehelper.PageHelper;
import com.yanghao.servers.entity.Server;
import com.yanghao.servers.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServerController {
    @Autowired
    ServerService serverService;
    @PostMapping("/findByName")
    public List<Server> findByName(@RequestParam("severname")String servername) {
        try {
            //     return serverService.findByName(servername);
            List<Server> serverList = serverService.findByName(servername);
            return  serverList;

//            for (Server server : serverList) {
//
//                return server.toString();
//            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    @PostMapping("/query")
    public List<Server> query(@RequestParam("servername")String servername,@RequestParam("ip")String ip,@RequestParam("port")String port,@RequestParam("remark")String remark,@RequestParam("page")int page,@RequestParam("pagesize")int pagesize){
        try {
            PageHelper.startPage(page,pagesize);
            List<Server> serverList = serverService.query(servername,ip,port,remark);
            return  serverList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @PostMapping("/add")
    public String add(@RequestParam("servername")String servername,@RequestParam("ip")String ip,@RequestParam("port")String port,@RequestParam("remark")String remark){
       serverService.insert(servername,ip,port,remark);
       System.out.println("111");
        return "新增成功！";
    }
    @PostMapping("/update")
    public String update(@RequestParam("id")int id,@RequestParam("servername")String servername,@RequestParam("ip")String ip,@RequestParam("port")String port,@RequestParam("remark")String remark){
       serverService.update(id,servername,ip,port,remark);
        return "修改成功";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("id")int id){
        serverService.delete(id);
        return "删除成功";
    }

}
