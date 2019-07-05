package com.yanghao.servers.mapper;



import com.github.pagehelper.PageHelper;
import com.yanghao.servers.entity.Server;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;


public interface ServerMapper {
    @Select("select * from servers where servername=#{servername}")
    List<Server> findByName(String servername);

  //  @Select("select * from servers where servername=#{servername} and ip=#{ip} and port=#{port} and remark=#{remark}")
   // List<Server> query(@Param("servername")String servername, @Param("ip")String ip, @Param("port")String port, @Param("remark")String remark);

        @SelectProvider(type = ServerSqlProvider.class)
    List<Server> query(@Param("servername")String servername, @Param("ip")String ip, @Param("port")String port, @Param("remark")String remark);

    class ServerSqlProvider implements ProviderMethodResolver {
        public static String query(final @Param("servername")String servername,final  @Param("ip")String ip,final  @Param("port")String port, final @Param("remark")String remark){
          SQL sql = new SQL().SELECT("*").FROM("servers");
          if(!servername.equals("")){
              sql.WHERE("servername like #{servername}");
          }
          if(!ip.equals("")){
              sql.WHERE("ip like #{ip}");
          if( !port.equals("")){
              sql.WHERE("port like #{port}");
          }
          if(!remark.equals("")){
              sql.WHERE("remark like #{remark}");
          }
          }
           return sql.toString();

        }
    }
        @Insert("insert into servers(ip,servername,port,remark) values(#{ip},#{servername},#{port},#{remark})")
        void insertServer(@Param("servername")String servername, @Param("ip")String ip, @Param("port")String port, @Param("remark")String remark);


        @Update("update servers set ip=#{ip},servername=#{servername},port=#{port},remark=#{remark} where id=#{id}")
        void updateServer(@Param("id")int id,@Param("servername")String servername, @Param("ip")String ip, @Param("port")String port, @Param("remark")String remark);

        @Delete("delete from servers where id = #{id}")
        void deleteServer(@Param("id")int id);


}

