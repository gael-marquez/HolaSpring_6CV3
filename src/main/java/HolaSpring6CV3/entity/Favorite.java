package HolaSpring6CV3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario user;

    @Column(name = "movie_id")
    private String movieId;  // Cambiado de Long a String

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getMovieId() {  // Cambiado de Long a String
        return movieId;
    }

    public void setMovieId(String movieId) {  // Cambiado de Long a String
        this.movieId = movieId;
    }

// filepath: c:\Users\gaelm\Downloads\HolaSpring6CV3-main\src\main\java\HolaSpring6CV3\entity\Favorite.java
@Override
public String toString() {
    return "Favorite{" +
            "id=" + id +
            ", userId=" + (user != null ? user.getId() : "null") +
            ", movieId='" + movieId + '\'' +
            '}';
}
}