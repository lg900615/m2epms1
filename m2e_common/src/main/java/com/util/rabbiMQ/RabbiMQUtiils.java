package com.util.rabbiMQ;

import com.enumInterface.RabbinMqConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * RabbitMq工具类
 */
@Component
public class RabbiMQUtiils {
    private static final Logger log = LoggerFactory.getLogger(RabbiMQUtiils.class);

    private static ConnectionFactory connectionFactory;
    static {
        RabbinMqConfig rabbinMqConfig = new RabbinMqConfig();
        //创建mq的连接工厂对象
        connectionFactory = new ConnectionFactory();
        //设置连接rabbit的主机地址
        connectionFactory.setHost(rabbinMqConfig.getHost());
        //设置连接端口
        connectionFactory.setPort(rabbinMqConfig.getPort());
        //设置虚拟主机的用户名和密码
        connectionFactory.setUsername(rabbinMqConfig.getUsername());
        connectionFactory.setPassword(rabbinMqConfig.getPassword());
    }



    //定义一个获取连接
    public Connection getConnection(){
        try {
            //通过连接工厂获取连接
            Connection connection = connectionFactory.newConnection();
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭连接通道的方法
    public void closeConnectionChannel(Channel channel, Connection connection){
        try {
            if (channel!=null) channel.close();
            if (connection!=null)connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
