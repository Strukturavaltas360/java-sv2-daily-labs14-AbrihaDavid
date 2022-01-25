package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    MovieService movieService = new MovieService();

    @BeforeEach
    void init(){
        movieService.addMovie(new Movie("AAA",100, Arrays.asList("John Doe","Jane Doe","Jack Doe")));
        movieService.addMovie(new Movie("BBB",200, Arrays.asList("John Doe","Jane Doe","Jack Doe","Bob")));
        movieService.addMovie(new Movie("CCC",50, Arrays.asList("John Doe","Tom")));
        movieService.addMovie(new Movie("DDD",260, Arrays.asList("John Doe","Jane")));
        movieService.addMovie(new Movie("EEE",85, Arrays.asList("John Doe","Jane Doe","Jack Doe","Bob","Tom","Bill","Jill")));
    }

    @Test
    void moviesWithGivenActor() {
        List<Movie> result = movieService.moviesWithGivenActor("Tom");
        assertEquals(2,result.size());
    }

    @Test
    void getLengthOfLongestMovie() {
        long result = movieService.getLengthOfLongestMovie();
        assertEquals(260,result);
    }
}