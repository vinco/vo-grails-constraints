import com.vincoorbis.grails.constraints.RFCConstraint
import org.codehaus.groovy.grails.validation.ConstrainedProperty

class VoGrailsContraintsGrailsPlugin {
    def version = "0.1"
    def grailsVersion = "1.3.7 > *"

    // TODO Fill in these fields
    def title = "Vo Grails Contraints Plugin" // Headline display name of the plugin
    def author = "Roberto Perez Alcolea @pr"
    def authorEmail = "pr@manoderecha.mx"
    def description = '''\
Plugin with constraints for Vinco Orbis Grails Projects.
'''

    // URL to the plugin's documentation
    def documentation = "https://github.com/vinco/grails-rfc-constraint"

    def license = "GPL3"

    def organization = [ name: "Vinco Orbis Proyectos, S.A. de C.V.", url: "http://vincoorbis.com/" ]

    //TODO: cuando contribuyas al plugin, agrega tu nombre y correo electrónico
    def developers = [ [ name: "Roberto Pérez Alcolea", email: "pr@manoderecha.mx" ]]

    def issueManagement = [ system: "Mano Derecha", url: "http://manoderecha.net" ]

    def scm = [ url: "https://github.com/vinco/grails-rfc-constraint.git" ]


    def doWithSpring = {
        //TODO: cuando se agrege un constraint a la carpeta src, hay que registrarlo en la app
        ConstrainedProperty.registerNewConstraint(RFCConstraint.CONSTRAINT_NAME, RFCConstraint.class)
    }

}
