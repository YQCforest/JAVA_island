import java.io.IOException;
import java.net.*;

public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        //创建DatagramSocket对象
        //无参构造会碎金进行端口号的获取
        DatagramSocket ds = new DatagramSocket();

        //打包数据
        String str = "你好世界";
        byte[] bytes = str.getBytes();
        //指定由哪台设备进行数据的发送
        //使用“127.0.0.1”就是本机的IP地址进行数据的发送
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10086;
        //对发送的数据进行打包，其中的参数有:数据数组，数据长度，发送到设备的IP地址，发送数据端口号
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length,address,port);

        //发送数据
        ds.send(dp);

        //释放资源
        ds.close();
    }
}
