package com.betoe.minhasvacinas.model

/**
 * Created by roberto on 10/13/17.
 */
class User() {

    var name: String? = null
    var email: String? = null
    var password: String? = null

    constructor(name: String, email:String, password:String): this() {
        this.name = name
        this.email = email
        this.password = password
    }
}