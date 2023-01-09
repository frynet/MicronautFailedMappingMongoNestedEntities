package org.example

import jakarta.inject.Singleton
import org.example.v1.BananaRepoV1
import org.example.v1.BananaV1
import org.example.v1.FruitRepoV1
import org.example.v1.FruitV1
import org.example.v2.BananaRepoV2
import org.example.v2.BananaV2
import org.example.v2.FruitRepoV2
import org.example.v2.FruitV2
import org.example.v3.BananaRepoV3
import org.example.v3.BananaV3
import org.example.v3.FruitRepoV3
import org.example.v3.FruitV3


@Singleton
class TestService(
    private val fruitRepoV1: FruitRepoV1,
    private val bananaRepoV1: BananaRepoV1,
    private val fruitRepoV2: FruitRepoV2,
    private val bananaRepoV2: BananaRepoV2,
    private val fruitRepoV3: FruitRepoV3,
    private val bananaRepoV3: BananaRepoV3,
) {

    fun createFruitV1() {
        val fruit = fruitRepoV1.save(FruitV1("123", emptyList()))

        val bananas = setOf(
            bananaRepoV1.save(BananaV1("1", fruit)),
            bananaRepoV1.save(BananaV1("2", fruit)),
            bananaRepoV1.save(BananaV1("3", fruit)),
        )

        fruit.bananas.addAll(bananas)
        fruitRepoV1.update(fruit)
    }

    fun createFruitV2() {

        val bananas = listOf(
            bananaRepoV2.save(BananaV2("1")),
            bananaRepoV2.save(BananaV2("2")),
            bananaRepoV2.save(BananaV2("3")),
        )

        fruitRepoV2.save(FruitV2("123", bananas))
    }

    fun createFruitV3() {

        val bananas = listOf(
            bananaRepoV3.save(BananaV3("1")),
            bananaRepoV3.save(BananaV3("2")),
            bananaRepoV3.save(BananaV3("3")),
        )

        fruitRepoV3.save(FruitV3("123", bananas))
    }
}