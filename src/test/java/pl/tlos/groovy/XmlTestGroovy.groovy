package pl.tlos.groovy

import org.assertj.core.api.BDDAssertions
import org.junit.Test

import static org.assertj.core.api.BDDAssertions.then


/**
 * @author tlos
 *
 */
class XmlTestGroovy {


    @Test
    void "see how easy is to write xmls in groovy!"(){
        def firstname = "Admin"
        def lastname = "Master"
        String expectedXmlFromGui  = """
        <people>
            <person>
                <name>
                    <firstname>${firstname}</firstname>
                    <lastname>${lastname}</lastname></name>
            </person>
        </people>
        """

        then(expectedXmlFromGui).isEqualTo('''
        <people>
            <person>
                <name>
                    <firstname>Admin</firstname>
                    <lastname>Master</lastname></name>
            </person>
        </people>
        ''')
    }
}
