package HolaSpring6CV3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibrosController {

    @GetMapping("/libros")
    public String libros() {
        return "libros";  
    }

}
