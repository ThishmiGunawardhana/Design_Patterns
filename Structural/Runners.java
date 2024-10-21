interface Runner {
    void run();
}

class Sprinters implements Runner {

    @Override
    public void run() { 
        System.out.println("I am sprinting");
    }

    public void start() {
        System.out.println("I have to take my start right");
    }
}

class RoadRunners implements Runner {

    @Override
    public void run() {  
        System.out.println("I am road running");
    }

    public void breath() {
        System.out.println("I am breathing");
    }
}

class Athlete {
    Sprinters sprinter;
    RoadRunners roadRunner;

    public Athlete() {
        sprinter = new Sprinters();
        roadRunner = new RoadRunners();  
    }

    public void roadRun() {
        roadRunner.run();
        roadRunner.breath();
    }

    public void sprint() {
        sprinter.run();
        sprinter.start();
    }
}

public class Runners {
    public static void main(String[] args) {
        Athlete a1 = new Athlete();
        a1.sprint();
    }
}
