import java.util.Random;

public abstract class Animal {
    String name;
    int age;
    int hunger;
    int happiness;

    public Animal(String name, int age) {
        Random rand = new Random();

        this.name = name;
        this.age = age;
        hunger = rand.nextInt(51) + 50;
        happiness = rand.nextInt(50) + 1;
    }

    abstract void makeSound();

    void eat(){
        System.out.println("배고픔 수치가 10 감소하였습니다.");
        
        this.hunger -= 10;

        if (this.hunger < 0) {
            System.out.println("배고픔 수치가 0으로 떨어졌습니다.\n행복도도 0으로 떨어집니다.");
            this.hunger = 0;
            this.happiness = 0;
        }
    }

    void enjoy(){
        System.out.println("행복도가 10 증가하였습니다.");
        
        this.happiness += 10;

        if (this.happiness > 100){
            System.out.println("행복도가 MAX입니다.");
            this.happiness = 100;
        }
    }

    void getState(){
        System.out.println("배고픔 수치: " + this.hunger);
        System.out.println("행복도: " + this.happiness);

        if (hunger == 0){
            System.out.println("몸에 기운이 모두 빠져 움직일 수 없습니다.");
        } else if (hunger > 0 && hunger <= 33){
            System.out.println("너무 배고파합니다.");
        } else if (hunger > 33 && hunger <= 66){
            System.out.println("조금 배고파합니다.");
        } else if (hunger > 66 && hunger <= 99){
            System.out.println("적당히 배불러합니다.");
        } else {
            System.out.println("포만감이 MAX입니다.");
        }

        if (happiness == 0){
            System.out.println("불행해 합니다.");
        } else if (happiness > 0 && happiness <= 25){
            System.out.println("기분이 매우 안좋습니다.");
        } else if (happiness > 25 && happiness <= 50){
            System.out.println("기분이 조금 안좋습니다.");
        } else if (happiness > 50 && happiness <= 75){
            System.out.println("기분이 조금 좋습니다.");
        } else if (happiness > 75 && happiness <= 99){
            System.out.println("기분이 매우 좋습니다.");
        } else {
            System.out.println("행운아라고 느낍니다.");
        }
    }
}
