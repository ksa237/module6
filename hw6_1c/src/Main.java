import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long minorPeople = persons.stream()
                .filter( (Person person)->{ return person.getAge() < 18; })
                .count();

        System.out.println(minorPeople);


        List<String> listConscript = persons.stream()
                .filter(p-> {
                    boolean b = p.getSex() == Sex.MAN && p.getAge()>=18 && p.getAge()<=27  ;
                    return b;
                }).map(Person::getFamily )
                .collect(Collectors.toList());

        System.out.println(listConscript);

        List<String> listWokers = persons.stream()
                .filter(p -> {
                    boolean bm = false;
                    boolean bw = false;
                    if (p.getSex() == Sex.MAN) {
                        bm = p.getEducation() == Education.HIGHER && p.getAge() >= 18 && p.getAge() <= 65;
                    } else {
                        bw = p.getEducation() == Education.HIGHER && p.getAge() >= 18 && p.getAge() <= 60;
                    }
                    return bm || bw;
                })
                .map(Person::getFamily)
                .limit(100)
                .sorted(Comparator.comparing(String::toString))
                .collect(Collectors.toList());

        System.out.println(listWokers);


    }


}
