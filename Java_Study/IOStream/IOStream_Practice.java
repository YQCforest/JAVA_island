package IO;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;

public class IOStream_Practice {
    public static void main(String[] args) throws IOException {
        practice01();
        practice02();
        practice03();
        practice04();
    }

    public static void practice01() throws IOException {
        //文件加密
        //异或加密原则
        //原理:一个数据对另一个相同的数据进行两次异或得到的结果一样
        //首先关联未加密文件
        FileInputStream fis = new FileInputStream("C:\\Users\\10409\\Desktop\\memory.jpg");
        //再关联一个新的，将加密后文件进行拷贝特殊处理
        FileOutputStream fos = new FileOutputStream("C:\\Users\\10409\\Desktop\\memory_my.jpg");
        //下面就是对文件的拷贝，只是对拷贝进行一些特殊处理
        int m;
        while ((m = fis.read()) != -1) {
            fos.write(m ^ 2);
        }
        fos.close();
        fis.close();
    }

    public static void practice02() throws IOException {
        //将文件中的数据进行排序
        //原来文件中的数据是:2-8-7-1-9-4
        //要得到结果为:1-2-4-7-8-9

        //将文件中的数据读取出来
        FileReader fr = new FileReader("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\practice02.txt");
        //创建StringBuilder 对象对读出的数据进行拼接后的再进行操作
        StringBuilder sb = new StringBuilder();
        //读出数据
        int ch;
        while ((ch = fr.read()) != -1) {
            //将每次读出的数据拼接到sb中
            sb.append((char) ch);
        }
        //读取完毕后关流
        fr.close();

        //排序
        //使用stream流进行操作
        Integer[] arr = Arrays.stream(sb.toString()
                        .split("-"))       //首先将sb使用toString()方法转换成字符串,并以“-”分割,得到每一个具体的数据
                .map(Integer::parseInt)   //然后使用map()方法进行数据类型的转换,转换成Integer类型,这里采用方法引用的方法
                .sorted()                 //再调用sorted()方法对数据进行排序,默认从小到大
                .toArray(Integer[]::new); //最后使用toArray()收集流中的数据并放入到数组中,(采用的还是方法引用的方法创建Integer类型的数组)
        //写出
        FileWriter fw = new FileWriter("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\practice02.txt");
        //将上一步排序中的数组进行替换操作,实现到达我们写出时候得到的结果样式的需要
        String s = Arrays.toString(arr).replace(", ", "-");
        String result = s.substring(1, s.length() - 1);
        //直接将处理完的result写出到文件中
        fw.write(result);
        //写出完后关流
        fw.close();

    }

    public static void practice03() throws IOException {

        //控制软件运行次数，当超过三次就提示免费使用次数结束
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\practice03.txt"));
        String line = br.readLine();
        int count = Integer.parseInt(line);
        count++;
        if (count <= 3) {
            System.out.println("这是你第" + count + "次免费使用,还剩下" + (3 - count) + "次");
        } else {
            System.out.println("您的免费使用次数已经结束!");
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\practice03.txt"));
        bw.write(count + "");//在后面加上""是为了让count写入文件的时候变成字符串类型，如果直接写入的话会是int类型，从而使写入的数据变成这个整型在字符表上对应的字符
        bw.close();
        br.close();


    }

    public static void practice04() throws IOException {
        //关于properties

        FileOutputStream fos = new FileOutputStream("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\practice04.txt");
        Properties prop = new Properties();
        prop.put("111", "aaa");
        prop.put("222", "bbb");
        prop.put("333", "ccc");
        prop.put("444", "ddd");

        //利用properties中的特有方法将集合中的数据写入到本地文件中
        prop.store(fos, "Test");
        fos.close();

        //利用properties中的特有方法读取本地文件中的数据
        Properties prop2 = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\10409\\Desktop\\[]\\JAVA\\Test_2023_4_28\\src\\IO\\practice04.txt");
        prop2.load(fis);
        System.out.println(prop2);

    }
}
