

/**
 * This class represents Cat which extends Pet.
 * @author Rudreshbhai Patel
 * @version 1.2
 */
public class Cat extends Pet {
    private int miceCaught;

    /**
     * Constructor for the Cat with four parameters.
     * @param name Name of the Cat.
     * @param health Health of the Cat.
     * @param painLevel Pain Level of the Cat.
     * @param miceCaught An int to represent how many mice has Cat caught.
     */
    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        if (miceCaught < 0) {
            miceCaught = 0;
        }
        this.miceCaught = miceCaught;
    }

    /**
     * A Constructor for the Cat with three parameters.
     * @param name Name of the Cat.
     * @param health Health of the Cat.
     * @param painLevel Pain level of the Cat.
     */
    public Cat(String name, double health, int painLevel) {
        super(name, health, painLevel);
        miceCaught = 0;
    }

    /**
     * A getter method to get the number of the mice Cat has caught.
     * @return number of mice Cat has caught.
     */
    public int getMiceCaught() {
        return miceCaught;
    }

    @Override
   public int treat() {
        int minutes = 0;
        double minutesInDouble;
        if (miceCaught < 4) {
            minutesInDouble = (getPainLevel() * 2) / getHealth();
            minutes = (int) Math.round(minutesInDouble);
        }
        if (miceCaught >= 4 && miceCaught <= 7) {
            minutesInDouble = getPainLevel() / getHealth();
            minutes = (int) Math.round(minutesInDouble);
        }
        if (miceCaught > 7) {
            minutesInDouble = getPainLevel() / (getHealth() * 2);
            minutes = (int) Math.round(minutesInDouble);
        }
        heal();
        return minutes;
    }

    /**
     *  a method to print what Cat is suppose to speak.
     *  It also calls the speak method of the Parent Class.
     */
    public void speak() {
        super.speak();
        int printNumberOfTimes = miceCaught;
        for (int i = 0; i < printNumberOfTimes; i++) {
            if (printNumberOfTimes > 5) {
                System.out.print("MEOW ");
            } else {
                System.out.print("meow ");
            }
        }
        System.out.println();
    }

    /**
     * An equals method to see if the Cat is same as another object.
     * @param o an object to compare Cat with.
     * @return a boolean value.
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Cat)) {
            return false;
        }
        Cat cat = (Cat) o;
        return (super.equals(cat)) && (miceCaught == cat.miceCaught);
    }
}
