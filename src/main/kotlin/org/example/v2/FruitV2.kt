package org.example.v2

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.GeneratedValue.Type.IDENTITY
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation
import io.micronaut.data.annotation.Relation.Kind.ONE_TO_MANY
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository


@MappedEntity("fruits-2")
data class FruitV2(
    val name: String,

    @Relation(ONE_TO_MANY, mappedBy = "bananas") // mapped by target collection name
    val bananas: MutableSet<BananaV2> = mutableSetOf(),
) {

    @Id
    @GeneratedValue(IDENTITY)
    var id: String = ""
}


@MongoRepository(databaseName = "test")
interface FruitRepoV2 : CrudRepository<FruitV2, String>