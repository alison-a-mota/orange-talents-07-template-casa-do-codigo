package br.com.zupacademy.alison.casadocodigo.autor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @PostMapping
    public String novoAutor(@RequestBody @Valid AutorRequest autorRequest){
        Autor autor = autorRequest.toModel();

        return "autor: " + autor.getNome();
    }
}
