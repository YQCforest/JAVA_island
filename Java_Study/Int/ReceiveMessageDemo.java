import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {

        //接受数据时需要指定端口号，且需要和发送时端口号保持一致
        DatagramSocket ds = new DatagramSocket(10086);

        //接受数据包
        byte[] bytes = new byte[1024];
        DatagramPacket dp  =new DatagramPacket(bytes, bytes.length);
        //接受方法，该方法为阻塞方法
        ds.receive(dp);

        //解析数据包

        //使用byte数组进行数据的存放
        byte[] data = dp.getData();
        //获取接受到数据的长度
        int len = dp.getLength();
        //定义InetAddress类获取到发送端的IP地址
        InetAddress address = dp.getAddress();
        //获取到发送端口号
        int port = dp.getPort();

        System.out.println("接受到的数据为:"+new String(data,0,len));
        System.out.println("该数据是从"+address+"这台设备中的"+port+"这个端口号发出的");

        //释放资源
        ds.close();
    }
}
