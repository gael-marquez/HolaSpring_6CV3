package HolaSpring6CV3.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import HolaSpring6CV3.entity.Favorite;
import HolaSpring6CV3.entity.Usuario; // Importa List
import HolaSpring6CV3.repository.FavoriteRepository; // Importa Map
import HolaSpring6CV3.repository.UsuarioRepository; // Importa Collectors si es necesario

@Controller
@RequestMapping("/favoritos")
public class FavoriteController {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/add")
    public String addToFavorites(@RequestParam("movieId") String movieId, Authentication authentication) {
        System.out.println("Intentando agregar película: " + movieId); // Log para depuración
        try {
            String nombre = authentication.getName();
            System.out.println("Nombre autenticado: " + nombre);
            Usuario user = usuarioRepository.findByNombre(nombre);
            if (user != null) {
                System.out.println("Usuario encontrado: " + user.getId() + " - " + user.getNombre());
                if (!favoriteRepository.existsByUserAndMovieId(user, movieId)) {
                    Favorite favorite = new Favorite();
                    favorite.setUser(user);
                    favorite.setMovieId(movieId);
                    favoriteRepository.save(favorite);
                    System.out.println("Película agregada exitosamente"); // Log para depuración
                } else {
                    System.out.println("La película ya está en favoritos.");
                }
                return "redirect:/peliculas";
            } else {
                System.err.println("Usuario no encontrado en la base de datos.");
            }
        } catch (Exception e) {
            System.err.println("Error al agregar favorito: " + e.getMessage()); // Log para depuración
            e.printStackTrace();
        }
        return "redirect:/error";
    }

    @GetMapping("")
public String showFavorites(Model model, Authentication authentication) {
    try {
        String nombre = authentication.getName();
        Usuario user = usuarioRepository.findByNombre(nombre);
        if (user != null) {
            // Obtén los favoritos del usuario
            List<Favorite> favorites = favoriteRepository.findByUser(user);

            // Log para depuración
            System.out.println("Favoritos obtenidos: " + favorites);

            // Transforma los favoritos en un formato adecuado para Thymeleaf
            List<Map<String, String>> favoriteMovies = favorites.stream()
                .map(fav -> Map.of("movieId", fav.getMovieId()))
                .collect(Collectors.toList());

            System.out.println("Favoritos transformados: " + favoriteMovies);

            model.addAttribute("favorites", favoriteMovies);
            return "favoritos";
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "redirect:/error";
}
}