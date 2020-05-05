package justTest;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import org.junit.*;


import static org.junit.Assert.*;

/**
 * Author:YeJianPeng<br/>
 * Date:2020/05/05<br/>
 * Time:14:05<br/>
 */
public class junitTestTest {
    private  static  junitTest jTeat =new junitTest();
    @BeforeClass
    public  static void beforeClass(){
        System.out.println("@BeforeClass");
    }
    @AfterClass
    public  static void  afterClass(){
        System.out.println("@AfterClass");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("@Before");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("@After");
    }

    @Test
    public void getAdd() {
        System.out.println("--------------");
        System.out.println(jTeat.getAdd(3,4));
    }

    @Ignore
    public void reduce() {
        System.out.println("=====================================");
        System.out.println(jTeat.reduce(5,5));
    }

    @Ignore
    public void countS() {
        System.out.println("@Ignore");
    }
}