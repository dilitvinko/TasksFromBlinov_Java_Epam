package chapter_12.task_A_2;

public class Runner {

    public static void main(String[] args) {
        FilmsDao filmsDao = new FilmsDao();
        for (Film f : filmsDao.findAll()) {
            System.out.println(f);
        }

        System.out.println();

        for (Film f : filmsDao.findThisAndLastYear()) {
            System.out.println(f);
        }

        System.out.println();

        for (Film f : filmsDao.findAllActorsInFilm("Green Mile")) {
            System.out.println(f.getActors());
        }

        System.out.println();

        for (Film f : filmsDao.findActorsInNFilmS("1")) {
            System.out.println(f.getActors());
        }

        System.out.println();

        filmsDao.deleteFilmsLowYear("1943");


    }
}
