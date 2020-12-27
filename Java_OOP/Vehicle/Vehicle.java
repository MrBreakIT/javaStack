class Vehicle {
    private int numberOfWheels;
    private String color;
    // getter
    public int getNumberOfWheels() {
        return numberOfWheels;
    }
    // instantiate new Vehicle()
    public Vehicle() {
    }   
    // instantiate new Vehicle("someColor")
    public Vehicle(String color) {
        this.color = color;
    }
    // instantiate new Vehicle("someColor", 4)
    public Vehicle (String color, int num){
        this.color= color;
        this.numberOfWheels=num;

    }

    // setter
    public void setNumberOfWheels(int number) {
        numberOfWheels = number;
    }
    // getter
    public String getColor() {
        return color;
    }
    // setter
    public void setColor(String color) {
        this.color = color;        // 1
    }
}



