import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Zoo zoo = new Zoo();

        while (true) {
            System.out.print("""
                    === 동물원 관리 시스템 ===
                    1. 동물 등록
                    2. 동물 목록 보기
                    3. 동물과 놀기
                    4. 먹이주기
                    5. 동물 상태 확인
                    6. 특별 능력 사용
                    7. 사육사 종류 보기
                    8. 통계 보기
                    9. 종료
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

            if (choice == 1) {
                String name;
                int age;
                int type;

                System.out.print("동물 이름을 입력하세요: ");
                name = sc.next();
                sc.nextLine();

                while (true) {
                    System.out.print("동물 나이를 입력하세요: ");

                    try {
                        age = sc.nextInt();
                        sc.nextLine();

                        if (age < 0) {
                            System.out.println("동물 나이는 음수가 될 수 없습니다.");
                            continue;
                        }

                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("숫자를 입력해주세요.");
                        sc.nextLine();
                    }
                }

                while (true) {
                    System.out.print("동물 종류를 선택하세요 (1. 고양이 2. 강아지 3. 사자 4. 코끼리 5. 독수리 6. 펭귄 7. 뱀 8. 거북이): ");

                    try {
                        type = sc.nextInt();
                        sc.nextLine();

                        if (type <= 0 || type > 8) {
                            System.out.println("올바른 종류를 선택해주세요.");
                            continue;
                        }

                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("숫자를 입력해주세요.");
                        sc.nextLine();
                    }
                }

                Animal animal = null;

                if (type == 1) {
                    animal = new Cat(name, age, type);
                } else if (type == 2) {
                    animal = new Dog(name, age, type);
                } else  if (type == 3) {
                    animal = new Lion(name, age, type);
                } else if (type == 4){
                    animal = new Elephant(name, age, type);
                } else if (type == 5){
                    animal = new Eagle(name, age, type);
                } else if (type == 6){
                    animal = new Penguin(name, age, type);
                } else if (type == 7){
                    animal = new Snake(name, age, type);
                } else if (type == 8){
                    animal = new Turtle(name, age, type);
                }

                zoo.registerAnimal(animal);
            } else if (choice == 2) {
                String list = zoo.showAnimals();

                if (list.isEmpty()) {
                    System.out.println("등록된 동물 목록이 없습니다.");
                    System.out.println();
                } else {
                    System.out.println(zoo.showAnimals());
                }
            } else if (choice == 3) {
                int id;

                while (true) {
                    System.out.println("같이 놀 동물 번호를 선택하세요.");

                    try {
                        id = sc.nextInt();
                        sc.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("숫자를 입력하세요.");
                        sc.nextLine();
                    }
                }

                int zookeeper;

                while (true) {
                    System.out.print("사육사를 선택하세요. (1. 조류 전문가 2. 포유류 전문가 3. 파충류 전문가): ");

                    try {
                        zookeeper = sc.nextInt();
                        sc.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("숫자를 입력하세요.");
                        sc.nextLine();
                    }
                }

                zoo.enjoy(id, zookeeper);
            } else if (choice == 4) {
                int id;

                while (true) {
                    System.out.println("먹이를 줄 동물 번호를 선택하세요.");

                    try {
                        id = sc.nextInt();
                        sc.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("숫자를 입력하세요.");
                        sc.nextLine();
                    }
                }

                int feed;

                while (true) {
                    System.out.print("먹이를 선택하세요. (1. 고기 2. 물고기 3. 식물): ");

                    try {
                        feed = sc.nextInt();
                        sc.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("숫자를 입력하세요.");
                        sc.nextLine();
                    }
                }

                zoo.feed(id, feed);
            } else if (choice == 5) {
                int id;

                while (true) {
                    System.out.println("상태를 확인할 동물 번호를 선택하세요.");

                    try {
                        id = sc.nextInt();
                        sc.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("숫자를 입력하세요.");
                        sc.nextLine();
                    }
                }

                zoo.getState(id);
            } else if (choice == 6) {
                int id;

                while (true) {
                    System.out.println("특별 능력을 사용할 동물 번호를 선택하세요.");

                    try {
                        id = sc.nextInt();
                        sc.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("숫자를 입력하세요.");
                        sc.nextLine();
                    }
                }

                zoo.activeAbility(id);
            } else if (choice == 7) {
                System.out.println("사육사의 종류는 다음과 같습니다.");
                System.out.println("1. 조류 전문가");
                System.out.println("2. 포유류 전문가");
                System.out.println("3. 파충류 전문가");
                System.out.println();
            } else if (choice == 8) {
                ArrayList<Animal> animals = zoo.getAnimals();

                if (animals.isEmpty()) {
                    System.out.println("동물 목록이 없습니다.");
                    System.out.println();
                    continue;
                }

                int totalAmount = animals.size();
                int totalHappiness = 0;
                StringBuilder sb = new StringBuilder();

                Animal mostHappyAnimal = null;
                int tmp = -1;

                for (Animal animal : animals) {
                    totalHappiness += animal.happiness;

                    if (animal.hunger > 50){
                        sb.append(AnimalType.list[animal.type - 1]).append('(').append(animal.name).append(')').append(", ");
                    }

                    if (animal.happiness > tmp){
                        tmp = animal.happiness;
                        mostHappyAnimal = animal;
                    }
                }

                if (!sb.isEmpty()) sb.delete(sb.length() - 2, sb.length());

                double averageHappiness = totalHappiness / (double)totalAmount;

                System.out.println("=== 동물원 통계 ===");
                System.out.printf("- 전체 동물 수: %d마리\n", totalAmount);
                System.out.printf("- 평균 행복도: %f\n", averageHappiness);
                System.out.println("- 배고픈 동물: " + sb.toString());
                System.out.println("- 가장 행복한 동물: " + AnimalType.list[mostHappyAnimal.type - 1] + "(" + mostHappyAnimal.name + ") - " + mostHappyAnimal.happiness);
                System.out.println();
            } else if (choice == 9){
                break;
            } else {
                System.out.println("올바른 번호를 선택하세요.");
            }
        }
    }
}
