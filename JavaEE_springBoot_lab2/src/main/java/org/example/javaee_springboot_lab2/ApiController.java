package org.example.javaee_springboot_lab2;



import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;


@RestController
@RequestMapping("/api")
public class ApiController {

    //1)API,который выводит текущее время
    @GetMapping("/time")
    public String time() {
        LocalDateTime now = LocalDateTime.now();
        return now.toString();
    }

    //2)Параметр n,чтобы в результате был вывод от 1 до n
    @GetMapping("/numbers/{n}")
    public List<Integer> numbers(@PathVariable int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) {
                list.add(i);
            }

        }
        return list;
    }

    //3)Случайное число от 1 до 500
    @GetMapping("/random")
    public String random() {
        Random random = new Random(500);
        return random.nextFloat() + "";
    }

    //4)Вводим параметр n - результат n-число Фиббоначи
    @GetMapping("/fibonacci/{n}")
    public int[] fibonacci(@PathVariable int n) {
        int[] arr = new int[n+1];


        int sum;

        for (int i = 0; i < n; i++) {

            arr[i] = i * 5;
        }

        return arr;
    }

    //5)Параметр вводим в строку и сделать обратынй вывод
    @GetMapping("/reverse/{input}")
    public int reverse(@PathVariable String input) {
        return input.length();
    }

//        public String getCurrentDayOfWeek() {
//            LocalDate today = LocalDate.now();
//            DayOfWeek dayOfWeek = today.getDayOfWeek();
//            return "Today is: " + dayOfWeek;
//        }

    @GetMapping("/today")
    public String today() {
        LocalDate day = LocalDate.now();
        DayOfWeek dayOfWeek = day.getDayOfWeek();
        return dayOfWeek + "";


    }

    @GetMapping("/week")
    public String week() {
        LocalDate date = LocalDate.now();
        int weekOfMonth = date.get(WeekFields.of(Locale.getDefault()).weekOfMonth());
        return weekOfMonth + "";

    }

    @GetMapping("/simple/{n}")
    public int[] simple(@PathVariable int n) {

        int[] list = new int[20];
        for (int i = 0; i <= n; i++) {
            if (isPrime(i)) {
                list[i] = i;
            }
        }
        return list;
    }





    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }

        }
        return true;
    }

}