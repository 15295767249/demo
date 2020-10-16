package cn.com.yhb.config;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.sql.*;

/**
 * @author yhb
 * @version 1.0
 * @date 2020/10/13 9:47
 */
public class SSHConnection {

    // 服务器上数据库端口号
    Session session = null;

    /**
     *    建立SSH连接
     */
    public Session SSHConnection() {
        try {
            String Sshuser ="erp";
            String SShPassword = "Gbrh$xm3I10yUs45my1zY1iQn893";
            String SSHip ="116.62.62.191";
            int SShPort = 22;
            JSch jsch = new JSch();
            session = jsch.getSession(Sshuser,SSHip,SShPort );
            session.setPassword(SShPassword );
            /*
             *默认情况下，StrictHostKeyChecking=ask。简单所下它的三种配置值：
             *1.StrictHostKeyChecking=no #最不安全的级别，当然也没有那么多烦人的提示了，相对安
             *全的内网测试时*建议使用。如果连接server的key在本地不存在，那么就自动添加到文件中
             *（默认是known_hosts），并且给*出一个警告。
             *2.StrictHostKeyChecking=ask #默认的级别，就是出现刚才的提示了。如果连接和key不匹
             *配，给出提示，并拒绝登录。
             *3.StrictHostKeyChecking=yes #最安全的级别，如果连接与key不匹配，就拒绝连接，不会
             *提示详细信
             *息。
             */

            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();//连接

            System.out.println(session.getServerVersion());//这里打印SSH服务器版本信息

            //  正向代理
            int assinged_port = session.setPortForwardingL(3307, "rm-bp155d1u93515wx69eo.mysql.rds.aliyuncs.com", 3306);//端口映射 转发

            System.out.println("localhost:" + assinged_port);

            //ssh -R 192.168.0.102:5555:192.168.0.101:3306 yunshouhu@192.168.0.102
            //session.setPortForwardingR("192.168.0.102",5555, "192.168.0.101", 3306);
            // System.out.println("localhost:  -> ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }
    /**
     *    断开SSH连接
     */
    public void closeSSH (Session session)
    {
        if (null != this.session) {
            this.session.disconnect();
        } else {
            session.disconnect();
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public Connection getConnection(){
        Connection connection = null;
        String driverClass = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3307/erp_yto";
        String user = "sterp";
        String password = "Gbrh$xm3I10yUs45Lk1zY1iQn891";
        try {
            //第二步：加载驱动
            Class.forName(driverClass);
            //第三步：通过DriverManager的getconnection方法获取数据连接
            connection = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ResultSet runSql(String sql, Statement st) {
        ResultSet resultSet = null;
        try {
            resultSet = st.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void closeConn(Connection connection, Statement st) {
        try {
            if (null != st) {
                st.close();
            }
            if (null != connection) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
