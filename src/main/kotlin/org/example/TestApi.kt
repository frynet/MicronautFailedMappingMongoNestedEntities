package org.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.swagger.v3.oas.annotations.tags.Tag


@Controller("/test")
@Tag(name = "test")
class TestApi(
    private val service: TestService
) {

    @Get
    fun test() {
        with(service) {
            createFruitV1()
            createFruitV2()
            createFruitV3()
        }
    }
}