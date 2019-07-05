package com.yanghao.servers.entity;

public class Server {
    private int id;
    private String ip;
    private String servername;
    private String port;
    private String remark;

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setServername(String servername) {
        this.servername = servername;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public String getServername() {
        return servername;
    }

    public String getPort() {
        return port;
    }

    public String getRemark() {
        return remark;
    }

    @Override
    public String toString() {
        return "Server{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", servername='" + servername + '\'' +
                ", port='" + port + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
