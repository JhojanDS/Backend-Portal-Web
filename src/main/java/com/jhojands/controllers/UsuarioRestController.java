/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jhojands.controllers;

import com.jhojands.models.Usuario;
import com.jhojands.models.service.UsuarioServiceImpl;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JHOJAN L
 */

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UsuarioRestController {

    
    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario) {
        Usuario response = usuarioService.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());
        
        if (response != null) {
            return response;
        } else {
            return null;
        }

    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        Usuario u = usuarioService.findByEmail(usuario.getEmail());

        if (u == null) {//si no esta registrado un usuario con el mismo email
            
            Usuario response = usuarioService.save(usuario);
            return new ResponseEntity<>(response, HttpStatus.OK);
            
        }else{
        
            Map<String,Object> response = new HashMap<>();
            response.put("mensaje", "El email ya se encuentra registrado con otro usuario.");             
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

      
    }

}
