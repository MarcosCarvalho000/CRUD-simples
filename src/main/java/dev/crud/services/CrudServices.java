package dev.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.crud.models.Crud;
import dev.crud.repository.CrudRepository;

@Service
public class CrudServices {

    private final CrudRepository crudRepository;

    
    public CrudServices(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }
 
    public List<Crud> getTarefas() {
        return crudRepository.findAll();
    }

    public Optional<?> getTarefaPorId(Long id) {
        try {
            return crudRepository.findById(id);
        } catch (Exception e) {
            return Optional.of("tarefa não encontrada");
        }
    }
    
    public String addTarefa(String conteudo) {
        Crud novaTarefa = new Crud();
        novaTarefa.setConteudo(conteudo);
        crudRepository.save(novaTarefa);
        return "Tarefa adicionada com sucesso!";
    }

    public String atualizarTarefa(Long id, String conteudo) {

        Optional<?> tarefa = crudRepository.findById(id);
        if (tarefa.isPresent()) {
            Crud tarefaExistente = (Crud) tarefa.get();
            tarefaExistente.setConteudo(conteudo);
            crudRepository.save(tarefaExistente);
        } else {
            return "Tarefa não encontrada";
        }
        return "Tarefa atualizada com sucesso!";
    }

    public String deletarTarefa(Long id) {

        Optional<?> tarefa = crudRepository.findById(id);
        if (tarefa.isPresent()) {
            crudRepository.deleteById(id);
            return "Tarefa deletada com sucesso!";
        } else {
            return "Tarefa não encontrada";

        }
    }
}
