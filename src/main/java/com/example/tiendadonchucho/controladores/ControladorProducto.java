package com.example.tiendadonchucho.controladores;

import com.example.tiendadonchucho.entidades.Producto;
import com.example.tiendadonchucho.servicios.Servicioproducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tienda/api/")
public class ControladorProducto {

    @Autowired
    Servicioproducto servicioproducto;

    @PostMapping
    public ResponseEntity<?> registrarProducto(@RequestBody Producto producto){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(servicioproducto.agregar(producto));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error al registrar el producto");
        }
    }


    @GetMapping
    public ResponseEntity<?> buscarTodosProductos(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioproducto.buscarTodos());
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error buscando los productos");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProductoPorId(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicioproducto.buscarPorId(id));

        }catch(Exception error){

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error consultando el producto");

        }
    }




}
