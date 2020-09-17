package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 2, 4, 6, 8, 5);
        numbers.sort(Comparator.comparing(Object::toString));
        System.out.println("first sorted list " + numbers);

        List<Integer> produces = Arrays.asList(1, 7, 4, 6);
        produces.sort(Comparator.comparing(Object::toString));
        System.out.println("second sorted list " + produces);

        mergeLists(numbers, produces);
    }

    private static List<Integer> mergeLists(List<Integer> numbers, List<Integer> produces) {
        if (isCollectionEmpty(numbers) ^ isCollectionEmpty(produces)) {
            System.out.println("^");
            return isCollectionEmpty(numbers) ? produces : numbers;
        }
        if (isCollectionEmpty(numbers) && isCollectionEmpty(produces)) {
            System.out.println("&&");
            return Collections.emptyList();
        }
        return numbers.get(numbers.size() - 1) > produces.get(produces.size() - 1) ?
                sortBoth(produces, numbers) : sortBoth(numbers, produces);
    }

    private static List<Integer> sortBoth(List<Integer> numbers, List<Integer> produces) {
        int index = 0;
        List<Integer> sortBoth1 = new ArrayList<>();
        for (int number : numbers) {
                while (number > produces.get(index)) {
                    sortBoth1.add(produces.get(index));
                    ++index;
                }
                sortBoth1.add(number);
        }
        sortBoth1.addAll(produces.subList(index, produces.size()));
        System.out.println("sorted " + sortBoth1);
        return sortBoth1;
    }

    private static <T> boolean isCollectionEmpty(Collection<T> list) {
        return Objects.isNull(list) || list.isEmpty();
    }
}