import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Zoo zoo = new Zoo();

        while (true){
            System.out.print("""
                === 동물원 관리 시스템 ===
                1. 동물 등록
                2. 동물 목록 보기
                3. 동물과 놀기
                4. 먹이주기
                5. 동물 상태 확인
                6. 울음소리 듣기
                7. 종료
                메뉴를 선택하세요:\s""");

            int choice;

            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("올바르지 않은 명령입니다.");
                sc.nextLine();
                continue;
            }

            if (choice == 1){
                String name;
                int age;
                String type;

                String[] list = new String[] {"고양이", "강아지"};

                System.out.print("동물 이름을 입력하세요: ");
                name = sc.next();
                sc.nextLine();

                while (true){
                    System.out.print("동물 나이를 입력하세요: ");

                    try {
                        age =  sc.nextInt();
                        sc.nextLine();

                        if (age < 0){
                            System.out.println("동물 나이는 음수가 될 수 없습니다.");
                            continue;
                        }

                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("숫자를 입력해주세요.");
                        sc.nextLine();
                    }
                }

                while (true){
                    System.out.print("동물 종류를 선택하세요 (1. 고양이 2. 강아지): ");
                    int num;

                    try {
                        num =  sc.nextInt();
                        sc.nextLine();

                        if (num <= 0 || num > 2){
                            System.out.println("올바른 종류를 선택해주세요.");
                            continue;
                        }

                        type = list[num - 1];
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("숫자를 입력해주세요.");
                        sc.nextLine();
                    }
                }

                Animal animal = null;

                if (type.equals("고양이")){
                    animal = new Cat(name, age);
                } else if (type.equals("강아지")){
                    animal = new Dog(name, age);
                }

                zoo.registerAnimal(animal);
            } else if (choice == 2){
                String list = zoo.showAnimals();

                if (list.isEmpty()){
                    System.out.println("등록된 동물 목록이 없습니다.");
                    System.out.println();
                } else {
                    System.out.println(zoo.showAnimals());
                }
            } else if (choice == 3){
                int id;

                while (true){
                    System.out.println("같이 놀 동물 번호를 선택하세요.");

                    try {
                        id = sc.nextInt();
                        sc.nextLine();
                        break;
                    } catch (InputMismatchException e){
                        System.out.println("숫자를 입력하세요.");
                        sc.nextLine();
                    }
                }

                zoo.enjoy(id);
            } else if (choice == 4){
                int id;

                while (true){
                    System.out.println("먹이를 줄 동물 번호를 선택하세요.");

                    try {
                        id = sc.nextInt();
                        sc.nextLine();
                        break;
                    } catch (InputMismatchException e){
                        System.out.println("숫자를 입력하세요.");
                        sc.nextLine();
                    }
                }

                zoo.feed(id);
            } else if (choice == 5){
                int id;

                while (true){
                    System.out.println("상태를 확인할 동물 번호를 선택하세요.");

                    try {
                        id = sc.nextInt();
                        sc.nextLine();
                        break;
                    } catch (InputMismatchException e){
                        System.out.println("숫자를 입력하세요.");
                        sc.nextLine();
                    }
                }

                zoo.getState(id);
            } else if (choice == 6){
                int id;

                while (true){
                    System.out.println("울음소리를 들을 동물 번호를 선택하세요.");

                    try {
                        id = sc.nextInt();
                        sc.nextLine();
                        break;
                    } catch (InputMismatchException e){
                        System.out.println("숫자를 입력하세요.");
                        sc.nextLine();
                    }
                }

                zoo.makeSound(id);
            } else if (choice == 7){
                break;
            } else {
                System.out.println("올바른 번호를 선택하세요.");
            }
        }
    }
}
