package chapter_8.task_B_4.Entity;

import chapter_8.task_B_4.Exeptions.ArgumentExeption;

public abstract class VegOnGround extends Vegetable {
    private int koof;
    private int vitaminD;

    private void calculateKkal(int m, boolean ripe, int koof){
        if(ripe){
            super.kkal = m * koof / 25;
        }else{
            super.kkal = m * koof / 18;
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



    public VegOnGround(int massa, boolean ripe, int koof) {
        this.koof = koof;
        this.massa = massa;
        calculateKkal(massa, ripe, koof);
        this.ripe = ripe;
    }

    public VegOnGround() {
    }

    public VegOnGround(int vitaminD) {
        this.vitaminD = vitaminD;
    }
}
