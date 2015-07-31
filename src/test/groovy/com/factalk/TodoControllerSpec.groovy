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

    static doWithSpring = {
        previsaoTempoService(PrevisaoTempoService)
    }

    def "Testa o sentido da vida"(){
    	expect: "O sentido da vida deve ser 42"
    		controller.getSentidoDaVida() == 42
	}

    def "Testa se existe o serviço de previsão de tempo"(){
    	expect: "O serviço deve ter sido corretamente injetado no controlador"
    		controller.previsaoTempoService != null
	}

	def "Testa o texto retornado pelo controlador"(){
		when: "acesso a página principal"
        	controller.index()
        then: "Ela deve me informar se vai chover"
        	response.text.contains "Vai chover hoje?"
	}

	def "Testa o redirecionamento pelo controlador"(){
		when: "o link gotoindex é acessado"
			controller.goToIndex()
		then: "o usuário é redirecionado ao index"
			response.redirectedUrl == '/todo/index'
	}


}
