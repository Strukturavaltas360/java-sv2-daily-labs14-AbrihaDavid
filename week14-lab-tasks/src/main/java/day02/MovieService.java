package day02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public List<Movie> moviesWithGivenActor(String actor){
        return movies.stream().
                filter(o -> o.getActors().stream().
                        anyMatch(a -> a.equals(actor))).
                collect(Collectors.toList());
    }

    public long getLengthOfLongestMovie(){
        return movies.stream().
                max(new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        return o1.getLength() - o2.getLength();
                    }
                }).get().getLength();
    }
}
