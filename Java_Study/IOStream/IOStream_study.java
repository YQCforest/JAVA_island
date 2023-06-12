package IO;

import org.apache.commons.io.FileUtils;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class IOStream_study {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        study01();
        study02();
        study03();
        study04();
        study05_1();
        study05_2();
        study06();
        study07();
        study08();
        study09();
        study10();
        study11();
        study12();
        study13();
        study14();
    }


    public static void study01() throws IOException {

        //如果文件路径不存在，会创建一个新的文件，但是必须保证父级路径是存在的
        //如果文件已经存在，那么会清空文件中的内容
        FileOutputStream fos = new FileOutputStream("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study01.txt");
        //write()写入
        //方法的形参是整数，但是实际上写入到本地文件中的整数再ASCII上的对应的字符
        fos.write(98);
        //关闭流
        //每次使用完流之后都要释放流，就是为了解除java对与文件的占用
        fos.close();
    }

    public static void study02() throws IOException {

        //文件的写入方法(一次多次写入)
        //在write()方法中写入byte[]数组
        FileOutputStream fos = new FileOutputStream("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study02.txt");
        //write()方法的重载--write(byte[],int start,int len)
        //指的是 从byte数组的start开始，写入长度为len的字节内容
        byte[] bytes = {97, 98, 99, 100, 101};
        fos.write(bytes);
        fos.close();
    }

    public static void study03() throws IOException {

        //续写--再次创建对象的时候不会清空原来文件中的内容
        //打开续写开关
        FileOutputStream fos = new FileOutputStream("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study03.txt", true);

        //换行写入
        //加上\r\n
        String sub1 = "Hello\r\n";
        byte[] bytes1 = sub1.getBytes();
        fos.write(bytes1);
        String sub2 = "World\r\n";
        byte[] bytes2 = sub2.getBytes();
        fos.write(bytes2);


        fos.close();
    }

    public static void study04() throws IOException {

        //读取文件
        FileInputStream fis1 = new FileInputStream("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study01.txt");
        int read1 = fis1.read();
        System.out.println((char) read1);

        //循环读取
        FileInputStream fis2 = new FileInputStream("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study03.txt");
        int read2;
        while ((read2 = fis2.read()) != -1) {
            System.out.print((char) read2);
        }

        fis1.close();
        fis2.close();
    }

    public static void study05_1() throws IOException {

        //文件的拷贝
        FileInputStream fis = new FileInputStream("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study05_1_1.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study05_1_2.txt");
        int read;
        //这里的read记录的是每次读取到的数据,当读取到没有的时候返回-1
        while ((read = fis.read()) != -1) {
            fos.write(read);
        }
        fos.close();
        fis.close();
    }

    public static void study05_2() throws IOException {
        //文件拷贝--（快速）

        FileInputStream fis = new FileInputStream("C:\\Users\\10409\\Music\\裁缝铺 - 东海老人.mp3");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\copy.mp3");

        int len;
        byte[] bytes = new byte[1024 * 1024 * 2];
        //注意在read()方法中需要传入bytes数组
        //len记录的是一次读取的字节长度,当最后读取完的时候,这个数组中没有数据再能读取的时候,read(bytes)返回的是-1
        while ((len = fis.read(bytes)) != -1) {
            //write()方法的重载,从下标 0 开始,写入len长度的数据
            fos.write(bytes, 0, len);
        }

        fos.close();
        fis.close();
    }

    public static void study06() throws IOException {

        FileReader fr = new FileReader("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study06.txt");
        int ch;
        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }

        fr.close();

    }

    public static void study07() throws IOException {

        //带参数的read()方法
        FileReader fr = new FileReader("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study06.txt");
        char[] buffer = new char[2];
        int len;
        //有参数的read()方法：将读取、解码、强转三步合并，将强转之后的数据放入到数组中
        while ((len = fr.read(buffer)) != -1) {
            System.out.print(new String(buffer, 0, len));
        }
        fr.close();
    }

    public static void study08() throws IOException {

        //这个构造方法中两个参数：文件地址 续写开关
        //第二个参数不写默认续写开关为 false 不能续写  传入true则打开续写开关可以续写
        FileWriter fw = new FileWriter("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study08.txt", true);

        char[] buffer = {25105, 29233, 20320};
        //在文件中写出是十进制整数在字符集上对应的字符
        fw.write(buffer);
        //同字节流一样，方法中也可以只写入数字，然后会先根据默认的字符集编码方式进行编码，将编码之后的数据写入文件中
        //在writer()中可以直接传入String类型字符串
        fw.write("我爱你");
        fw.close();

    }

    public static void study09() throws IOException {
        //利用缓冲流进行文件的拷贝

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study09_1.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study09_2.txt"));
        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }
        bos.close();
        bis.close();

        //同样可以使用使用byte类型的数组进行一次多个字节的读取
           /*
               byte[] bytes = new byte[1024];
               int len;
               while((len = bis.read(bytes))!=-1){
                   bos.write(bytes,0,len);
               }
               bos.close();
               bis.close();
           */
    }

    public static void study10() throws IOException {
        //使用字符缓冲流进行数据的读取和写入

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study09_1.txt"));
        String line = br.readLine();  //特有方法:一次读取一整行数据
        System.out.println(line);
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study10.txt"));
        bw.write("你的微笑，百度搜索不到");
        bw.newLine(); //特有方法:跨平台换行
        bw.write("所以我直接谷歌搜索");
        //关流,不然再在本地文件中不会写入,而写在了缓冲区中
        bw.close();

    }

    public static void study11() throws IOException, ClassNotFoundException {

        //序列化流和反序列化流
        //创建一个对象
        Yao y = new Yao("zhangSan", 23);
        //创建序列化对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study11.txt"));
        //将对象写入到本地文件
        oos.writeObject(y);
        //关流
        oos.close();
        //从本地文件中写出对象，创建反序列化流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study11.txt"));
        Yao result = (Yao) ois.readObject();//注意抛出异常,强制类型转换
        System.out.println(result);
        //关流
        ois.close();
    }

    public static void study12() throws IOException, ClassNotFoundException {

        //实现transient关键字的效果(瞬态关键字)
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study12.txt"));
        Yun y = new Yun("zhangSan", 23, "冰岛");
        oos.writeObject(y);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study12.txt"));
        Yun result = (Yun) ois.readObject();
        ois.close();
        System.out.println(result);//Yun{name = zhangSan, age = 23, address = null}
        //此时打印出来的address为null 表示没有被序列化,从而使得address为空

    }

    public static void study13() throws IOException {
        //压缩流
        //创建File对象表示要压缩的文件
        File src = new File("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study13.txt");
        //创建File对象表示压缩包的位置
        File dest = new File("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO");
        //调用压缩方法
        myZip(src, dest);
    }

    public static void myZip(File src, File dest) throws IOException {
        //创建压缩流关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(dest, "study13.zip")));
        //创建ZipEntry对象，表示压缩包里的每一个文件和文件夹
        ZipEntry entry = new ZipEntry("study13.txt");
        //将ZipEntry对象放入到压缩包中
        zos.putNextEntry(entry);
        //将src文件中的数据写入到压缩包中(这一步如果不写的话，压缩包中的文件中是没有内容的)
        FileInputStream fis = new FileInputStream(src);
        int b;
        while ((b = fis.read()) != -1) {
            zos.write(b);
        }
        zos.closeEntry();
        zos.close();
        fis.close();
    }

    public static void study14() throws IOException {
        //使用Commons-io常用工具包

        //复制文件的方法
        File Ori = new File("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study06.txt");
        File End = new File("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\study14.txt");
        FileUtils.copyFile(Ori, End);

        //复制文件夹的方法
           /*
            FileUtils.copyDirectory();
            FileUtils.copyDirectoryToDirectory();
           */
    }
}

//要实现类的本地序列化，就要让Javabean类实现Serializable接口
class Yao implements Serializable {


    @Serial
    private static final long serialVersionUID = -8907211688454545062L;

    private String name;
    private int age;


    public Yao() {
    }

    public Yao(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Yao{name = " + name + ", age = " + age + "}";
    }
}

class Yun implements Serializable {

    @Serial
    private static final long serialVersionUID = 4428849461758837320L;


    private String name;
    private int age;
    //创建瞬态成员变量，可以使这个成员属性不被序列化
    private transient String address;


    public Yun() {
    }

    public Yun(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Yun{name = " + name + ", age = " + age + ", address = " + address + "}";
    }
}