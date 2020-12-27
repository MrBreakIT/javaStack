class Project {
    private String name;
    private String description;
    private Double cost;
    
    // overload constructor method 3 ways
    public Project() {
    }
    public Project(String name) {
            this.name = name;
        }
    public Project(String name, String description) {
            this.name = name;
            this.description = description;
        }
    public Project(Double cost){
        this.cost = cost;
        }

    //******************* getters *************
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Double getCost(){
        return cost;
    }

    //******************* setters *************
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String name){
        this.description = description;
    }
    public void setCost(Double cost){
        this.cost = cost;
    }

    // ******************* this is instance method *************
    public void elevatorPitch(Project project){
        System.out.println("Project Name: " + project.getName() + " Description: " + project.getDescription() + ", Initial Cost: " + project.getCost());
    }
    // will run including String declaring what project number is running
    public void elevatorPitch(String str, Project project){
        System.out.println(str + ": Project Name: " + project.getName() + " Description: " + project.getDescription() + ", Initial Cost: " + project.getCost());
    }
}