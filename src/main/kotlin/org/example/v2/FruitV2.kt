package org.example.v2

import io.micronaut.data.annotation.*
import io.micronaut.data.annotation.GeneratedValue.Type.IDENTITY
import io.micronaut.data.annotation.Relation.Cascade.ALL
import io.micronaut.data.annotation.Relation.Kind.ONE_TO_MANY
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository


@MappedEntity("fruits-2")
data class FruitV2(

    @field:Id
    @GeneratedValue(IDENTITY)
    var id: String?,

    val name: String,

    @Relation(ONE_TO_MANY, cascade = [ALL])
    val bananas: MutableSet<BananaV2> = mutableSetOf(),
) {
    constructor(name: String, bananas: List<BananaV2>) : this(null, name, bananas.toMutableSet())
}


@Join("bananas")
@MongoRepository(databaseName = "test")
interface FruitRepoV2 : CrudRepository<FruitV2, String>