package chapter_12.task_A_2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class FilmsDao {

    ConnectorDB connectorDB;

    public static final String GET_ALL = "SELECT * FROM films JOIN actorsinfilms ON idF = idFilm JOIN persons ON idActor = idP;";
    public static final String GET_ALL_FILMS_THIS_LAST_YEAR = "SELECT * FROM films JOIN actorsinfilms ON idF = idFilm JOIN persons ON idActor = idP\n" +
                                                "WHERE YEAR(dateRelease) = YEAR(CURRENT_TIMESTAMP) OR YEAR(dateRelease) = YEAR(CURRENT_TIMESTAMP) - 1;";
    public static final String GET_ALL_ACTORS_IN_FILM = "SELECT * FROM films JOIN actorsinfilms ON idF = idFilm JOIN persons ON idActor = idP WHERE nameFilm = ? ;";
    public static final String GET_ACTORS_IN_N_FILMS = "SELECT * FROM persons JOIN actorsinfilms ON idP = idActor JOIN films ON idFilm = idF GROUP BY idActor having COUNT(*) > ?;";
    public static final String DELETE_FILMS_LOW_YEAR = "DELETE films , actorsinfilms  FROM films  JOIN actorsinfilms WHERE idF = idFilm and Year(dateRelease) < ? ;";


    public ArrayList<Film> findAll(){
        return find(GET_ALL);
    }

    public ArrayList<Film> findThisAndLastYear(){
        return find(GET_ALL_FILMS_THIS_LAST_YEAR);
    }

    public ArrayList<Film> findAllActorsInFilm(String nameFilm){
        return find(GET_ALL_ACTORS_IN_FILM, nameFilm);
    }

    public ArrayList<Film> findActorsInNFilmS(String countOfFilms){
        return find(GET_ACTORS_IN_N_FILMS, countOfFilms);
    }

    public void deleteFilmsLowYear(String year){
        deleteRows(DELETE_FILMS_LOW_YEAR, year);
    }

    private ArrayList<Film> find(String SQL){
        ArrayList<Film> resFilms = new ArrayList<>();
        Map<Integer, Film> films = new HashMap<>();
        Statement statement = null;
        connectorDB = new ConnectorDB(); //wrong
        ResultSet resultSet;
        try {
            statement = connectorDB.getStatement();
            resultSet = statement.executeQuery(SQL);
            films = FilmsDao.getFromDB(resultSet);
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        }
        finally {
            connectorDB.closeStatement(statement);
        }
        for (Map.Entry<Integer, Film> pair: films.entrySet()){
            resFilms.add(pair.getValue());
        }
        return  resFilms;
    }

    private ArrayList<Film> find (String SQL, String value){
        ArrayList<Film> resFilms = new ArrayList<>();
        Map<Integer, Film> films = new HashMap<>();
        PreparedStatement preparedStatement = null;
        connectorDB = new ConnectorDB();
        ResultSet resultSet;
        try {
            preparedStatement = connectorDB.getPrepareStatement(SQL);
            preparedStatement.setString(1, value);
            resultSet = preparedStatement.executeQuery();
            films = FilmsDao.getFromDB(resultSet);
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        }
        finally {
            connectorDB.closeStatement(preparedStatement);
        }
        for (Map.Entry<Integer, Film> pair: films.entrySet()){
            resFilms.add(pair.getValue());
        }
        return  resFilms;
    }

    private void deleteRows (String SQL, String value){
        PreparedStatement preparedStatement = null;
        connectorDB = new ConnectorDB();
        int numberRows = 0;
        try {
            preparedStatement = connectorDB.getPrepareStatement(SQL);
            preparedStatement.setString(1,value);
            numberRows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        }
        System.out.println( numberRows + " rows deleted..." );
    }

    private static Map<Integer, Film> getFromDB( ResultSet resultSet) throws SQLException{
        Map<Integer, Film> films = new HashMap<>();
        while (resultSet.next()) {
            Actor actor = new Actor();
            actor.setId(resultSet.getInt("idActor"));
            actor.setNameActor(resultSet.getString("namePerson"));
            actor.setBornDate(resultSet.getDate("bornDate"));
            if(films.containsKey(resultSet.getInt("idF"))){
                films.get(resultSet.getInt("idF")).addActor(actor);
            }else {
                Film film = new Film();
                film.setId(resultSet.getInt("idF"));
                film.setNameFilm(resultSet.getString("nameFilm"));
                film.setDateRelease(resultSet.getDate("dateRelease"));
                film.setCountry(resultSet.getString("country"));
                film.addActor(actor);
                films.put(film.getId(), film);
            }
        }
        return films;
    }


}
