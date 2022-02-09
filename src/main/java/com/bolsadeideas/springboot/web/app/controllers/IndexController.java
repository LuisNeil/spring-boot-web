package com.bolsadeideas.springboot.web.app.controllers;

import com.bolsadeideas.springboot.web.app.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;
    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;
    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

    @GetMapping(value = "/index")
    public String index(Model model){
        model.addAttribute("titulo",textoIndex);
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setApellido("Tejeda");
        usuario.setNombre("Luis");
        usuario.setEmail("ltejeda@mail.com");
        model.addAttribute("usuario",usuario);
        model.addAttribute("titulo",textoPerfil.concat(usuario.getNombre()));
        return "perfil";
    }

    @RequestMapping("/lista")
    public String listar(Model model){
         /*usuarios.add(new Usuario("Luis","Tejeda","ltejeda@mail.com"));
        usuarios.add(new Usuario("Carlos","Barrios","cbsrrios@mail.com"));
        usuarios.add(new Usuario("Rafael", "Lopez", "rlopez@mail.com"));*/
        model.addAttribute("titulo",textoListar);
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = Arrays.asList(new Usuario("Luis","Tejeda","ltejeda@mail.com"),
                new Usuario("Carlos","Barrios","cbsrrios@mail.com"),
                new Usuario("Rafael", "Lopez", "rlopez@mail.com"),
                new Usuario("Maria","Ochoa", "mochoa@mail.com"));
        return usuarios;
    }
}
