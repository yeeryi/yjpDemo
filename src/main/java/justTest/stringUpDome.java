package justTest;

/**
 * Author:YeJianPeng<br/>
 * Date:2020/05/05<br/>
 * Time:19:50<br/>
 */
public class stringUpDome {
    /*
     * string 字符串是线程安全的
     * StringBuffer 可变字符串，执行效率略低，线程安全
     * StringBuilder 可变字符串，执行效率高，线程不安全
     * StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。
     * 由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。
     * 然而在要求线程安全时，则必须用 StringBuffer。
     * 可变字符串这俩老是记不住，怎么破?
     * */
    public static void main(String[] args) throws InterruptedException {
        //到底是谁更快？
        int count = 10;//100000--500000--1000000--10000000-15000000-20000000
        String bStr ="abcdefg";
        testStringBuilder(count,bStr);//9--27--55--393-727 -752
        testStringBuffer(count,bStr);//18--31--69--696-1253 -1683
        //看来还是stringbuffer略输一筹
        /*
        * StringBuilder是线程不安全的？
        * 证明就需要多线程出场了
        * stringBuilderSafe();
        * 运行结果偶尔小于10000，确实是有问题，纳闷这么狗东西问题到底出在哪了呢？
        * 为什么StringBuffer他就安全呢？
        * 一看他append方法就明白了，synchronized，同步的，惊不惊悚？意不意外？
        * public synchronized StringBuffer append(Object obj){}
        * public StringBuilder append(String str){}
        * */
        stringBuilderSafe();

    }
    public static void stringBuilderSafe() throws InterruptedException{
        final StringBuilder stringBuilder =new StringBuilder();
        for (int i = 0; i < 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++){
                        stringBuilder.append("a");
                    }
                }
            }).start();
        }
        Thread.sleep(100);
        System.out.println(stringBuilder.length());//结果偶尔会小于10000
    }
    public  static void testStringBuilder(int count,String str){
        StringBuilder sBder =new StringBuilder();
        long bTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            sBder.append(str);
        }
        long eTime = System.currentTimeMillis();
        System.out.println("-----------------");
        System.out.println(eTime-bTime);

    }
    public  static void testStringBuffer(int count,String str){
        StringBuffer sBfer =new StringBuffer();
        long bTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            sBfer.append(str);
        }
        long eTime = System.currentTimeMillis();
        System.out.println("==============");
        System.out.println(eTime-bTime);

    }
}
