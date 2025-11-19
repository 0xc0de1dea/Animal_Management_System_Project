classDiagram
    class Animal {
        <<abstract>>
        String name
        int age
        int type
        int hunger
        int happiness

        makeSound() void
        getFavorite() int
        eat(int amount) void
        enjoy(int amount) void
        getState() void
    }

    class Bird {

    }

    class Mammal {

    }

    class Reptile {

    }

    Animal <|-- Bird
    Animal <|-- Mammal
    Animal <|-- Reptile

    class Food {
        <<enumeration>>
        MEAT
        FISH
        PLANT
    }

    class Dog {
        Food favorite

        makeSound() void
        getFavorite() int
    }

    class Cat {
        Food favorite

        makeSound() void
        getFavorite() int
    }

    class Lion {
        Food favorite

        makeSound() void
        getFavorite() int
    }

    class Elephant {
        Food favorite

        makeSound() void
        getFavorite() int
        +sprinkle() void
    }

    Mammal <|-- Dog
    Mammal <|-- Cat
    Mammal <|-- Lion
    Mammal <|-- Elephant

    class Eagle {
        Food favorite

        makeSound() void
        getFavorite() int
        +fly() void
    }

    class Penguin {
        Food favorite

        makeSound() void
        getFavorite() int
        +swim() void
    }

    Bird <|-- Eagle
    Bird <|-- Penguin

    class Snake {
        Food favorite

        makeSound() void
        getFavorite() int
    }

    class Turtle {
        Food favorite

        makeSound() void
        getFavorite() int
    }

    Reptile <|-- Snake
    Reptile <|-- Turtle

    class Flyable {
        <<interface>>
        fly() void
    }

    class Swimable {
        <<interface>>
        swim() void
    }

    class Sprinkleable {
        <<interface>>
        sprinkle() void
    }

    Eagle ..|> Flyable
    Penguin ..|> Swimable
    Elephant ..|> Sprinkleable