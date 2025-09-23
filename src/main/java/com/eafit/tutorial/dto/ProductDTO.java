package com.eafit.tutorial.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO para Product - usado en responses de la API
 *
 * Representa la estructura de datos que se envía al cliente.
 * Incluye solo los campos necesarios para la API.
 */
@Schema(description = "Representación de un producto en la API")
public class ProductDTO {

    @Schema(description = "ID único del producto", example = "1")
    private Long id;

    @Schema(description = "Nombre del producto", example = "Laptop Gaming")
    private String name;

    @Schema(description = "Descripción detallada del producto", example = "Laptop para gaming con RTX 4070")
    private String description;

    @Schema(description = "Precio del producto", example = "2999.99")
    private BigDecimal price;

    @Schema(description = "Categoría del producto", example = "Electrónicos")
    private String category;

    @Schema(description = "Cantidad en stock", example = "15")
    private Integer stock;

    @Schema(description = "Estado del producto", example = "true")
    private Boolean active;

    @Schema(description = "Fecha de creación", example = "2024-01-15T10:30:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @Schema(description = "Fecha de última actualización", example = "2024-01-16T14:20:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    // Constructores
    public ProductDTO() {}

    public ProductDTO(Long id, String name, String description, BigDecimal price,
                     String category, Integer stock, Boolean active,
                     LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
src/main/java/com/eafit/tutorial/dto/CreateProductDTO.java:
package com.eafit.tutorial.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

/**
 * DTO para creación de productos
 *
 * Contiene solo los campos necesarios para crear un producto.
 * Incluye validaciones específicas para la creación.
 */
@Schema(description = "Datos requeridos para crear un nuevo producto")
public class CreateProductDTO {

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Schema(description = "Nombre del producto", example = "Smartphone Pro", required = true)
    private String name;

    @Size(max = 500, message = "La descripción no puede exceder 500 caracteres")
    @Schema(description = "Descripción del producto", example = "Smartphone de última generación con cámara de 108MP")
    private String description;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    @Digits(integer = 8, fraction = 2, message = "Formato de precio inválido")
    @Schema(description = "Precio del producto", example = "899.99", required = true)
    private BigDecimal price;

    @NotBlank(message = "La categoría es obligatoria")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "La categoría solo puede contener letras y espacios")
    @Schema(description = "Categoría del producto", example = "Electrónicos", required = true)
    private String category;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    @Schema(description = "Cantidad inicial en stock", example = "50", required = true)
    private Integer stock;

    // Constructores
    public CreateProductDTO() {}

    public CreateProductDTO(String name, String description, BigDecimal price, String category, Integer stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    // Getters y Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}
