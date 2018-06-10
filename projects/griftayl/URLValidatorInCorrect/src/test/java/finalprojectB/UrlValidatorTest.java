package finalprojectB;
import junit.framework.TestCase;
import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

public class UrlValidatorTest extends TestCase {

  public UrlValidatorTest(String testName) {
    super(testName);
  }

  public void testManualTest() {
    // manual testing
    UrlValidator urlValidator = new UrlValidator(null,null,1 << 1 + 1 << 2);
    urlValidator.getInstance();
    System.out.println("");
    System.out.println("=====Manual Tests=====");
    System.out.println("");
    System.out.print("testing: null,\t \t \t\tvalid: ");
    System.out.println(urlValidator.isValid(null));
    System.out.print("testing: google,\t \t \tvalid: ");
    System.out.println(urlValidator.isValid("google"));
    System.out.print("testing: google.net,\t \t \tvalid: ");
    System.out.println(urlValidator.isValid("google.net"));
    System.out.print("testing: www.google.com,\t \tvalid: ");
    System.out.println(urlValidator.isValid("www.google.com"));
    System.out.print("testing: https://www.google.com/,\tvalid: ");
    System.out.println(urlValidator.isValid("https://www.google.com/"));
    System.out.println("");
  }
  public void testYourFirstPartition() {
    // first partition testing (valid)
    UrlValidator urlValidator = new UrlValidator(null,null,1 << 1 + 1 << 2);
    System.out.println("");
    System.out.println("=====First Domain Partion (invalid URLs)=====");
    System.out.println("");
    // set 1
    System.out.print("Testing :,\t\t\t\tvalid: ");
    System.out.println(urlValidator.isValid(":"));
    assertFalse(urlValidator.isValid(":"));
    System.out.print("Testing ://,\t\t\t\tvalid: ");
    System.out.println(urlValidator.isValid("://"));
    assertFalse(urlValidator.isValid("://"));
    System.out.print("Testing https://,\t\t\tvalid: ");
    System.out.println(urlValidator.isValid(":https//"));
    assertFalse(urlValidator.isValid("https://"));
    System.out.print("Testing http://,\t\t\tvalid: ");
    System.out.println(urlValidator.isValid(":http//"));
    assertFalse(urlValidator.isValid("http://"));
    System.out.print("Testing ftp://,\t\t\t\tvalid: ");
    System.out.println(urlValidator.isValid(":ftp//"));
    assertFalse(urlValidator.isValid("ftp://"));
    // set 2
    System.out.print("Testing :goo,\t\t\t\tvalid: ");
    System.out.println(urlValidator.isValid(":goo"));
    assertFalse(urlValidator.isValid(":goo"));
    System.out.print("Testing ://goo,\t\t\t\tvalid: ");
    System.out.println(urlValidator.isValid("://goo"));
    assertFalse(urlValidator.isValid("://goo"));
    System.out.print("Testing https://goo,\t\t\tvalid: ");
    System.out.println(urlValidator.isValid("https://goo"));
    assertFalse(urlValidator.isValid("https://goo"));
    System.out.print("Testing http://goo,\t\t\tvalid: ");
    System.out.println(urlValidator.isValid("http://goo"));
    assertFalse(urlValidator.isValid("http://goo"));
    System.out.print("Testing ftp://goo,\t\t\tvalid: ");
    System.out.println(urlValidator.isValid("ftp://goo"));
    assertFalse(urlValidator.isValid("ftp://goo"));
    // set 3
    System.out.print("Testing :goo.not:,\t\t\tvalid: ");
    System.out.println(urlValidator.isValid(":goo.not:"));
    assertFalse(urlValidator.isValid(":goo.not:"));
    System.out.print("Testing ://goo.net.,\t\t\tvalid: ");
    System.out.println(urlValidator.isValid("://goo.net."));
    assertFalse(urlValidator.isValid("://goo.net."));
    System.out.print("Testing https://goo..nat,\t\tvalid: ");
    System.out.println(urlValidator.isValid("https://goo..nat"));
    assertFalse(urlValidator.isValid("https://goo..nat"));
    System.out.print("Testing http://goo..,\t\t\tvalid: ");
    System.out.println(urlValidator.isValid("http://goo.."));
    assertFalse(urlValidator.isValid("http://goo.."));
    System.out.print("Testing ftp://goo.,\t\t\tvalid: ");
    System.out.println(urlValidator.isValid("ftp://goo."));
    assertFalse(urlValidator.isValid("ftp://goo."));
    // set 4
    System.out.print("Testing :goo.not:/test1,\t\tvalid: ");
    System.out.println(urlValidator.isValid(":goo.not:/test1"));
    assertFalse(urlValidator.isValid(":goo.not:/test1"));
    System.out.print("Testing ://goo.net./test2,\t\tvalid: ");
    System.out.println(urlValidator.isValid("://goo.net./test2"));
    assertFalse(urlValidator.isValid("://goo.net./test2"));
    System.out.print("Testing https://goo..nat/test3.,\tvalid: ");
    System.out.println(urlValidator.isValid("https://goo..nat/test3."));
    assertFalse(urlValidator.isValid("https://goo..nat/test3."));
    System.out.print("Testing ftp://goo./test5:.,\t\tvalid: ");
    System.out.println(urlValidator.isValid("ftp://goo./test5:."));
    assertFalse(urlValidator.isValid("ftp://goo./test5:."));
    // set 5
    System.out.print("Testing :goo.not:/test1=?layout:....,\tvalid: ");
    System.out.println(urlValidator.isValid(":goo.not:/test1=?layout:...."));
    assertFalse(urlValidator.isValid(":goo.not:/test1=?layout:...."));
    System.out.print("Testing ://goo.net./test2=:.,\t\tvalid: ");
    System.out.println(urlValidator.isValid("://goo.net./test2=:."));
    assertFalse(urlValidator.isValid("://goo.net./test2=:."));
    System.out.print("Testing https://goo..nat/test3.=.,\tvalid: ");
    System.out.println(urlValidator.isValid("https://goo..nat/test3.=."));
    assertFalse(urlValidator.isValid("https://goo..nat/test3.=."));
    System.out.print("Testing http://goo../test4..=?,\t\tvalid: ");
    System.out.println(urlValidator.isValid("http://goo../test4..=?"));
    assertFalse(urlValidator.isValid("http://goo../test4..=?"));
    System.out.print("Testing ftp://goo./test5:..?:.,\t\tvalid: ");
    System.out.println(urlValidator.isValid("ftp://goo./test5:..?:."));
    assertFalse(urlValidator.isValid("ftp://goo./test5:..?:."));
    //
  }

  public void testYourSecondPartition() {
    // second partition testing (invalid)
    UrlValidator urlValidator = new UrlValidator(null,null,1 << 1 + 1 << 2);
    System.out.println("");
    System.out.println("=====Second Domain Partion (valid URLs)=====");
    System.out.println("");
  //-----
  //https
    System.out.print("Testing https://google.com,\t\t\tvalid: ");
    System.out.println(urlValidator.isValid("https://google.com"));
  //assertTrue(urlValidator.isValid("https://google.com"));
    System.out.print("Testing https://google.com/,\t\t\tvalid: ");
    System.out.println(urlValidator.isValid("https://google.com/"));
  //assertTrue(urlValidator.isValid("https://google.com/"));
    System.out.print("Testing https://google.com/test1/,\t\tvalid: ");
    System.out.println(urlValidator.isValid("https://google.com/test1/"));
  //assertTrue(urlValidator.isValid("https://google.com/test1"));
    System.out.print("Testing https://google.com/test1+layout=true/,\tvalid: ");
    System.out.println(urlValidator.isValid("https://google.com/test1+layout=true/"));
  //assertTrue(urlValidator.isValid("https://google.com/test1+layout=true"));
  //----
  //http
    System.out.print("Testing http://google.com,\t\t\tvalid: ");
    System.out.println(urlValidator.isValid("http://google.com"));
  //assertTrue(urlValidator.isValid("http://google.com"));
    System.out.print("Testing http://google.com/,\t\t\tvalid: ");
    System.out.println(urlValidator.isValid("http://google.com/"));
  //assertTrue(urlValidator.isValid("http://google.com/"));
    System.out.print("Testing http://google.com/test1/,\t\tvalid: ");
    System.out.println(urlValidator.isValid("http://google.com/test1/"));
  //assertTrue(urlValidator.isValid("http://google.com/test1"));
    System.out.print("Testing http://google.com/test1+layout=true/,\tvalid: ");
    System.out.println(urlValidator.isValid("http://google.com/test1+layout=true/"));
  //assertTrue(urlValidator.isValid("http://google.com/test1+layout=true"));
  //---
  //ftp
    System.out.print("Testing ftp://google.com,\t\t\tvalid: ");
    System.out.println(urlValidator.isValid("ftp://google.com"));
  //assertTrue(urlValidator.isValid("ftp://google.com"));
    System.out.print("Testing ftp://google.com/,\t\t\tvalid: ");
    System.out.println(urlValidator.isValid("ftp://google.com/"));
  //assertTrue(urlValidator.isValid("ftp://google.com/"));
    System.out.print("Testing ftp://google.com/test1/,\t\tvalid: ");
    System.out.println(urlValidator.isValid("ftp://google.com/test1/"));
  //assertTrue(urlValidator.isValid("ftp://google.com/test1"));
    System.out.print("Testing ftp://google.com/test1+layout=true/,\tvalid: ");
    System.out.println(urlValidator.isValid("ftp://google.com/test1+layout=true/"));
  //assertTrue(urlValidator.isValid("ftp://google.com/test1+layout=true"));
  }

  public static String RandomSelectScheme(Random random) {
    String[] schemes = new String[] {"http","https","ftp"};
		int n = random.nextInt(schemes.length);
		return schemes[n];
  }

  public static String RandomSelectConstructor(Random random) {
    /*
      Options:
      0 : UrlValidator()
      1 : UrlValidator(String[] schemes)
      2 : UrlValidator(long options)
      3 : UrlValidator(String[] schemes, long options)
      4 : UrlValidator(RegexValidator authorityValidator, long options)
      5 : UrlValidator(String[] schemes, RegexValidator authorityValidator, long options)
    */
    int[] constructors = new int[] {0,1,2,3,4,5};
		int n = random.nextInt(schemes.length);
		return schemes[n];
  }

  public void testIsValid() {
	// programming based testing
  System.out.println("");
  System.out.println("=====Programming-based Testing=====");
  System.out.println("");
    int i;
    int index;
    int cons;
    UrlVaidator[] urlValidators;
    for (i=0;i<50;i++) {
      cons = RandomSelectConstructor();
      UrlValidator urlValidator = new UrlValidator(null,null,1 << 1 + 1 << 2);
      UrlVaidators[i] = new urlValidator
    }
    System.out.println("");
    System.out.println("=====Done Testing=====");
    System.out.println("");
  }
}
