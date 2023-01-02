package org.example.v1

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.GeneratedValue.Type.IDENTITY
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation
import io.micronaut.data.annotation.Relation.Kind.ONE_TO_MANY
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository


@MappedEntity("fruits-1")
data class FruitV1(
    val name: String,

    @Relation(ONE_TO_MANY, mappedBy = "fruit") // mapped by target field in banana entity
    val bananas: MutableSet<BananaV1> = mutableSetOf(),
) {

    @Id
    @GeneratedValue(IDENTITY)
    var id: String = ""
}


@MongoRepository(databaseName = "test")
interface FruitRepoV1 : CrudRepository<FruitV1, String>