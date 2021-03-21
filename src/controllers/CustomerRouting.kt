package com.sneed.controllers

import com.sneed.customerdb
import com.sneed.models.CustomerDTO
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.customerRouting() {
    route("/customer"){
        post {
            val customer = call.receive<CustomerDTO>()
            customerdb.addCustomer(customer)
            call.respondText("Customer stored correctly", status = HttpStatusCode.Accepted)
        }
    }
}

fun Application.registerCustomerRoutes(){
    routing {
        customerRouting()
    }
}
