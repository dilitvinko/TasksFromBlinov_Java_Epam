package onlyTests.Exceptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FindStudent {
    public List<Student> findBiggerAgeStudent(int age, List<Student> students){
        ArrayList<Student> bigAge = new ArrayList<>();
        Iterator it = students.iterator();
        while (it.hasNext()){
            Student current = (Student) it.next();
            if (current.getAge() >= age) {
                bigAge.add(current);
            }

        }
        return bigAge;
    }

    public List<Student> findBiggerAgeStudentV2(int age, List<Student> students){
        ArrayList<Student> bigAge = new ArrayList<>();
        List<? super Student> st1 = new ArrayList<>();
        st1.add(new Student("qwe",23));
        for (Student st : students) {
            if (st.getAge() >= age) {
                bigAge.add(st);
            }
        }
        return bigAge;
    }

}
