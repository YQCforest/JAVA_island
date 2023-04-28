package API;

/**
 * Math类 关于数学计算的工具类
 * 所有的方法都是静态的
 */

public class My_math {
    public static void main(String[] args) {

        //abs 绝对值
        System.out.println(Math.abs(-88));
        System.out.println(Math.abs(90));
        System.out.println("----------------");
        /*BUG:对于超出类型范围的数字，abs会无法显示正确结果
        解决方法:
        System.out.println(Math.absExact(-2147483648));  程序报错 在底层中是一个判断*/

        //ceil 向上取整
        System.out.println(Math.ceil(12.45));
        System.out.println(Math.ceil(-12.45));
        System.out.println("----------------");

        //floor 向下取整
        System.out.println(Math.floor(12.67));
        System.out.println(Math.floor(-12.67));
        System.out.println("----------------");

        //round 四舍五入
        System.out.println(Math.round(23.45));
        System.out.println(Math.round(23.55));
        System.out.println(Math.round(-23.55));
        System.out.println(Math.round(-23.45));
        System.out.println("----------------");

        //max 获取较大值 min 获取较小值
        System.out.println(Math.max(23, 34));
        System.out.println(Math.min(23, 34));
        System.out.println("----------------");

        //pow 幂
        System.out.println(Math.pow(2, 3));
        //当第二个参数是0~1就是开根号
        System.out.println(Math.pow(4, 0.5));
        //当第二个参数是负数就是变为其倒数的幂
        System.out.println(Math.pow(2, -2));
    }
}