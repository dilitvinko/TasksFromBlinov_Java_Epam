package chapter_8.task_B_4.Entity;

import java.util.ArrayList;

public class Salad {
    private ArrayList<Vegetable> vegetables = new ArrayList<>();

    public Salad() {
    }

    public int kkalIn100gr(){
        int sumkkal = 0;
        for (Vegetable veg : vegetables) {
            sumkkal += veg.getKkal();
        }
        int mass = 0;
        for (Vegetable veg : vegetables) {
            mass += veg.getMassa();
        }
        return 100 * sumkkal / mass;
    }

    public Salad(ArrayList<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }

    public void addEngridient(Vegetable veg){
        vegetables.add(veg);
    }

    public ArrayList<Vegetable> getVegetables() {
        return vegetables;
    }

    public void setVegetables(ArrayList<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }
}
