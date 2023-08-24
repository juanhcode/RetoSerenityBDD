package co.com.greyd.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features ="src/test/resources/features/obtener_respuesta_usuario.feature",
        glue = "co.com.greyd.stepdefinitions.obtenerrespuestausuario",
        snippets = SnippetType.CAMELCASE
)
public class ObtenerRespuestaUsuario {
}
