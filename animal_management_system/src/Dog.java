public class Dog extends Mammal{
    Food favorite = Food.MEAT;

    public Dog(String name, int age, int type) {
        super(name, age, type);
    }

    @Override
    void makeSound() {
        System.out.println("멍멍!");
    }

    @Override
    int getFavorite() {
        return favorite.val;
    }
}
