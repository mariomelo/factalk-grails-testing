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
}
