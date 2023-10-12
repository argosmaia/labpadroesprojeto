package com.TODOList.TODOList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaRepository tarefaRepository;

    @Autowired
    public TarefaController(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Tarefa buscarTarefa(@PathVariable Long id) {
        return tarefaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        tarefa.setId(id);
        return tarefaRepository.save(tarefa);
    }

    @DeleteMapping("/{id}")
    public void excluirTarefa(@PathVariable Long id) {
        tarefaRepository.deleteById(id);
    }
}
