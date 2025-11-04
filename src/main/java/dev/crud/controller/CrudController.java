package dev.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.crud.models.Crud;
import dev.crud.services.CrudServices;

@RestController
@RequestMapping("/crud")
public class CrudController {

    private final CrudServices crudServices;

    public CrudController(CrudServices crudServices) {
        this.crudServices = crudServices;
    }

    @GetMapping("/listar")
    public List<Crud> listarTarefas() {
        return crudServices.getTarefas();
    }

    @GetMapping("/listar/{id}")
    public Optional<?> getTarefa(@PathVariable Long id) {
        return crudServices.getTarefaPorId(id);
    }

    @PostMapping("/adicionar")
    public String addTarefa(@RequestBody String body) {
        return crudServices.addTarefa(body);
    }

    @PutMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, @RequestBody String body) {
        return crudServices.atualizarTarefa(id, body);
    }

    @DeleteMapping("deletar/{id}")
    public String deletarTarefa(@PathVariable Long id) {
        return crudServices.deletarTarefa(id);
    }
}
