import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

//Reference https://blog.csdn.net/io_field/article/details/54971761
public class HelloStream {
    public static void main(String[] args){
        Stream.of(1,2,3).forEach(i -> System.out.println(i));
        StudentGenerator.generateStudentList(2).stream().forEach(student -> System.out.println(student));

        Stream.iterate(1, i -> i + 1)
                .limit(2)
                .forEach(System.out::println);
        System.out.println(">>>>>Convert Array to Stream");
        int[] ids = new int[]{1, 2, 3};
        Arrays.stream(ids).forEach(System.out::println);

        System.out.println(">>>>>Concat Stream");
        Stream.concat(Stream.of(1,2), Stream.of(3,4)).forEach(System.out::println);

        System.out.println(">>>>>Distinct Stream");
        Stream.of(1,2,3,4,2,3,4).distinct().forEach(System.out::println);

       System.out.println(">>>>>>Filter Stream");
       Stream.of(1,2,3,4).filter(i -> i > 3).forEach(System.out::println);

       System.out.println(">>>>>>Map Stream - upper case letter");
       Stream.of("a", "b", "c").map(i -> i.toUpperCase()).forEach(System.out::println);

       System.out.println(">>>>>>Map Stream - map to long");
       StudentGenerator.generateStudentList(2).stream().map(student -> student.getId()).forEach(System.out::println);

       System.out.println(">>>>>>Peek Stream");
       Stream.of("a", "b").peek(i -> System.out.println("Consume " + i)).forEach(System.out::println);

       System.out.println(">>>>>Skip Stream");
       Stream.of("a", "b").skip(1).forEach(System.out::println);

       System.out.println(">>>>>Sorted Stream");
       Stream.of(2,3,4,1,8,3).sorted(Comparator.reverseOrder()).forEach(System.out::println);

       System.out.println(">>>>>Stream count");
       System.out.println(Stream.of(1,2,3).count());

       System.out.println(">>>>>Stream forEachOrdered");
       Stream.of(2,4,3,1).forEachOrdered(System.out::println);

       System.out.println(">>>>>Stream max");
       System.out.println(Stream.of(1,2,3).max(Comparator.comparingInt(Integer::intValue)).get());

       System.out.println(">>>>>Stream min");
       System.out.println(Stream.of(1,2,3).min(Comparator.comparingInt(Integer::intValue)).get());

    }
}
