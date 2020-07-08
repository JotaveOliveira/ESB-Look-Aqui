package br.com.look.aqui.entrypoint.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Classe responsável por simular uma rota de teste
 * 
 * @author Caio Henrique do Carmo Bastos
 * @since 08/07/2020
 *
 */
@Component
public class HealthRestRoute extends RouteBuilder {

	private static final String ROTA_ENTRADA = "direct:rota_healthcheck";
	private static final String ROTA_ID = "rota_healthcheck";

	/**
	 * Método responsável por configurar a rota teste
	 * da aplicação e ter como saida um 200 no body
	 */
	@Override
	public void configure() throws Exception {
		rest()
			.get("/healtcheck")
				.produces("text/plain")
			.route()
			.from(ROTA_ENTRADA)
			.routeId(ROTA_ID)
				.setBody(constant("200 Ok"));
	}
}
