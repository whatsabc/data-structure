package Character;

/**
 * @author Jianshu
 * @time 20200730
 */
public class KMPMain {
    public static void main(String[] args){
        String s=new String("bbcdcabababcaadcdabcdabde");
        String p=new String("abababca");//模式串
        int index=KMP.kmp(s,p);
        System.out.println("KMP算法匹配到的索引是："+index);//本实例中应该输出5
    }
}
