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

    public String getAnimal(int type){
        return AnimalType.list[type - 1];
    }

    public String showAnimals(){
        StringBuilder sb = new StringBuilder();
        int id = 1;

        for (Animal animal : animals){
            String type = getAnimal(animal.type);
            sb.append(id++).append(". ").append(animal.name).append(" (").append(type).append(", ").append(animal.age).append("살)").append('\n');
        }

        return sb.toString();
    }

    public boolean check(int id, int num){
        if (id > animals.size() || num <= 0 || num > 3){
            System.out.println("해당 번호가 존재하지 않습니다.");
            return false;
        }

        return true;
    }

    public int getType(int id){
        Animal animal = animals.get(id - 1);

        if (animal instanceof Bird){
            return 1;
        } else if (animal instanceof Mammal){
            return 2;
        } else if (animal instanceof Reptile){
            return 3;
        }

        return 0;
    }

    public void enjoy(int id, int zookeeper){
        boolean check = check(id, zookeeper);
        int type = getType(id);

        int amount = 10;

        if (zookeeper == type){
            amount += 5;
        }

        if (check) animals.get(id - 1).enjoy(amount);
    }

    public void feed(int id, int feed){
        boolean check = check(id, feed);

        int amount = 10;

        Animal animal = animals.get(id - 1);

        if (animal.getFavorite() == feed){
            amount += 5;
        }

        if (check) animals.get(id - 1).eat(amount);
    }

    public void getState(int id){
        boolean check = check(id, 1);

        if (check) animals.get(id - 1).getState();
    }

    public void makeSound(int id){
        boolean check = check(id, 1);

        if (check) animals.get(id - 1).makeSound();
    }

    public void activeAbility(int id){
        boolean check = check(id, 1);

        if (check){
            Animal animal = animals.get(id - 1);

            if (animal instanceof Eagle || animal instanceof Elephant || animal instanceof Penguin){
                if (animal instanceof Eagle){
                    ((Eagle) animal).fly();
                } else if (animal instanceof Elephant){
                    ((Elephant) animal).sprinkle();
                } else if (animal instanceof Penguin){
                    ((Penguin) animal).swim();
                }
            } else {
                System.out.println("해당 동물은 능력이 없습니다.");
            }
        }
    }
}
