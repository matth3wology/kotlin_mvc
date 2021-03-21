package com.sneed

import com.sneed.controllers.registerCustomerRoutes
import com.sneed.models.Customer
import com.sneed.models.CustomerDB
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*
import io.ktor.server.netty.*

val customerStorage = mutableListOf<Customer>()
val customerdb = CustomerDB()

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    registerCustomerRoutes()
}

