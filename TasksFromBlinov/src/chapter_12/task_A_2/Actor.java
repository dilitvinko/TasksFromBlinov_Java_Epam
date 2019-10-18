package chapter_12.task_A_2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Actor extends Entity {
    private String nameActor;
    private Date bornDate;

    public Actor(String nameActor, Date bornDate) {
        this.nameActor = nameActor;
        this.bornDate = bornDate;
    }

    public Actor() {
    }

    public Actor(int id, String nameActor, Date bornDate) {
        super(id);
        this.nameActor = nameActor;
        this.bornDate = bornDate;
    }

    public String getNameActor() {
        return nameActor;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setNameActor(String nameActor) {
        this.nameActor = nameActor;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        return super.getId() + " " + nameActor + " (" + formatForDateNow.format(bornDate) + ")";
    }


}
