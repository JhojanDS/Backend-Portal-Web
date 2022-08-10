/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jhojands.models.service;

import com.jhojands.models.Usuario;
import com.jhojands.models.dao.IUsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JHOJAN L
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public Usuario findByEmailAndPassword(String email, String password) {
        return usuarioDao.findByEmailAndPassword(email, password);

    }

    
    @Override
    public Usuario findByEmail(String email) {
        return usuarioDao.findByEmail(email);
    }
    
    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }


}
