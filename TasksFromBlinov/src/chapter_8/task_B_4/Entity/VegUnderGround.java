package chapter_8.task_B_4.Entity;

import chapter_8.task_B_4.Exeptions.ArgumentExeption;

public abstract class VegUnderGround extends Vegetable {
    private int koof;
    int vitaminE;

    private void calculateKkal(int m, boolean ripe, int koof){
        if(ripe){
            super.kkal = m * koof / 20;
        }else{
            super.kkal = m * koof / 15;
        }

    }

    public void setMass(int mass) {
        if (mass >= 0) {
            super.massa = mass;
            calculateKkal(mass, this.ripe, koof);
        } else {
            throw new ArgumentExeption("Неверные аргкменты");
        }
    }

    public void setRipe(boolean ripe) {
        super.ripe = ripe;
        calculateKkal(this.massa, ripe, koof);
    }



    public VegUnderGround(int massa, boolean ripe, int koof) {
        this.koof = koof;
        this.massa = massa;
        calculateKkal(massa, ripe, koof);
        this.ripe = ripe;
    }

    public VegUnderGround() {
    }

}
