package com.yanghao.servers.utils;

import com.yanghao.servers.entity.Server;

import java.util.List;

public class ServerData {
    private long total;
    private List<Server> rows;

    public ServerData(long total, List<Server> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Server> getrows() {
        return rows;
    }

    public void setrows(List<Server> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "ServerData{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
