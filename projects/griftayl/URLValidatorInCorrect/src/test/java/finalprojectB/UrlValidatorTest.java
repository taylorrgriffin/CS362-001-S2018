package finalprojectB;
import junit.framework.TestCase;
import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

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

  public static int RandomSelectConstructor(Random random) {
    /*
      Options:
      0 : UrlValidator()
      1 : UrlValidator(String[] schemes)
      2 : UrlValidator(long options)
      3 : UrlValidator(String[] schemes, RegexValidator authorityValidator, long options)

      x : UrlValidator(String[] schemes, long options)
      x : UrlValidator(RegexValidator authorityValidator, long options)

    */
    int[] constructors = new int[] {0,1,2,3};
		int n = random.nextInt(constructors.length);
		return constructors[n];
  }

  public static int RandomSelectParts(Random random) {
    int[] parts = new int[] {0,1,2,3,4,5};
    int n = random.nextInt(parts.length);
    return parts[n];
  }

  public static String RandomSelectExtension(Random random) {
    String[] exts = new String[] {"com","net","edu","html"};
    int n = random.nextInt(exts.length);
    return exts[n];
  }

  public static String AssembleUrl(String scheme, String ext, int parts) {
    String path = "";
    if (parts == 0) {
      path = scheme + ":";
    }
    else if (parts == 1) {
      path = scheme + ":" + "//";
    }
    else if (parts == 2) {
      path = scheme + ":" + "//" + "domain";
    }
    else if (parts == 3) {
      path = scheme + ":" + "//" + "domain" + "." + ext;
    }
    else if (parts == 4) {
      path = scheme + ":" + "//" + "domain" + "." + ext + "/extension";
    }
    return path;
  }

  public void testIsValid() {
	   // programming based testing
    System.out.println("");
    System.out.println("=====Programming-based Testing=====");
    System.out.println("");
    int i;
    String ext;
    int cons;
    int parts;
    String scheme;
    String url;
    UrlValidator[] urlValidators = new UrlValidator[100];
    for (i=0;i<100;i++) {
      System.out.print("Test " + i + "\t");
      Random random = new Random(System.currentTimeMillis());
      scheme = RandomSelectScheme(random);
      cons = RandomSelectConstructor(random);
      ext = RandomSelectExtension(random);
      parts = RandomSelectParts(random);
      url = AssembleUrl(scheme, ext, parts);
      if (cons == 0) {
        urlValidators[i] = new UrlValidator();
      }
      else if (cons == 1) {
        urlValidators[i] = new UrlValidator(null);
      }
      else if (cons == 2) {
        urlValidators[i] = new UrlValidator(1 << 1 + 1 << 2);
      }
      else if (cons == 3) {
        urlValidators[i] = new UrlValidator(null,null,1 << 1 + 1 << 2);
      }
      System.out.print(" valid: " + urlValidators[i].isValid(url));
      System.out.print(" cons: " + cons + ",");
      System.out.print(" scheme: " + scheme + ",\t");
      System.out.println(" url: " + url);
    }
    System.out.println("");
    System.out.println("=====Done Testing=====");
    System.out.println("");
  }
}
