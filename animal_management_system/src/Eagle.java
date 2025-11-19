public class Eagle extends Bird implements Flyable {
    Food favorite = Food.MEAT;

    public Eagle(String name, int age, int type) {
        super(name, age, type);
    }

    @Override
    void makeSound() {
        System.out.println("끼이익!");
    }

    @Override
    int getFavorite() {
        return favorite.val;
    }

    @Override
    public void fly() {
        System.out.println("날기를 사용 하였습니다! 행복도가 크게 증가하였습니다.");
        this.happiness += 20;
    }
}
