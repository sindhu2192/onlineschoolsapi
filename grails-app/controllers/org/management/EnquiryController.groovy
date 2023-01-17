package org.management

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EnquiryController {

    EnquiryService enquiryService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond enquiryService.list(params), model:[enquiryCount: enquiryService.count()]
    }

    def show(Long id) {
        respond enquiryService.get(id)
    }

    def save(Enquiry enquiry) {
        if (enquiry == null) {
            render status: NOT_FOUND
            return
        }

        try {
            enquiryService.save(enquiry)
        } catch (ValidationException e) {
            respond enquiry.errors, view:'create'
            return
        }

        respond enquiry, [status: CREATED, view:"show"]
    }

    def update(Enquiry enquiry) {
        if (enquiry == null) {
            render status: NOT_FOUND
            return
        }

        try {
            enquiryService.save(enquiry)
        } catch (ValidationException e) {
            respond enquiry.errors, view:'edit'
            return
        }

        respond enquiry, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        enquiryService.delete(id)

        render status: NO_CONTENT
    }
}
