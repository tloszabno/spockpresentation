package pl.tlos.junit;

import org.junit.Test;

/**
 * @author tlos
 */
public class XmlTest {

    @Test
    public void someTestWithXml(){
        String firstname = "Admin";
        String lastname = "Master";

        String someXml = "<people>\n" + "\t<person>\n" + "\t\t<name>\n" + "\t\t\t<firstname>"+firstname+"</firstname>\n"
                + "\t\t\t<lastname>"+lastname+"</lastname></name>\n" + "\t</person>\n" + "</people>";

        ///... screw it ...
    }

}
