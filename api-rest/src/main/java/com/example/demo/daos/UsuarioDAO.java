package com.example.demo.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long>
{

}
