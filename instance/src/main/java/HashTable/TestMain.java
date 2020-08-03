package HashTable;

import java.util.HashSet;

/**
 * 以下是一个实例，在Hash表中，我们判断两个key值是否相同，主要是判断hashCode和equals()==true
 * 如果仅仅重写equals方法，那么以下这种情况的hashCode仍然不同，无法判断key值是否相同，但是这两个key值是完全一致的
 * 这就是为什么equals方法和hashCode方法需要同时重写
 */
class Test{
    int a;
    public Test(int a){
        this.a=a;
    }
}

public class TestMain {
    public static void main(String[] args){
        HashSet<Test> hashSet=new HashSet<>();
        Test test=new Test(1);
        Test test1=new Test(1);
        System.out.println(test+" "+test1);
        System.out.println(test.hashCode()+" "+test1.hashCode());
        System.out.println(test.equals(test1));

        hashSet.add(test);
        hashSet.add(test1);
        //这两个相同的Test类型都被加入了HashSet，这不是我们期望的，我们需要重写equals和hashCode方法
        for(Test t:hashSet){
            System.out.println(t);
        }
        /*
         * 这才是我们期望的，key相同时只能进行替换原来的<key,value>，这才是hash表的初衷
         */
        HashSet<Integer> hashSet1=new HashSet<>();
        hashSet1.add(1);
        hashSet1.add(1);
        for(Integer t:hashSet1){
            System.out.println(t);
        }
    }
}
