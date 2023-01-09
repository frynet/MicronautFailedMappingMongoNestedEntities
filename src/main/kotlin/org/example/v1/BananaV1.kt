package org.example.v1

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.GeneratedValue.Type.IDENTITY
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation
import io.micronaut.data.annotation.Relation.Kind.MANY_TO_ONE
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository


@MappedEntity("bananas-1")
class BananaV1(

    @field:Id
    @GeneratedValue(IDENTITY)
    var id: String?,

    val name: String,

    @Relation(MANY_TO_ONE)
    val fruit: FruitV1,
) {
    constructor(name: String, fruit: FruitV1) : this(null, name, fruit)
}


@MongoRepository(databaseName = "test")
interface BananaRepoV1 : CrudRepository<BananaV1, String>