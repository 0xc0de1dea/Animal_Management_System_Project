public class Turtle extends Reptile {
    Food favorite = Food.FISH;

    public Turtle(String name, int age, int type) {
        super(name, age, type);
    }

    @Override
    void makeSound() {
        System.out.println("...");
    }

    @Override
    int getFavorite() {
        return favorite.val;
    }
}
