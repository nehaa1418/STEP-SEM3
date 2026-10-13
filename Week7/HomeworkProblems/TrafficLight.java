public class TrafficLight {
    private String color;
    private final int id;

    public TrafficLight(int id) {
        this.id = id;
        color = "RED";
    }

    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        TrafficLight light = new TrafficLight(1);

        System.out.println("Current color: " + light.getColor());

        light.next();
        System.out.println("Next color: " + light.getColor());

        light.next();
        System.out.println("Next color: " + light.getColor());

        light.next();
        System.out.println("Next color: " + light.getColor());
    }
}