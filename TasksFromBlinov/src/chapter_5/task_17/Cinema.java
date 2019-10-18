package chapter_5.task_17;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

public class Cinema {
    private String adress;
    private HashMap<Film, LocalTime> seanses = new HashMap<>();

    public Cinema(String adress) {
        this.adress = adress;
    }

    private class Film {
        private String name;
        private String zanr;
        private int minut;

        public Film(String name, String zanr, int minut) {
            this.name = name;
            this.zanr = zanr;
            this.minut = minut;
        }

        @Override
        public String toString() {
            return name+ " " + zanr + " " + minut + " ";
        }
    }

    public void addSeans(String name, String zanr, int minut, LocalTime time){
        seanses.put(new Film(name, zanr, minut), time);
    }

    @Override
    public String toString(){
        String temp = adress + "\n";
        for (HashMap.Entry<Film, LocalTime> entry : seanses.entrySet()) {
            temp += (entry.getKey()+" --> "+entry.getValue()) + "\n";
        }
        return temp;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public HashMap<Film, LocalTime> getSeans() {
        return seanses;
    }

    public void setSeans(HashMap<Film, LocalTime> seanses) {
        this.seanses = seanses;
    }


}
