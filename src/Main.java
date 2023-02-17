import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*
            Задание 1
         */
        System.out.println("\033[4mЗадание 1\033[0m");
        Comparator<Integer> integerComparator1 = (o1, o2) -> o1 >= o2 ? o1 > o2 ? 1 : 0 : -1;
        BiConsumer<Integer,Integer> biConsumer1 = (o, o2) -> System.out.println("Минимальный элемент: "+o+", максимальный элемент: "+o2);

        List<Integer> list1 = new ArrayList<>();
        for (int i = -10; i <= 10; i++){
            list1.add(new Random().nextInt(100));
        }
        System.out.println(list1);
        Stream<Integer> integerStream1 = list1.stream();
        findMinMax(integerStream1,integerComparator1,biConsumer1);
        /*
            Задание 2
         */
        task2(list1);
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer){
        List<T> list1 = stream.sorted(order).collect(Collectors.toList());
        if(list1.size() > 0) {
            T min = list1.get(0);
            T max = list1.get(list1.size() - 1);
            minMaxConsumer.accept(min,max);
        }else {
            minMaxConsumer.accept(null,null);
        }
    }
    public static void task2(List<Integer> list){
        System.out.println("\n\033[4mЗадание 2\033[0m");

        System.out.println("Количество чётных числет в списке: "+list.stream().filter(x -> x%2==0).count());
        System.out.println("Список чётных чисел:");
        list.stream().filter(x -> x%2==0).forEach(x->System.out.print(x+" "));
    }
}