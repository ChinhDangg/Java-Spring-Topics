package dev.l_springcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/posts/**")
						.filters(f -> f
							.prefixPath("/api")
							.addResponseHeader("X-Powered-By","Someone")
						)
						.uri("http://localhost:8081")
				)
				.route(r -> r.path("/comments/**")
						.filters(f -> f
								.prefixPath("/api")
								.addResponseHeader("X-Powered-By","Someone")
						)
						.uri("http://localhost:8082")
				)
				.build();
	}

}
