package HolaSpring6CV3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HolaSpring6CV3.entity.Favorite;
import HolaSpring6CV3.entity.Usuario;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUser(Usuario user);
    boolean existsByUserAndMovieId(Usuario user, String movieId);
}