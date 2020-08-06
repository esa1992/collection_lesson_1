package com.myCompany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        1. Создать список чисел. Добавить 20 рандомных чисел от 1 до 1000 в список.
        Произвести сортировку по возрастанию и убыванию.
         */
        System.out.println("*** Задание №1 ***");
        List<Integer> numbersList = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            numbersList.add(getRandomInt(1000));
        }

        System.out.println("Заполнили список рандомными числами: " + numbersList);

        Collections.sort(numbersList);
        System.out.println("Произвели сортировку по возростанию: " + numbersList);

        Collections.reverse(numbersList);
        System.out.println("Произвели сортировку по убыванию: " + numbersList);

        /*
        2. Создать список строк. Добавить названия город. Произвести сортировку.
         */
        System.out.println("\n*** Задание №2 ***");
        List<String> citiesList = new ArrayList<>();

        citiesList.add("Ош");
        citiesList.add("Бишкек");
        citiesList.add("Нарын");
        citiesList.add("Чолпон-Ата");
        citiesList.add("Балыкчы");
        citiesList.add("Сокулук");
        citiesList.add("Талас");

        System.out.println("Создали список городов: " + citiesList);

        Collections.sort(citiesList);
        System.out.println("Произвели сортировку: " + citiesList);

        /*
        3. Создать 2 списка чисел. Добавить по 10 рандомных чисел от 1 до 10000.
        Узнать, есть ли пересечения у этих двух списков.
         */
        System.out.println("\n*** Задание №3 ***");

        List<Integer> numbersList1 = new ArrayList<>();
        List<Integer> numbersList2 = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            numbersList1.add(getRandomInt(10000));
            numbersList2.add(getRandomInt(10000));
        }

        System.out.println("Заполнили первый список числами: " + numbersList1);
        System.out.println("Заполнили второй список числами: " + numbersList2);

        boolean isDisjoint = Collections.disjoint(numbersList1, numbersList2);

        if (isDisjoint){
            System.out.println("Переечений у двух списков нет!");
        }else{
            System.out.println("Пересечения есть!");
        }

        /*
        4. Создать метод для предыдущего задания, который покажет,
        сколько попыток инициализации списка было, чтоб появилось пересечение между списками.
         */
        System.out.println("\n*** Задание №4 ***");

        System.out.println("Запустим метод отображения количества инициализаций коллекций");
        doDisjointTrue(numbersList1, numbersList2);


    }

    private static void doDisjointTrue(List<Integer> numbersList1, List<Integer> numbersList2) {

        boolean isDisjoint = true;
        int count = 0;

        while (isDisjoint){

            isDisjoint = Collections.disjoint(numbersList1, numbersList2);
            if (isDisjoint){

                numbersList1.clear();
                numbersList2.clear();

                for (int i = 0; i < 10; i++){
                    numbersList1.add(getRandomInt(10000));
                    numbersList2.add(getRandomInt(10000));
                }
            }
            count++;
        }

        System.out.println("Количество инициализаций, пока не появились пересечения м/у списками: " + count);
        /*Произведем сортировку, чтобы проще было найти пересекающиеся элементы глазками*/
        Collections.sort(numbersList1);
        Collections.sort(numbersList2);

        System.out.println("Первая коллекций: " + numbersList1);
        System.out.println("Вторая коллекций: " + numbersList2);

    }

    private static int getRandomInt (int maxValue){

        double a =  Math.random()*maxValue;
        int b = (int) a;
        return b;

    }
}
