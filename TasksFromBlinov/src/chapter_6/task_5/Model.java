package chapter_6.task_5;

public class Model extends  SiemensMobile {
    String model;


    @Override
    public void ring() {
        System.out.println("Prrr-Prrr-Prrr " + model);
    }

    @Override
    public void call(String str) {
        if (super.isLock()){
            System.out.println("!!! Your phone isLock");
        }else{
            super.call(str);
        }
    }

    @Override
    public void lock() {
        super.setLock(true);

    }

    @Override
    public void unlock() {
        super.setLock(false);
    }

    public Model(String model) {
        this.model = model;
    }

    public Model() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
