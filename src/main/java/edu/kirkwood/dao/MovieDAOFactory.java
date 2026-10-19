package edu.kirkwood.dao;

import java.io.InputStream;
import java.util.IllformedLocaleException;
import java.util.Properties;

public class MovieDAOFactory {
    private static Properties properties = new Properties();

    static {
        try(InputStream input = MovieDAOFactory.class.getClassLoader()
                .getResourceAsStream("application.properties");
        ){
            if(input == null){
                System.out.println("Unable to find application.properties.");
            }
            properties.load(input);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static MovieDAO getMovieDAO(){
        String sourceType = properties.getProperty("datasource.type");
        if(sourceType.equalsIgnoreCase("XML")){
            String apiURL = properties.getProperty("xml.apiURL");
            if(apiURL == null || apiURL.isEmpty()){
                throw new IllegalArgumentException("'xml.apiURL' is not configured in application.properties.");
            }
            return new XmlMovieDAO(apiURL);
        } else if(sourceType.equalsIgnoreCase("JSON")){
            String apiURL = properties.getProperty("json.apiURL");
            if(apiURL == null){
                throw new IllegalArgumentException("'json.apiURL' is not configured in application.properties.");
            }
            String apiAccessToken = properties.getProperty("json.apiReadAccessToken");
            if(apiAccessToken == null || apiAccessToken.isEmpty()) {
                throw new IllegalArgumentException("'json.apiReadAccessToken' is not configured in application.properties.");
            }
            return new JsonMovieDAO(apiURL, apiAccessToken);
        } else {
            throw new IllegalArgumentException("Invalid data source type: '" + sourceType + "'.");
        }
    }
}
