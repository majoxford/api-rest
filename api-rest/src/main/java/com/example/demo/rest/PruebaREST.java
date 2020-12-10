package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Usuario;
import com.example.demo.daos.UsuarioDAO;

@RestController 
@RequestMapping("api/v1/users")




public class PruebaREST {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuario()
	{
		List<Usuario> usuarios = usuarioDAO.findAll();
	
		return ResponseEntity.ok(usuarios);
	
	}
	
	

	@RequestMapping(value="{usuarioId}")
	public ResponseEntity<Usuario> getUsuarioById (@PathVariable("usuarioId")Long usuarioId)
	{
		Optional<Usuario> usuarioOptional = usuarioDAO.findById(usuarioId);
		if(usuarioOptional.isPresent())
		{
			return ResponseEntity.ok(usuarioOptional.get());
		}else {
			
			return ResponseEntity.noContent().build();
		}
	
	}
	
	@PostMapping 
	public ResponseEntity<Usuario> crearUsuario (@RequestBody Usuario usuario)
	{
		Usuario newUsuario = usuarioDAO.save(usuario);
		return ResponseEntity.ok(newUsuario);
	}
	
	
	
	@DeleteMapping(value="{usuarioId}")
	public ResponseEntity<Void> deleteUsuario (@PathVariable("usuarioId")Long usuarioId)
	{
		usuarioDAO.deleteById(usuarioId);
		return ResponseEntity.ok(null);
	}

	
	@PutMapping (value="{usuarioId}")
	public ResponseEntity<Usuario> updateUsuario (@PathVariable("usuarioId") Long usuarioId, @RequestBody Usuario usuario)
	{
		Optional<Usuario> usuarioOptional = usuarioDAO.findById(usuarioId);
		if(usuarioOptional.isPresent())
		{
			Usuario Updateuser = usuarioOptional.get();
			Updateuser.setName(usuario.getName());
			usuarioDAO.save(Updateuser);
			return ResponseEntity.ok(Updateuser);
		}else {
			
			return ResponseEntity.noContent().build();
		}
		
	}
	
	
}
