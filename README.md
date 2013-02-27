vo-grails-constraints
=====================

Este plugin tiene como propósito convertir validaciones de clases de dominio que usualmente llevamos a cabo con 'matches' y 'validators'en Constraints y registrarlas en la aplicación que tenga instalado este plugin.


# Crear constraints en el plugin

* Generar una clase en el directorio 'src/groovy/com/vincoorbis/grails/constraints' con la lógica de la restricción. 
 

      

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


