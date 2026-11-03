package StockController.api

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/stock")
@CrossOrigin(origins = ["http://localhost:3000"]) // <-- Pégalo aquí mismo
class StockController(private val productoRepository: ProductoRepository) {

    @GetMapping("/stats")
    fun getStockStats(): Map<String, Long> {
        val total = productoRepository.count()
        val disponibles = productoRepository.count()

        return mapOf(
            "total" to total,
            "disponibles" to disponibles,
            "prestados" to 0L,
            "rotos" to 0L,
            "vencidos" to 0L
        )
    }

    @GetMapping
    fun getAllProductos(): List<Producto> {
        return productoRepository.findAll()
    }
}
