package org.example.v2

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.GeneratedValue.Type.IDENTITY
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository


@MappedEntity("bananas-2")
class BananaV2(

    @field:Id
    @GeneratedValue(IDENTITY)
    var id: String?,

    val name: String,
) {
    constructor(name: String) : this(null, name)
}


@MongoRepository(databaseName = "test")
interface BananaRepoV2 : CrudRepository<BananaV2, String>