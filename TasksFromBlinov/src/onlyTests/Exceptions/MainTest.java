package onlyTests.Exceptions;

import java.util.*;

public class MainTest {

    static public void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>(){
            {
                add(new Student("qwe", 25));
                add(new Student("ewq", 20));
                add(new Student("asd", 30));
                add(new Student("dsa", 19));
            }
        };
        FindStudent fs = new FindStudent();
        List<Student> res = fs.findBiggerAgeStudent(23, students);
        System.out.println(res);
        FindStudent fsV2 = new FindStudent();
        List<Student> resV2 = fsV2.findBiggerAgeStudentV2(23, students);
        System.out.println(resV2);
        Comparator<Student> comp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o2.getAge() ,o1.getAge());
            }
        };
        Collections.sort(students, comp.reversed());
        System.out.println(students);

//        Iterator it = students.iterator();
//        while (it.hasNext()){
//            Student current = (Student) it.next();
//            if (current.getAge() >= 25) {
//                it.remove();
//            }
//        }

        System.out.println(students);

        HashMap <String, Integer> hm = new HashMap<>(){{
           this.put("qwe",20);
            this.put("asd",25);
            this.put("zxc",30);
        }};
        System.out.println(hm);






    }
}






