package com.yanghao.servers.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yanghao.servers.entity.Server;
import com.yanghao.servers.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ServerController {
    @Autowired
    ServerService serverService;
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("index");
        return "index";
    }
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
    @GetMapping("/query")
    public String query(@RequestParam("servername")String servername,@RequestParam("ip")String ip,@RequestParam("port")String port,@RequestParam("remark")String remark,@RequestParam(value = "pagenum" ,defaultValue = "1")int pagenum,@RequestParam(value = "pagesize",defaultValue = "3")int pagesize,ModelMap modelMap){
        try {

            PageHelper.startPage(pagenum,pagesize);
            List<Server> serverList = serverService.query(servername,ip,port,remark);
            PageInfo<Server> pageInfo = new PageInfo<>(serverList);
            modelMap.addAttribute("servers",serverList);
            modelMap.addAttribute("pageInfo",pageInfo);
           return  "index";
//            return  serverList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @PostMapping("/add1")
    public String add(@RequestParam("servername")String servername,@RequestParam("ip")String ip,@RequestParam("port")String port,@RequestParam("remark")String remark){
       serverService.insert(servername,ip,port,remark);
       System.out.println("111");
        return "新增成功！";
    }
    @PostMapping("/update1")
    public String update(@RequestParam("id")int id,@RequestParam("servername")String servername,@RequestParam("ip")String ip,@RequestParam("port")String port,@RequestParam("remark")String remark){
       serverService.update(id,servername,ip,port,remark);
        return "修改成功";
    }
    @PostMapping("/delete1")
    public String delete(@RequestParam("id")int id){
        serverService.delete(id);
        return "删除成功";
    }

}
