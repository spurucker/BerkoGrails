package org.berko.business



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MecanicoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Mecanico.list(params), model:[mecanicoInstanceCount: Mecanico.count()]
    }

    def show(Mecanico mecanicoInstance) {
        respond mecanicoInstance
    }

    def create() {
        respond new Mecanico(params)
    }

    @Transactional
    def save(Mecanico mecanicoInstance) {
        if (mecanicoInstance == null) {
            notFound()
            return
        }

        if (mecanicoInstance.hasErrors()) {
            respond mecanicoInstance.errors, view:'create'
            return
        }

        mecanicoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mecanico.label', default: 'Mecanico'), mecanicoInstance.id])
                redirect mecanicoInstance
            }
            '*' { respond mecanicoInstance, [status: CREATED] }
        }
    }

    def edit(Mecanico mecanicoInstance) {
        respond mecanicoInstance
    }

    @Transactional
    def update(Mecanico mecanicoInstance) {
        if (mecanicoInstance == null) {
            notFound()
            return
        }

        if (mecanicoInstance.hasErrors()) {
            respond mecanicoInstance.errors, view:'edit'
            return
        }

        mecanicoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Mecanico.label', default: 'Mecanico'), mecanicoInstance.id])
                redirect mecanicoInstance
            }
            '*'{ respond mecanicoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Mecanico mecanicoInstance) {

        if (mecanicoInstance == null) {
            notFound()
            return
        }

        mecanicoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Mecanico.label', default: 'Mecanico'), mecanicoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mecanico.label', default: 'Mecanico'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
