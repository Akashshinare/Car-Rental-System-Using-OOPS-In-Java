import java.util.ArrayList;
import java.util.List;

class Car {
    private String make;
    private String model;
    private int year;
    private boolean available;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.available = true;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rent() {
        if (available) {
            available = false;
            System.out.println("Car rented: " + make + " " + model + " " + year);
        } else {
            System.out.println("Car is not available for rent.");
        }
    }

    public void returnCar() {
        available = true;
        System.out.println("Car returned: " + make + " " + model + " " + year);
    }
}

class CarRentalSystem {
    private List<Car> cars;

    public CarRentalSystem() {
        cars = new ArrayList<>();
    }

    public void addCar(String make, String model, int year) {
        cars.add(new Car(make, model, year));
    }

    public void displayAvailableCars() {
        System.out.println("Available Cars:");
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println(car.getMake() + " " + car.getModel() + " " + car.getYear());
            }
        }
        System.out.println();
    }

    public void rentCar(int index) {
        if (index >= 0 && index < cars.size()) {
            cars.get(index).rent();
        } else {
            System.out.println("Invalid car index.");
        }
    }

    public void returnCar(int index) {
        if (index >= 0 && index < cars.size()) {
            cars.get(index).returnCar();
        } else {
            System.out.println("Invalid car index.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        // Adding cars to the system
        rentalSystem.addCar("Toyota", "Camry", 2022);
        rentalSystem.addCar("Honda", "Accord", 2021);
        rentalSystem.addCar("Ford", "Fusion", 2020);

        // Displaying available cars
        rentalSystem.displayAvailableCars();

        // Renting a car
        rentalSystem.rentCar(0);

        // Displaying available cars after renting
        rentalSystem.displayAvailableCars();

        // Returning the rented car
        rentalSystem.returnCar(0);

        // Displaying available cars after returning
        rentalSystem.displayAvailableCars();
    }
}
