package pl.tlos.groovy

import org.assertj.core.api.BDDAssertions
import org.junit.Test

import static org.assertj.core.api.BDDAssertions.then


/**
 * @author tlos
 *
 */
class XmlTest {


    @Test
    void "should easily generate xml"(){
        def firstname = "Admin"
        def lastname = "Master"
        String xml  = """
        <people>
            <person>
                <name>
                    <firstname>${firstname}</firstname>
                    <lastname>${lastname}</lastname></name>
            </person>
        </people>
        """

        then(xml).isEqualTo('''
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
