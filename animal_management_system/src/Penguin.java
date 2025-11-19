public class Penguin extends Bird implements Swimmable {
    Food favorite = Food.FISH;

    public Penguin(String name, int age, int type) {
        super(name, age, type);
    }

    @Override
    void makeSound() {
        System.out.println("꺅꺅!");
    }

    @Override
    int getFavorite() {
        return favorite.val;
    }

    @Override
    public void swim() {
        System.out.println("수영하기를 사용 하였습니다! 행복도가 크게 증가하였습니다.");
        this.happiness += 20;
    }
}
