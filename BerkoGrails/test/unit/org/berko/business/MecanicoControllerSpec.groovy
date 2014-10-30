package org.berko.business



import grails.test.mixin.*
import spock.lang.*

@TestFor(MecanicoController)
@Mock(Mecanico)
class MecanicoControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.mecanicoInstanceList
            model.mecanicoInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.mecanicoInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def mecanico = new Mecanico()
            mecanico.validate()
            controller.save(mecanico)

        then:"The create view is rendered again with the correct model"
            model.mecanicoInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            mecanico = new Mecanico(params)

            controller.save(mecanico)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/mecanico/show/1'
            controller.flash.message != null
            Mecanico.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def mecanico = new Mecanico(params)
            controller.show(mecanico)

        then:"A model is populated containing the domain instance"
            model.mecanicoInstance == mecanico
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def mecanico = new Mecanico(params)
            controller.edit(mecanico)

        then:"A model is populated containing the domain instance"
            model.mecanicoInstance == mecanico
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/mecanico/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def mecanico = new Mecanico()
            mecanico.validate()
            controller.update(mecanico)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.mecanicoInstance == mecanico

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            mecanico = new Mecanico(params).save(flush: true)
            controller.update(mecanico)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/mecanico/show/$mecanico.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/mecanico/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def mecanico = new Mecanico(params).save(flush: true)

        then:"It exists"
            Mecanico.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(mecanico)

        then:"The instance is deleted"
            Mecanico.count() == 0
            response.redirectedUrl == '/mecanico/index'
            flash.message != null
    }
}
