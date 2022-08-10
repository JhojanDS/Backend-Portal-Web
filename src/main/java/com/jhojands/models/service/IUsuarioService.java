/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jhojands.models.service;

import com.jhojands.models.Usuario;
import java.util.List;

/**
 *
 * @author JHOJAN L
 */
public interface IUsuarioService{
    public Usuario findByEmailAndPassword(String email, String password);
    public Usuario findByEmail(String email);
    public Usuario save(Usuario usuario);
}
