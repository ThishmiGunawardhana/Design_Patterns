import java.util.ArrayList;
import java.util.List;

interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

interface Observer {
    void notifyMe(Observable observable);
}

class Temperature implements Observable {

    private final List<Observer> observers;
    private int value;

    Temperature() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.notifyMe(this);
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    }
}

class AirConditioner implements Observer {

    @Override
    public void notifyMe(Observable observable) {
        System.out.println("Temperature changed in AC");
    }
}

class Display implements Observer {

    @Override
    public void notifyMe(Observable observable) {
        Temperature temperature = (Temperature) observable;
        System.out.println("Temperature is now: " + temperature.getValue());
    }
}

class Notification implements Observer {

    @Override
    public void notifyMe(Observable observable) {
        Temperature temperature = (Temperature) observable;
        System.out.println("Notification: " + temperature.getValue());
    }
}

public class Test {
    public static void main(String[] args) {
        Temperature temperature = new Temperature();

        AirConditioner airConditioner = new AirConditioner();
        Display display = new Display();
        Notification notification = new Notification();

        System.out.println("Step 1");
        temperature.addObserver(airConditioner);
        temperature.setValue(20);

        System.out.println();
        System.out.println("Step 2");
        temperature.addObserver(display);
        temperature.addObserver(notification);
        temperature.setValue(25);

        System.out.println();
        System.out.println("Step 3");
        temperature.removeObserver(display);
        temperature.setValue(30);
    }
}
