package com.vincoorbis.grails.constraints
/*
*
* @author Roberto Pérez Alcolea (pr@manoderecha.mx)
*
*/


import org.codehaus.groovy.grails.validation.AbstractConstraint
import org.springframework.validation.Errors

import java.util.regex.Pattern


class RFCConstraint extends AbstractConstraint {

    //sets constraint name
    public static final String CONSTRAINT_NAME = "rfc"

    //sets regex to match
    public static final Pattern REGEXP = Pattern.compile("[A-Z,Ñ,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]?[A-Z,0-9]?[0-9,A-Z]?")

    //process validation
    protected void processValidate(Object target, Object propertyValue, Errors errors) {
        if (!REGEXP.matcher(propertyValue).matches()) {
            Object[] args = [ constraintPropertyName, constraintOwningClass,propertyValue ]
            rejectValue(target, errors, "Invalid RFC  format", "default.rfc.invalidFormat.message", args)
            return
        }
    }

    boolean supports(Class type) {
        return type && String.class.isAssignableFrom(type);
    }

    String getName() {
        return CONSTRAINT_NAME;
    }
}