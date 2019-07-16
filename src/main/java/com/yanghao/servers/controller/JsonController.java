package com.yanghao.servers.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yanghao.servers.entity.Server;
import com.yanghao.servers.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JsonController {
    @Autowired
    ServerService serverService;
    @GetMapping("/getservers")
    public Result query(@RequestParam("servername")String servername, @RequestParam("ip")String ip, @RequestParam("port")String port, @RequestParam("remark")String remark, @RequestParam(value = "pagenum" ,defaultValue = "1")int pagenum, @RequestParam(value = "pagesize",defaultValue = "3")int pagesize, ModelMap modelMap){
        try {
            PageHelper.startPage(pagenum,pagesize);
            List<Server> serverList = serverService.query(servername,ip,port,remark);
            PageInfo<Server> pageInfo = new PageInfo<>(serverList);
            modelMap.addAttribute("pageInfo",pageInfo);
            Result result = new Result(serverList,pageInfo.getNavigatepageNums());
            return  result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
