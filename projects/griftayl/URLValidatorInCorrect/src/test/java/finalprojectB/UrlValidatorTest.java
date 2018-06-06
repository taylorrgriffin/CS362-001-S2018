package finalprojectB;
import junit.framework.TestCase;

public class UrlValidatorTest extends TestCase {

  public UrlValidatorTest(String testName) {
    super(testName);
  }

  public void testManualTest() {
    // manual testing
    UrlValidator urlValidator = new UrlValidator();
    System.out.println("");
    System.out.println("=====Manual Tests=====");
    System.out.println("");
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
  // first partition testing
  }

  public void testYourSecondPartition(){
  // second partition testing
  }
  //You can create more test cases for your Partitions if you need to
  public void testIsValid() {
	// programming based testing
  }
}
