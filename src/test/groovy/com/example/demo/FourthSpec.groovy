package com.example.demo

import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Import
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification


@ContextConfiguration
@Import(DefaultPersonService)
class FourthSpec extends Specification {

    String randomness = UUID.randomUUID().toString()

    @SpringBean
    PersonRepository personRepository = Mock(PersonRepository)

    @Autowired
    PersonService personService

    def 'happy path scenario'() {
        given:
        1 * personRepository.findById(randomness) >> Optional.of(new Person(id: randomness))

        when:
        def retrievedPerson = personService.getPersonById(randomness)

        then:
        noExceptionThrown() // ¯\_(ツ)_/¯
        retrievedPerson.id == randomness
    }

    def 'throws exception if person is not found'() {
        given:
        personRepository.findById(randomness) >> Optional.empty()

        when:
        personService.getPersonById(randomness)

        then:
        thrown(NoSuchElementException)
    }
}
