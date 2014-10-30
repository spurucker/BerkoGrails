package org.berko.business



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TrabajoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Trabajo.list(params), model:[trabajoInstanceCount: Trabajo.count()]
    }

    def show(Trabajo trabajoInstance) {
        respond trabajoInstance
    }

    def create() {
        respond new Trabajo(params)
    }

    @Transactional
    def save(Trabajo trabajoInstance) {
        if (trabajoInstance == null) {
            notFound()
            return
        }

        if (trabajoInstance.hasErrors()) {
            respond trabajoInstance.errors, view:'create'
            return
        }

        trabajoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'trabajo.label', default: 'Trabajo'), trabajoInstance.id])
                redirect trabajoInstance
            }
            '*' { respond trabajoInstance, [status: CREATED] }
        }
    }

    def edit(Trabajo trabajoInstance) {
        respond trabajoInstance
    }

    @Transactional
    def update(Trabajo trabajoInstance) {
        if (trabajoInstance == null) {
            notFound()
            return
        }

        if (trabajoInstance.hasErrors()) {
            respond trabajoInstance.errors, view:'edit'
            return
        }

        trabajoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Trabajo.label', default: 'Trabajo'), trabajoInstance.id])
                redirect trabajoInstance
            }
            '*'{ respond trabajoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Trabajo trabajoInstance) {

        if (trabajoInstance == null) {
            notFound()
            return
        }

        trabajoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Trabajo.label', default: 'Trabajo'), trabajoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'trabajo.label', default: 'Trabajo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
