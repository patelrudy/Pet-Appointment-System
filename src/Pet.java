/*
In order to help learn course concepts,
I worked on the homework with Leul Webute,
discussed homework topics and issues with Leul Webute,
and/or consulted related material that can be found at NA.
*/

/**
 * This is an abstract class Pet.
 * @author Rudreshbhai Patel
 * @version 1.2
 */
public abstract class Pet {
    private String name;
    private double health;
    private int painLevel;

    /**
     * This is a constructor for Pet which has three parameters.
     * @param name String typed name of the pet.
     * @param health double type health of the pet.
     * @param painLevel int type pain level of the pet.
     */
    public Pet(String name, double health, int painLevel) {
        this.name = name;

        if (health > 1.0) {
            health = 1.0;
        }
        if (health < 0.0) {
            health = 0.0;
        }
        this.health = health;

        if (painLevel > 10) {
            painLevel = 10;
        }
        if (painLevel < 1) {
            painLevel = 1;
        }
        this.painLevel = painLevel;
    }

    /**
     * A getter method to get the name of the pet.
     * @return String type name of the pet
     */
    public String getName() {
        return name;
    }

    /**
     * A getter method to get health of the pet.
     * @return returns health of the pet.
     */
    public double getHealth() {
        return health;
    }

    /**
     * a getter method for pain level of the pet.
     * @return pain level of the pet.
     */
    public int getPainLevel() {
        return painLevel;
    }

    /**
     * an abstract method to make sure all subclass/child class has a treat method.
     * @return minutes taken to treat a pet in int type.
     */
    public abstract int treat();

    /**
     * a method to print what pet is suppose to speak.
     */
    public void speak() {
        if (painLevel > 5) {
            System.out.println("HELLO! MY NAME IS " + name);
        } else {
            System.out.println("Hello! My name is " + name);
        }
    }

    /**
     * a method to check if two objects of pet are equal or not.
     * @param o an object to compare Pet with.
     * @return returns a boolean value.
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Pet)) {
            return false;
        }

        Pet pet = (Pet) o;
        return (name == pet.name);
    }

    /**
     * this method sets the health value and painLevel.
     * heals the pet.
     */
    protected void heal() {
        health = 1.0;
        painLevel = 1;
    }
}
