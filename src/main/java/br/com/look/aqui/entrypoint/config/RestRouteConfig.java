package br.com.look.aqui.entrypoint.config;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe responsável pela configuração para suportar requisições REST
 * 
 * @author Caio Henrique do Carmo Bastos
 * @since 08/07/2020
 *
 */
@Configuration
public class RestRouteConfig extends RouteBuilder {

	public static final String CAMINHO_BASE_APLICACAO = "/r/api/look-aqui/v1";
	
	/**
	 * Registra o Servlet do Camel
	 * 
	 * @return {@code ServletRegistrationBean} - beanRegistration que representa
	 * 		o registro do Servlet do Camel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean camelServletRegistrationBean() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new CamelHttpTransportServlet(), 
				CAMINHO_BASE_APLICACAO + "*");
		registrationBean.setName("CamelServlet");
		return registrationBean;
	}
	
	/**
	 * Configura a aplicação para requisições REST, assim 
	 * como prepara para a geração do Swagger.
	 */
	@Override
	public void configure() throws Exception {
		restConfiguration()
			.dataFormatProperty("prettyPrint", "true")
				.component("servlet")
				.apiContextPath("/api-doc")
				.apiProperty("api.title", "ESB-LookAqui")
				.apiProperty("api.version", "1.0.0")
				.apiProperty("cors", "true")
				.enableCORS(true)
				.apiProperty("host", "")
				.bindingMode(RestBindingMode.auto)
			.dataFormatProperty("prettyPrint", "true")
		.dataFormatProperty("mustBeJAXBElement", "false");
	}
}
