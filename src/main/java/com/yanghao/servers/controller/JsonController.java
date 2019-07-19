package com.yanghao.servers.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yanghao.servers.entity.Server;
import com.yanghao.servers.service.ServerService;
import com.yanghao.servers.utils.Result;
import com.yanghao.servers.utils.ServerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JsonController {
    @Autowired
    ServerService serverService;
    @PostMapping("/getservers")
    public ServerData query(@RequestParam("servername")String servername, @RequestParam("ip")String ip, @RequestParam("port")String port, @RequestParam("remark")String remark, @RequestParam(value = "page" ,defaultValue = "1")int page, @RequestParam(value = "rows",defaultValue = "3")int rows){
        try {
            PageHelper.startPage(page,rows);
            List<Server> serverList = serverService.query(servername,ip,port,remark);
            PageInfo<Server> pageInfo = new PageInfo<>(serverList);
            ServerData serverData = new ServerData(pageInfo.getTotal(),serverList);
            return serverData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @PostMapping("/add")
    public Result add(@RequestParam("servername")String servername, @RequestParam("ip")String ip, @RequestParam("port")String port, @RequestParam("remark")String remark){
        try {
            serverService.insert(servername,ip,port,remark);
            Result result = new Result("0000","success");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("9999","新建失败");
        }

    }
    @PostMapping("/update")
    public String update(@RequestParam("id")int id,@RequestParam("servername")String servername,@RequestParam("ip")String ip,@RequestParam("port")String port,@RequestParam("remark")String remark){
        serverService.update(id,servername,ip,port,remark);
        return "修改成功";
    }
    @PostMapping("/delete")
    public Result delete(@RequestParam("id")int id){
        try {
            serverService.delete(id);
            return new Result("0000","success");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("9999","删除失败");

        }

    }
}
