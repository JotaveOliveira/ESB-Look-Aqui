package br.com.look.aqui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Classe de inicialização da aplicação.
 * 
 * @author Caio Henrique do Carmo Bastos
 * @since 08/07/2020
 *
 */
@SpringBootApplication
//@ImportResource({ "classpath:spring/*.xml", "classpath:/route/common-routes.xml" })
public class Application {

	/**
	 * Método principal para a inicialização da aplicação.
	 * 
	 * @param args
	 * 		{@code Stringn[]} - argumentos para a inicialização.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
