package pl.tlos.spock

import spock.lang.Specification

/**
 * Created by tomek on 11.05.17.
 */
class SpockTest extends Specification {

    def someTest() {

        when:
        def sum = a + b
        then:
        sum == c

        where:
        a | b | c
        1 | 2 | 3
        1 | 4 | 5
    }
}
