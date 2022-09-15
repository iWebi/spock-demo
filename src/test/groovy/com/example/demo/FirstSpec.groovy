package com.example.demo

import spock.lang.Specification


class FirstSpec extends Specification {

    def 'hello spock world'() {
        expect:
        1 == 1
    }

    def 'behavior driven labels demo'() {
        given:
        int junit = 1
        int spock = 1

        when: 'If I promote more spock'
        spock = goSpockGo(spock)

        then: 'spock wins'
        spock > junit

        and: 'junit stays at the same level'
        junit == 1
    }


    def goSpockGo(int spock) {
        spock * 5
    }
}
