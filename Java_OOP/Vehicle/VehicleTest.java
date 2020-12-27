class VehicleTest {
    public static void main(String[] args) {
        Vehicle redVehicle = new Vehicle("red");
        String color = redVehicle.getColor();
        System.out.println("The vehicle color is: " + color);


        Vehicle bike = new Vehicle();
        Vehicle car = new Vehicle();
        bike.setNumberOfWheels(2);
        bike.setColor("red");
        int bikeWheels = bike.getNumberOfWheels();
        String bikeColor = bike.getColor();
        car.setNumberOfWheels(4);
        car.setColor("green");
        int carWheels = car.getNumberOfWheels();
        String carColor = car.getColor();
        System.out.println("Bike object - Wheels: " + bikeWheels + ", Color: " + bikeColor);
        System.out.println("Car object - Wheels: " + carWheels + ", Color: " + carColor);
    }
}
