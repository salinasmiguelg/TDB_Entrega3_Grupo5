package cl.tdb.voluntariadodb.services;




import cl.tdb.voluntariadodb.models.Tarea;
import cl.tdb.voluntariadodb.repositories.TareaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@CrossOrigin
@RestController
public class TareaService{

    private final TareaRepository tareaRepository;

    TareaService(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }

    // crear C
    @PostMapping("/tarea")
    @ResponseBody
    public Tarea crearTarea(@RequestBody Tarea tarea){
        Tarea resultado = tareaRepository.crearTarea(tarea);
        return resultado;
    }

    // leer R
    @GetMapping("/tarea")
    public List<Tarea> getAllTareas(){
        return tareaRepository.getAllTareas();
    }
    
    @GetMapping("/tarea/{id}")
    public Tarea getAllTareas(){
        return tareaRepository.show(id);
    }


    // actualizar U
    @PutMapping("/tarea")
    @ResponseBody
    public String updateTarea(@RequestBody int nuevoNumeroTarea, @RequestBody Tarea tarea){
        String retorno = tareaRepository.updateTarea(nuevoNumeroTarea, tarea);
        return retorno;
    }
    
    
}