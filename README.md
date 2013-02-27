vo-grails-constraints
=====================

Este plugin tiene como propósito convertir validaciones de clases de dominio que usualmente llevamos a cabo con 'matches' y 'validators'en Constraints y registrarlas en la aplicación que tenga instalado este plugin.


# Crear constraints en el plugin

* Generar una clase en el directorio 'src/groovy/com/vincoorbis/grails/constraints' con la lógica de la restricción. 
 

      	import org.springframework.validation.Errors
      	import org.codehaus.groovy.grails.validation.AbstractConstraint          
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
      

* Registrar el constraint en el archivo 'VoGrailsContraintsGrailsPlugin' dentro del bloque 'doWithSpring':

        def doWithSpring = {
            	ConstrainedProperty.registerNewConstraint(RFCConstraint.CONSTRAINT_NAME, RFCConstraint.class)
       	}  
  

**Nota: Para generar un nuevo constraint, crea una branch a partir de development y genera un pull request a development **

# Instalar el plugin

* Clonar el proyecto en tu computadora

        git clone https://github.com/vinco/vo-grails-contraints.git

* Ingresar a la carpeta del proyecto y empaquetarlo

        grails package-plugin
      
* Instalar el zip generado en el proyecto donde deseas emplearlo

        grails install-plugin grails-vo-grails-contraints-0.1.zip


# Utilizar los constraints del plugin

* En la clase de dominio donde se desea aplicar el constraint, se debe mandarla a llamar conforme al nombre ocupado en la clase donde fue definida.

        class Persona {
    		String nombre
    		String rfc

    		static constraints = {
        		nombre(blank: false)
        		//Aplicando el constraint de RFC
        		rfc(rfc: true)
        	}
        }


