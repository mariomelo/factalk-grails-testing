package com.factalk

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(TodoController)
class TodoControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def "Testa o sentido da vida"(){
    	expect: "O sentido da vida deve ser 42"
    		controller.getSentidoDaVida() == 42
	}

    def "Testa se existe o serviço de previsão de tempo"(){
    	expect: "O serviço deve ter sido corretamente injetado no controlador"
    		controller.previsaoTempoService != null
	}
}
