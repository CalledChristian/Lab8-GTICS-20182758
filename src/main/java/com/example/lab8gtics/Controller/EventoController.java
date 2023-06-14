package com.example.lab8gtics.Controller;


import com.example.lab8gtics.Entity.EventoEntity;
import com.example.lab8gtics.Entity.TipoTicketEventoEntity;
import com.example.lab8gtics.Repository.EventoRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/evento")

public class EventoController {

    final EventoRepository eventoRepository;

    public EventoController(EventoRepository eventoRepository) {

        this.eventoRepository = eventoRepository;
    }

    //Listar Usuarios
    @GetMapping("")
    public List<EventoEntity> listarEventos() {

        return eventoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String,Object>> obtenerEventoPorId(
            @PathVariable("id") String idStr) {

        //Nuevo objeto: "responseJson" tipo HashMap
        HashMap<String,Object> responseJson = new HashMap<>();

        try {
            int id = Integer.parseInt(idStr);
            Optional<EventoEntity> optEvent = eventoRepository.findById(id);
            if (optEvent.isPresent()) {
                //"para mandar un mensaje , objeto , lista , etc al postman"
                //responseJson.put("Nombre de Variable",Valor String,integer,big decimal,etc);
                //responseJson.put("result","success");
                responseJson.put("evento",optEvent.get());
                //HTTP- 200 OK
                return ResponseEntity.ok(responseJson);
            } else {
                responseJson.put("msg","Evento NO encontrado");
                responseJson.put("resultado", "falla");
            }
        } catch (NumberFormatException e) {
            //para mandar un mensaje al postman. ID en formato incorrecto
            responseJson.put("msg","El ID debe ser un numero entero positivo");
            responseJson.put("resultado", "falla");
        }
        return new ResponseEntity<>(responseJson, HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "")
    public ResponseEntity<HashMap<String,Object>> crearEvento(@RequestBody EventoEntity evento,@RequestParam(value = "fetchId", required = false) boolean fetchId){
        HashMap<String, Object> responseMap = new HashMap<>();

        if(evento!=null){
            eventoRepository.save(evento);
            responseMap.put("estado:","creado");
            if(fetchId){
                responseMap.put("id:",evento.getId());
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
        }else {
            responseMap.put("msg", "Debe Enviar un evento");
            responseMap.put("estado", "error");
        }
        return ResponseEntity.badRequest().body(responseMap);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, Object>> gestionExcepcion(
            HttpServletRequest request) {


        HashMap<String, Object> responseMap = new HashMap<>();

        if (request.getMethod().equals("POST")) {
            responseMap.put("msg", "Debe Enviar un evento");
            responseMap.put("estado", "error");
        }
        //HTTP 404 BAD REQUEST
        return ResponseEntity.badRequest().body(responseMap);
}


}
