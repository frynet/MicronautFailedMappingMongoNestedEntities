package org.example.v3

import io.micronaut.data.annotation.*
import io.micronaut.data.annotation.GeneratedValue.Type.IDENTITY
import io.micronaut.data.annotation.Relation.Cascade.PERSIST
import io.micronaut.data.annotation.Relation.Kind.ONE_TO_MANY
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository


@MappedEntity("fruits-3")
data class FruitV3(

    @field:Id
    @GeneratedValue(IDENTITY)
    var id: String?,

    val name: String,

    @Relation(ONE_TO_MANY, cascade = [PERSIST])
    val bananas: MutableSet<BananaV3> = mutableSetOf(),
) {
    constructor(name: String, bananas: List<BananaV3>) : this(null, name, bananas.toMutableSet())
}


@Join("bananas")
@MongoRepository(databaseName = "test")
interface FruitRepoV3 : CrudRepository<FruitV3, String>