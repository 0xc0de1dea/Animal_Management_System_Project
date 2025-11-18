import java.util.ArrayList;

public class Zoo {
    ArrayList<Animal> animals;

    public Zoo(){
        animals = new ArrayList<>();
    }

    public ArrayList<Animal> getAnimals(){
        return animals;
    }

    public void registerAnimal(Animal animal){
        animals.add(animal);
    }

    public String showAnimals(){
        StringBuilder sb = new StringBuilder();
        int id = 1;

        for (Animal animal : animals){
            String type = "";

            if (animal instanceof Cat){
                type = "고양이";
            } else if (animal instanceof Dog){
                type = "강아지";
            }

            sb.append(id++).append(". ").append(animal.name).append(" (").append(type).append(", ").append(animal.age).append("살)").append('\n');
        }

        return sb.toString();
    }

    public boolean check(int id){
        if (id > animals.size()){
            System.out.println("해당 번호의 동물이 존재하지 않습니다.");
            return false;
        }

        return true;
    }

    public void enjoy(int id){
        boolean check = check(id);

        if (check) animals.get(id - 1).enjoy();
    }

    public void feed(int id){
        boolean check = check(id);

        if (check) animals.get(id - 1).eat();
    }

    public void getState(int id){
        boolean check = check(id);

        if (check) animals.get(id - 1).getState();
    }

    public void makeSound(int id){
        boolean check = check(id);

        if (check) animals.get(id - 1).makeSound();
    }
}
