package chapter_8.task_B_4.Entity;

public abstract class Vegetable {
    int massa;
    int kkal;
    boolean ripe;

    public Vegetable() {
    }

    public int getMassa() {
        return massa;
    }

    private void setKkal(int kkal) {
        this.kkal = kkal;
    }



    public int getKkal() {
        return kkal;
    }



    public boolean isRipe() {
        return ripe;
    }


}
