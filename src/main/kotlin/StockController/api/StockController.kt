package StockController.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/stock")
@CrossOrigin(origins = ["http://localhost:3000"])
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

    @PutMapping("/{id}/status")
    fun updateProductoStatus(
        @PathVariable id: Long,
        @RequestBody body: Map<String, String>
    ): ResponseEntity<Producto> {
        val productoOpt = productoRepository.findById(id)
        if (productoOpt.isPresent) {
            val producto = productoOpt.get()
            val nuevoStatus = body["status"] ?: "DISPONIBLE"

            // Usamos .copy() para actualizar la propiedad status en el data class
            val productoActualizado = producto.copy(status = nuevoStatus)

            val saved = productoRepository.save(productoActualizado)
            return ResponseEntity.ok(saved)
        }
        return ResponseEntity.notFound().build()
    }
}
