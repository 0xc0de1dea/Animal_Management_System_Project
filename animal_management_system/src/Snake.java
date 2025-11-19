public class Snake extends Reptile {
    Food favorite = Food.MEAT;

    public Snake(String name, int age, int type) {
        super(name, age, type);
    }

    @Override
    void makeSound() {
        System.out.println("쉬이!");
    }

    @Override
    int getFavorite() {
        return favorite.val;
    }
}
