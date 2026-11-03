package StockController.api

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
class CorsConfig {

    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()

        // Permite credenciales (cookies, headers de autorización, etc.)
        config.allowCredentials = true

        // Permite explícitamente el origen de tu frontend de Next.js
        config.addAllowedOrigin("http://localhost:3000")

        // Permite cualquier cabecera (Headers)
        config.addAllowedHeader("*")

        // Permite todos los métodos HTTP comunes (GET, POST, PUT, DELETE, OPTIONS)
        config.addAllowedMethod("*")

        source.registerCorsConfiguration("/api/**", config)
        return CorsFilter(source)
    }
}
