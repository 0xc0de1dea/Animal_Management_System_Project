public class Elephant extends Mammal implements Sprinkleable {
    Food favorite = Food.PLANT;

    public Elephant(String name, int age, int type) {
        super(name, age, type);
    }

    @Override
    void makeSound() {
        System.out.println("뿌우!");
    }

    @Override
    int getFavorite() {
        return favorite.val;
    }

    @Override
    public void sprinkle() {
        System.out.println("물뿜기를 사용 하였습니다! 행복도가 크게 증가하였습니다.");
        this.happiness += 20;
    }
}
