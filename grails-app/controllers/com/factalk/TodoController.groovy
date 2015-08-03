package com.factalk

class TodoController {


	def previsaoTempoService

    def index() { 
    	render "Vai chover hoje? <b>${previsaoTempoService.isTempoChuvoso()}</b>"
    }

    def getSentidoDaVida(){
    	42
    }

    def goToIndex() {
    	redirect action: 'index'
    }

    def soma(int numero1, int numero2){
    	def resultado = numero1 + numero2
    	render view: "soma", model: [resultado: resultado]
    }

    def json(){
    	if(request.JSON?.token)
	    	render(contentType:"application/json") {
	        	empresa = "Facta"
	        	evento = "Factivity"
	        	tema = "Grails Testing"
	    	}
	    else
    		render(contentType:"application/json") {
    	    	erro = "Token inválido"
    		}
    }
}
