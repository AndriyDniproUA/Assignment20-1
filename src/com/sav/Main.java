package com.sav;

import com.sav.entities.Order;
import com.sav.handlers.*;
import com.sav.utils.OrderBuilder;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
// 1) Используя паттерн Цепочка обязоностей реализовать цепочку обработки заказа пици
//        шаг 1: проверка полей заявки и вывод сообщения
//        шаг 2: запись заказа в конец файла заказов
//        шаг 3: вывод информации об успешном заказе

        String filePath = "orders.txt";

        OrderHandler step1 = new ValidateOrderHandler();
        OrderHandler step2 = new SaveOrderHandler(filePath);
        OrderHandler step3 = new PrintOrderHandler();

        step1.setNext(step2);
        step2.setNext(step3);

        Order order = createOrder();
        step1.handle(order);

    }

    public static Order createOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter order ID: ");
        String ID = sc.nextLine();
        System.out.print("Enter client's name: ");
        String from = sc.nextLine();
        System.out.print("Enter client's order: ");
        String text = sc.nextLine();

        return OrderBuilder.builder()
                .ID(ID)
                .from(from)
                .text(text)
                .build();
    }

}
