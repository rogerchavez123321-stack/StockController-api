package StockController.api

import jakarta.persistence.*

@Entity
@Table(name = "productos") // Fuerza a usar la tabla en plural de phpMyAdmin
data class Producto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id_producto: Long = 0,
    val codigo: String? = null,
    val nombre: String? = null,
    val descripcion: String? = null,
    val imagen_url: String? = null,
    val modelo: String? = null,
    val numero_serie: String? = null,
    val cantidad: Int = 0,
    val status: String? = null
)
