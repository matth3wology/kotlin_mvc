package com.sneed.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

@Serializable
data class CustomerDTO(val id: String, val firstName: String, val lastName: String, val email: String)

object Customer : Table() {
    val firstName = varchar("firstname", 50)
    val lastName = varchar("lastname", 50)
    val email = varchar("email", 50)
}

class CustomerDB {
    private val db = Database.connect("jdbc:sqlite:app.db", driver = "org.sqlite.JDBC")
    init {
        transaction(db) {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(Customer)
        }
    }

    fun addCustomer(customer:CustomerDTO) {
        transaction(db) {
            addLogger(StdOutSqlLogger)
            Customer.insert {
                it[firstName] = customer.firstName
                it[lastName] = customer.lastName
                it[email] = customer.email
            }
        }
    }
}