import java.io.IOException;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

import javax.lang.model.element.Element;

import java.io.InputStreamReader;

import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        //code supplied from class
        String studioGhibliBaseURL = "https://ghibliapi.herokuapp.com";
        try {
            String json = callAPI(studioGhibliBaseURL + "/films");
            HashMap<String, Movie> movies = parseJSONToMap(json);
            printShortMovieListInfo(movies);
            choseSpecificMovie(movies, studioGhibliBaseURL);
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }

    // Need to take in a URL and return JSON
    public static String callAPI(String suppliedURL) throws IOException{
        URL url = new URL(suppliedURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("GET");
        httpConn.addRequestProperty("Accept-Charset", "UTF-8");
        httpConn.addRequestProperty("Content-type", "application/json");
        httpConn.addRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));

        System.out.println(httpConn.getResponseCode());
        //If 200, it will return null
        System.out.println(httpConn.getResponseMessage());
        String json = getJson(in);

        return json;
    }

    public static String getJson(BufferedReader in) throws IOException{
        boolean done = false;
        String responseLine = "";
        String json = "";

        while(!done){
            responseLine = in.readLine();
            if(responseLine == null){
                done = true;
            } else {
                json += responseLine;
            }
        }
        return json;
    }

    public static HashMap<String, Movie> parseJSONToMap(String json) throws IOException{
            HashMap<String, Movie> movies = new HashMap<>();
            JsonParser parser = new JsonParser();
            JsonArray jsonMovieArr = (JsonArray) parser.parse(json);

            for (JsonElement jsonElement : jsonMovieArr) {
                movies.put(jsonElement.getAsJsonObject().get("title").getAsString() , parseJSONElementToMovie(jsonElement));
            }
            return movies;
    }

    public static Movie parseJSONElementToMovie(JsonElement jsonElement) {
        return new Movie(jsonElement.getAsJsonObject().get("title").getAsString(), jsonElement.getAsJsonObject().get("description").getAsString(), jsonElement.getAsJsonObject().get("id").getAsString(), jsonElement.getAsJsonObject().get("release_date").getAsString(), jsonElement.getAsJsonObject().get("producer").toString());
    }

    public static void printShortMovieListInfo(HashMap<String, Movie> movies) {
        for (Movie movie : movies.values()) {
            System.out.println("---------------------------");
            System.out.println("Title: " + movie.getTitle());
            System.out.println("Description: " + movie.getDescription());
        }
    }

    public static void choseSpecificMovie(HashMap<String, Movie> movies, String studioGhibliBaseURL ) throws IOException{
        Scanner in = new Scanner(System.in);

        while(true){
            System.out.println();
            System.out.println("What movie would you like to learn more about?  Enter a movie title or \"quit\" to stop.");
            String userInput = in.nextLine();

            if (userInput.equalsIgnoreCase("quit")){
                in.close();
                break;
            }else if(movies.get(userInput) != null){
                System.out.println();
                movies.get(userInput).printFullInfo();
            }else{
                System.out.println();
                System.out.println("MOVIE NOT FOUND");
            }
        }

        
    }

}