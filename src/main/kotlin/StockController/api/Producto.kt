package StockController.api

import jakarta.persistence.*

@Entity
@Table(name = "producto")
class Producto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String = "",
    val brand: String = "",
    val quantity: Int = 0,
    val status: String = "",
    val location: String = "",
    val holderName: String = "",
    val notes: String = ""
)
