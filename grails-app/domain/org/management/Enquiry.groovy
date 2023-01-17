package org.management

class Enquiry {
    String name
    String subject
    String email
    boolean emailVerify
    String message
    String mobile
    boolean mobileVerify


    static constraints = {
        email nullable: false, blank: false, email: true
        name matches: "[a-zA-Z]+"
        mobile matches: "[0-9]+"

    }
    static mapping = {
        message type: 'text'
    }
}
