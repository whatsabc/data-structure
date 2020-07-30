package Character;

/**
 * @author Jianshu
 * @time 20200730
 * KMP的详细解释参见本包下的KMP详解.md文件
 */
public class KMP {
    public static int[] getNext(String p){
        int i=0;
        int j=-1;
        int[] next=new int[p.length()+1];//next数组索引从1开始
        next[0]=-1;//无其他含义，只是为了编程方便
        while(i<p.length()){
            if(j==-1||p.charAt(i)==p.charAt(j)){
                i++;
                j++;
                next[i]=j;
            }
            else{
                j=next[j];
            }
        }
        return next;
    }

    public static int kmp(String s,String p){
        int[] next=getNext(p);
        int i=0;//s的下标
        int j=0;//p的下标
        while(i<s.length()&&j<p.length()){
            if(j==-1||s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }
            else{
                j=next[j];
            }
        }
        if(j==p.length()){
            return i-j;
        }
        return -1;
    }
}
