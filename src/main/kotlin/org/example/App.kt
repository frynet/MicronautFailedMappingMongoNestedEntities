package org.example

import io.micronaut.runtime.Micronaut


object App {

    @JvmStatic
    fun main(args: Array<String>) {

        Micronaut
            .build(*args)
            .banner(false)
            .start()
    }
}
