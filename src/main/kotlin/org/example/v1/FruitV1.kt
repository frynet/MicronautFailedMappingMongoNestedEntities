package org.example.v1

import io.micronaut.data.annotation.*
import io.micronaut.data.annotation.GeneratedValue.Type.IDENTITY
import io.micronaut.data.annotation.Relation.Cascade.ALL
import io.micronaut.data.annotation.Relation.Kind.ONE_TO_MANY
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository


@MappedEntity("fruits-1")
data class FruitV1(

    @field:Id
    @GeneratedValue(IDENTITY)
    var id: String?,

    val name: String,

    @Relation(ONE_TO_MANY, mappedBy = "fruit", cascade = [ALL]) // mapped by target field in banana entity
    val bananas: MutableSet<BananaV1> = mutableSetOf(),
) {
    constructor(name: String, bananas: List<BananaV1>) : this(null, name, bananas.toMutableSet())
}


@Join("bananas")
@MongoRepository(databaseName = "test")
interface FruitRepoV1 : CrudRepository<FruitV1, String>