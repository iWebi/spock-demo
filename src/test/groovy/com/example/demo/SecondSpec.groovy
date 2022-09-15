package com.example.demo

import spock.lang.Specification
import spock.lang.Subject

class SecondSpec extends Specification {

    @Subject
    Person person = new Person()

    def 'hasValidEmail returns #expectedValue for #email'() {
        given:
        person.email = email

        when:
        boolean isValid = person.hasValidEmail()

        then:
        isValid == expectedValue

        where:
        email                  | expectedValue
        "foo"                  | false
        "1333@"                | false
        "@bar.com"             | false
        "foo@bar.com"          | true
        "1323_foo_fds@bar.com" | true
    }

    def 'hasValidEmail returns true for all valid emails'() {
        given:
        person.email = email

        when:
        boolean isValid = person.hasValidEmail()

        then:
        isValid == true

        where:
        email << ["foo@bar.com", "1323_foo_fdfdfds@bar.com", "_____@f.com", "a@b.com"]
    }
}
