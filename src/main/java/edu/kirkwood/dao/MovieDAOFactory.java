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
            if(apiURL == null){
                throw new IllegalArgumentException("'xml.apiURL' is not configured in application.properties.");
            }
            return new XmlMovieDAO(apiURL);
        } else {
            throw new IllegalArgumentException("Invalid data source type: '" + sourceType + "'.");
        }
    }
}
