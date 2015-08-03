package com.factalk

import grails.test.mixin.integration.Integration
import grails.transaction.*

import spock.lang.*
import geb.spock.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration
@Rollback
class FunctionalExampleSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Testa a página inicial"() {
        when:"visito a página inicial"
            go '/'

        then:"o título deve ser o padrão do Grails"
        	$('title').text() == "Welcome to Grails"
    }

    void "Testa a página inicial"() {
        when:"somo 50 com 111"
            go '/todo/soma'
            $("form.parcelas").with {
                numero1 = 50
                numero2 = 111
                $("#somar").click()
            }

        then:"o resultado exibido deve ser 161"
            $('h1').text() == "O resultado é: 161"
    }
}
