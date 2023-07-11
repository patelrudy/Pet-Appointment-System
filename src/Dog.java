/**
 * This class represents a Dog which extends Pet.
 * @author Rudreshbhai Patel
 * @version 1.2
 */
public class Dog extends Pet {
    private double droolRate;

    /**
     * This is a constructor for Dog which accepts four parameters.
     * @param name String type name of the Dog.
     * @param health double type health of the Dog.
     * @param painLevel int type pain level of the Dog.
     * @param droolRate double type parameter for the rate of drooling of Dog.
     */
    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        if (droolRate <= 0) {
            droolRate = 0.5;
        }
        this.droolRate = droolRate;
    }

    /**
     * This is a constructor of the Dog which accepts 3 parameters.
     * @param name String type name of the Dog.
     * @param health double type health of the Dog.
     * @param painLevel int type pain level of the Dog.
     */
    public Dog(String name, double health, int painLevel) {
        super(name, health, painLevel);
        droolRate = 5.0;
    }

    /**
     * a getter method to get the drool rate of the Dog.
     * @return returns the drool rate of the Dog.
     */
    public double getDroolRate() {
        return droolRate;
    }

    @Override
    public int treat() {
        int minutes = 0;
        double minutesInDouble;
        if (droolRate < 3.5) {
            minutesInDouble = (getPainLevel() * 2) / getHealth();
            minutes = (int) Math.round(minutesInDouble);
        }

        if (droolRate >= 3.5 && droolRate <= 7.5) {
            minutesInDouble = getPainLevel() / getHealth();
            minutes = (int) Math.round(minutesInDouble);
        }

        if (droolRate > 7.5) {
            minutesInDouble = getPainLevel() / (getHealth() * 2);
            minutes = (int) Math.round(minutesInDouble);
        }
        heal();
        return minutes;
    }

    /**
     *  a method to print what Dog is suppose to speak.
     *  It also calls the speak method of the parent class.
     */
    public void speak() {
        super.speak();
        int printNumberOfTimes = getPainLevel();
        for (int i = 0; i < printNumberOfTimes; i++) {
            if (printNumberOfTimes > 5) {
                System.out.print("BARK ");
            } else {
                System.out.print("bark ");
            }
        }
        System.out.println();
    }

    /**
     * This is an equals method to check whether the two Dogs are equal or not.
     * @param o an object to compare Dog with.
     * @return A boolean value.
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Dog)) {
            return false;
        }

        Dog dog = (Dog) o;
        return (super.equals(dog)) && (droolRate == dog.droolRate);
    }
}
