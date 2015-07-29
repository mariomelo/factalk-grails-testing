package com.factalk

import grails.transaction.Transactional

@Transactional
class PrevisaoTempoService {

    def isTempoChuvoso() {
    	if(Math.random() < 0.4)
    		return true
    	else
    		return false
    }
}
