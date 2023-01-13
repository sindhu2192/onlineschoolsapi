package org.management

import com.usermanagement.User

class Course {
    String name
    String description
    String featuredImage
    Integer duration
    User mentor
    Float price
    Integer enrollments
    Integer likes
    static hasMany = [subjects:Subject,users:User]

    static constraints = {
        featuredImage nullable:true,blank:true

    }
    static mapping ={
        description type:'text'
        featuredImage type:'text'
    }

    String toString()
    {
        return name
    }
}

