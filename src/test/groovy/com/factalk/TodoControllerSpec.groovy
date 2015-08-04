package com.factalk

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(TodoController)
@Mock(Livro)
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

	def "Testa o lançamento de um novo volume do Factalk"(){
		when: "lançamos um novo Factalk"
			def livrosAntigos = Livro.count()
			controller.ultimolivro()
		
		then: "A view deve receber a informação sobre o novo livro criado"
			model.livro != null
			Livro.count() == livrosAntigos + 1
	}

	def "Testa renderização de views"(){
		when: "o controlador de soma for chamado para somar 2+3"
			params.numero1 = 2
			params.numero2 = 3
			controller.soma()
		then: "A view soma.gsp deve ser renderizada com o resultado"
			model.resultado == 5
			view == '/todo/soma'
	}

	def "Testa o WebService JSON"(){
		when: "um token válido é recebido pela aplicação"
			request.json = '{token: "123"}'
			controller.json()

		then: "A resposta é recebida em formato JSON"
			response.json.empresa == "Facta"
			response.json.evento == "Factivity"
			response.json.erro == null
	}

	def "Testa o WebService JSON"(){
		when: "um token inválido é recebido"
			controller.json()

		then: "o erro é recebido em formato JSON"
			response.json.empresa == null
			response.json.erro == "Token inválido"
	}
}
