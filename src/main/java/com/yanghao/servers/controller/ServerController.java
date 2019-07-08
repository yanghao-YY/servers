package com.yanghao.servers.controller;

import com.github.pagehelper.PageHelper;
import com.yanghao.servers.entity.Server;
import com.yanghao.servers.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/query")
    public String query(@RequestParam("servername")String servername,@RequestParam("ip")String ip,@RequestParam("port")String port,@RequestParam("remark")String remark,@RequestParam("page")int page,@RequestParam("pagesize")int pagesize,ModelMap modelMap){
        try {
//            page=1;
//            pagesize=3;
            PageHelper.startPage(page,pagesize);
            List<Server> serverList = serverService.query(servername,ip,port,remark);
            modelMap.addAttribute("servers",serverList);
            return  "index";

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
