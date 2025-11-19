public class Lion extends Mammal{
    Food favorite = Food.MEAT;

    public Lion(String name, int age, int type) {
        super(name, age, type);
    }

    @Override
    void makeSound() {
        System.out.println("으르렁!");
    }

    @Override
    int getFavorite() {
        return favorite.val;
    }
}
