package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int lastNo = 0;
        WiseSaying[] wiseSayings = new WiseSaying[100];
        int lastIndex = 0;

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();

            if (command.equals("등록")) {
                System.out.print("명언 : ");
                String saying = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                lastNo++;

                WiseSaying wiseSaying = new WiseSaying();
                wiseSaying.id = lastNo;
                wiseSaying.saying = saying;
                wiseSaying.author = author;

                wiseSayings[lastIndex++] = wiseSaying;

                System.out.println("%d번 명언이 등록되었습니다.".formatted(lastNo));
            }
            else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = lastIndex - 1; i >= 0; i--) {
                    WiseSaying target = wiseSayings[i];

                    if (target == null) {
                        break;
                    }
                    System.out.println("%d / %s / %s".formatted(target.id, target.saying, target.author));
                }
            }
            else if (command.equals("종료")) {
                break;
            }
        }
    }
}