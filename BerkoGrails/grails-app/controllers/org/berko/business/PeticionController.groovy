package org.berko.business



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PeticionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Peticion.list(params), model:[peticionInstanceCount: Peticion.count()]
    }

    def show(Peticion peticionInstance) {
        respond peticionInstance
    }

    def create() {
        respond new Peticion(params)
    }

    @Transactional
    def save(Peticion peticionInstance) {
        if (peticionInstance == null) {
            notFound()
            return
        }

        if (peticionInstance.hasErrors()) {
            respond peticionInstance.errors, view:'create'
            return
        }

        peticionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'peticion.label', default: 'Peticion'), peticionInstance.id])
                redirect peticionInstance
            }
            '*' { respond peticionInstance, [status: CREATED] }
        }
    }

    def edit(Peticion peticionInstance) {
        respond peticionInstance
    }

    @Transactional
    def update(Peticion peticionInstance) {
        if (peticionInstance == null) {
            notFound()
            return
        }

        if (peticionInstance.hasErrors()) {
            respond peticionInstance.errors, view:'edit'
            return
        }

        peticionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Peticion.label', default: 'Peticion'), peticionInstance.id])
                redirect peticionInstance
            }
            '*'{ respond peticionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Peticion peticionInstance) {

        if (peticionInstance == null) {
            notFound()
            return
        }

        peticionInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Peticion.label', default: 'Peticion'), peticionInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'peticion.label', default: 'Peticion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
