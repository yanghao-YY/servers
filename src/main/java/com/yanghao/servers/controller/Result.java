package com.yanghao.servers.controller;

import com.yanghao.servers.entity.Server;

import java.util.Arrays;
import java.util.List;

public class Result {
    private List<Server> server;

    private int[] pageNums;

    public List<Server> getServer() {
        return server;
    }

    public int[] getPageNums() {
        return pageNums;
    }

    public void setServer(List<Server> server) {
        this.server = server;
    }

    public void setPageNums(int[] pageNums) {
        this.pageNums = pageNums;
    }

    public Result(List<Server> server, int[] pageNums) {
        this.server = server;
        this.pageNums = pageNums;
    }

    @Override
    public String toString() {
        return "Result{" +
                "server=" + server +
                ", pageNums=" + Arrays.toString(pageNums) +
                '}';
    }
}
