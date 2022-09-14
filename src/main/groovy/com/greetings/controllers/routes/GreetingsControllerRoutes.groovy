package com.greetings.controllers.routes

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get

interface GreetingsControllerRoutes {

    @Get('/{name}')
    HttpResponse<String> greetings(final String name)

}