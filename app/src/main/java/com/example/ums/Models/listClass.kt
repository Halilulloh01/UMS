package com.example.ums.Models
class listClass {
    var name = ""
    var description = ""
    var code = ""
    var fullDescription = ""

    constructor(name: String, description: String, code: String) {
        this.name = name
        this.description = description
        this.code = code
    }

    constructor(name: String, description: String, code: String, fullDescription: String) {
        this.name = name
        this.description = description
        this.code = code
        this.fullDescription = fullDescription
    }

}