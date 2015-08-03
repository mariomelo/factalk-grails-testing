package com.factalk


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class IntegrationExampleSpec extends Specification {

    def "Testa a criação de livros"() {
        given:"Criei um livro"
        	new Livro(nome: 'Factalk').save(flush: true)

        expect: "Existirá apenas um livro criado"
        	Livro.count() == 1
    }

    def "Testa a criação de um livro com defeito"() {
        given:"Criei um livro semm título"
        	new Livro(nome: '').save(flush: true)

        expect: "Não existirá nenhum livro criado"
        	Livro.count() == 0
    }

}
