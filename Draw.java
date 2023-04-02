import java.util.Random;

public class Draw {
    public static void main(String[] args) {
        Random r = new Random();
        int c1 = r.nextInt(34);
        int c2 = r.nextInt(34);
        String[] arr = {"白雯旭","陈志源","邓添宁","桂腾浩","侯俊杰","黄嘉达","黄宗锋","金承豪","李玟萱","廖孔旗","刘善益","刘绎","潘鑫岳","祁晨锋",
                "滕恩长","仝晏绮","王岩","王奕为","吴黄浩轩","武桐含","徐义超","徐自鹏","杨轲","杨旻","姚鹏运","姚扬","俞华军","张佳艺",
                "张恺颖","赵一凡","周宇豪","李向洋","林智瀚","戴浩源",};
        if(c1==c2){
            c1 = r.nextInt(34);
        }else{
            System.out.println(arr[c1]);
            System.out.println(arr[c2]);
        }
    }
}
