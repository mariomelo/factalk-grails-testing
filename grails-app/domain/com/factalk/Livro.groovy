package com.factalk

class Livro {
	String nome

    static constraints = {
    	nome nullable: false, blank: false
    }
}
