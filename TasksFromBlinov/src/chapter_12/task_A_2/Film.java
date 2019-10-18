package chapter_12.task_A_2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Film extends  Entity {
    private String nameFilm;
    private Date dateRelease;
    private String country;
    private ArrayList<Actor> actors;

    public Film(int id, String nameFilm, Date dateRelease, String country, Actor actor) {
        super(id);
        this.nameFilm = nameFilm;
        this.dateRelease = dateRelease;
        this.country = country;
        actors = new ArrayList<>();
        actors.add(actor);
    }

    public Film() {
        actors = new ArrayList<>();
    }

    public void addActor(Actor actor){
        actors.add(actor);
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        return super.getId() + " "+ nameFilm + " (" + formatForDateNow.format(dateRelease) + ") " + country + " " + actors.toString();
    }
}
