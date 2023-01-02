package org.example.v3

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.GeneratedValue.Type.IDENTITY
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation
import io.micronaut.data.annotation.Relation.Kind.ONE_TO_MANY
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository


@MappedEntity("fruits-3")
data class FruitV3(
    val name: String,

    @Relation(ONE_TO_MANY, mappedBy = "fruits") // mapped by current collection name >_<
    val bananas: MutableSet<BananaV3> = mutableSetOf(),
) {

    @Id
    @GeneratedValue(IDENTITY)
    var id: String = ""
}


@MongoRepository(databaseName = "test")
interface FruitRepoV3 : CrudRepository<FruitV3, String>