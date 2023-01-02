package org.example.v2

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.GeneratedValue.Type.IDENTITY
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository


@MappedEntity("bananas-2")
class BananaV2(

    val name: String,
) {

    @Id
    @GeneratedValue(IDENTITY)
    var id: String = ""
}


@MongoRepository(databaseName = "test")
interface BananaRepoV2 : CrudRepository<BananaV2, String>