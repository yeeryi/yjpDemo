package justTest;

/**
 * Author:YeJianPeng<br/>
 * Date:2020/05/05<br/>
 * Time:8:58<br/>
 */
public class stringTest {
    public static void main(String[] args) {
        System.out.println("*************************************************************");
        System.out.println("string类属于"+(new String()).getClass().getPackage().getName()+"包");
        /*
        == 可以比较基本数据类型，也可以比较引用数据类型，基本数据类型比较的是值，引用数据类型比较的是内存地址
        equals 比较的是引用数据类型
        1.如果没有重写object的equals方法，那么和==比较引用类型时一样，都是比较内存地址
        2.重写equals后，改方法比较的是值
        ^^new这个关键字，毫无疑问会在堆中分配内存
        ^^单独（注意是单独）使用引号来创建字符串的方式，字符串都是常量，在编译期已经确定存储在常量池中了。
        常量池：就是放常量的地方，他存在堆内存中，他有啥锤子用？
        每当代码创建字符串常量时，JVM会首先检查字符串常量池。
        如果字符串已经存在池中，就返回池中的实例引用。
        如果字符串不在池中，就会实例化一个字符串并放到池中。
        很显然就是存在常量池中的字符不需要再创建了，这就节省了时间和空间等资源，而且常量池中资源不会被gc。
        */
        System.out.println("*************************************************************");
        String a1 = "asd";
        String a2 = "asd";
        String a3 = new String("asd");
        System.out.println(a1==a2);//true
        System.out.println(a1.equals(a2));//true
        System.out.println(a1==a3);//false
        System.out.println(a3.equals(a2));//true
        /*
         * string 是字符串，字符串属于常量，存在常量池中，
         * “asd”在a1已经创建于常量池中，a2引用的也是常量池中的asd，所以a1==a2
         * String类重写了equals方法，比较的是属性值，所以也是true
         * String a3 = new String("asd");
         * 首先在常量池中创建对象asd，如果有就不创建了啊
         * new的时候在堆内存中创建一个asd的副本，同时将这快内存的地址赋值给a3
         * 这个时候 常量池中有一个对象，堆内存中也有一个对象
         * a3指向的其实是堆内存对象的内存地址。
         * */
        System.out.println("*************************************************************");
        String b1 ="ab";
        String b2 ="abc";
        String b3 = b1+"c";
        System.out.println(b2==b3);//false
        System.out.println(b2.equals(b3));//true
        /*
        *这个就很神奇了
        * 毫无疑问b1，b2在常量池中
        * 但是b3就不是了，这属于字符串 串联，b1+"c"的时候会先在堆中创建StringBuilder对象，
        * 然后使用StringBuilder的append方法拼接成‘abc’，
        * 拼接完事再调用StringBuilder的toString()方法，就是下面这货
        * return new String(value, 0, count);
        * 很明显，它又在堆中new了一个string，b3的值指向的是这个string的内存地址
        * */
        System.out.println("*************************************************************");
        String c1 ="abc";
        final String c2 ="ab";
        String c3 =c2 +"c";
        String c4 ="c";
        String c5 =c2 +c4;
        System.out.println(c1==c3);//true
        System.out.println(c1.equals(c3));//true
        System.out.println(c1==c5);//false
        /*
        *因为c2有final修饰
        *c2 +"c"在编译期间就会优化成 “ab”+“c”
        *而c2 +c4只能优化为“ab”+c4,还是会创建StringBuilder然后append然后再toString
        *跟上面String b3 = b1+"c"一样了.
        * */

        System.out.println("*************************************************************");
        String d1="abc";
        String d2="abc";
        String d3="abcde";
        System.out.println(d1.compareTo(d2));
        System.out.println(d1.compareTo(d3));
        System.out.println(d3.compareTo(d1));
        /*
         *compareTo
         *返回值是整型，它是先比较对应字符的大小(ASCII码顺序)
         *返回的是第一个不相同字母的ASCII差值，都相等返回0
         * equalsIgnoreCase跟compareTo类似，只是都转换为大写然后比较
         * */
        System.out.println("*************************************************************");
        String bStr ="strToByte";
        byte[] bytes = bStr.getBytes();//转为byte了
        String bStr2 = new String(bytes);//又转回来了
        System.out.println(bStr2);
        String [] sArr = bStr.split("t");//转为string数组

        System.out.println("*************************************************************");
        String e1 = new StringBuilder("九十九").append("大洋").toString();
        System.out.println(e1.intern() == e1);
        /*
        *intern()
        * 这个已懵圈，也不知道实战中有啥用0.0
        * JDK 1.7后，intern方法会先去查询常量池中是否有已经存在，如果存在，则返回常量池中的引用，如果在常量池找不到对应的字符串，
        * 则不会再将字符串拷贝到常量池（JDK1.6会），而只是在常量池中生成一个对原字符串的引用。
        * 简单的说，就是往常量池放的东西变了：原来在常量池中找不到时，复制一个副本放到常量池，1.7后则是将在堆上的地址引用复制到常量池。
        * JDK 1.7后 ,常量池被从方法区中移出来到了堆中。
        * */
        System.out.println("*************************************************************");
        String str = "aBcde";
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
        System.out.println(str.isEmpty());
        System.out.println(str.endsWith("de"));
        System.out.println(str.startsWith("aB"));//true
        System.out.println(str.startsWith("ab"));//false看来是区分大小写的
        System.out.println(str.startsWith("aBcdeeee"));//false很显然
        /*
         * 就这吧，以后再加点，true啊false没意思
         * */



    }
}
