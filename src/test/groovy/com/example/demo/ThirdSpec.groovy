package com.example.demo

import spock.lang.Specification
import spock.lang.Subject


class ThirdSpec extends Specification {

    String randomness = UUID.randomUUID().toString()
    PersonRepository personRepository = Mock(PersonRepository)
    @Subject
    DefaultPersonService defaultPersonService = new DefaultPersonService(personRepository)

    def 'throws exception if person is not found'() {
        given:
        personRepository.findById(randomness) >> Optional.empty()

        when:
        defaultPersonService.getPersonById(randomness)

        then:
        def exception = thrown(NoSuchElementException)
        exception.message == "No value present"
    }

    def 'happy path scenario'() {
        given:
        1 * personRepository.findById(randomness) >> Optional.of(new Person(id: randomness))

        when:
        def retrievedPerson = defaultPersonService.getPersonById(randomness)

        then:
        noExceptionThrown() // ¯\_(ツ)_/¯
        retrievedPerson.id == randomness
    }

    def setupSpec() {

    }

    def cleanupSpec() {

    }

    def setup() {

    }

    def cleanup() {
    }
}
