package org.example.v3

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.GeneratedValue.Type.IDENTITY
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository


@MappedEntity("bananas-3")
class BananaV3(

    val name: String,
) {

    @Id
    @GeneratedValue(IDENTITY)
    var id: String = ""
}


@MongoRepository(databaseName = "test")
interface BananaRepoV3 : CrudRepository<BananaV3, String>