package com.greetings.controllers

import com.greetings.controllers.routes.GreetingsControllerRoutes
import io.micronaut.context.annotation.Value
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class GreetingsControllerSpec extends Specification {

    @Inject
    @Client('/greetings')
    GreetingsControllerRoutes client

    @Value('${greetings.message}')
    String greetings

    void 'greetings controller'() {
        given:
        final String name = 'Carlos Eduardo'
        final HttpResponse<String> response = client.greetings(name)

        when:
        final String text = response.body()

        then:
        text == "${greetings}, ${name}!"
    }
}
