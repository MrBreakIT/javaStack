class ProjectTest {
    public static void main(String[] args) {
        Project p = new Project ();
        

        Project project1 = new Project();

        Project project2 = new Project("Landscaping ,");
        // System.out.println("Project name: " + project2.getName());

        Project project3 = new Project("CheckCashing ,", "cash your checks now!");
        // System.out.println("Project name: " + project3.getName() + "Description: " + project3.getDescription());
        project1.setCost(0.00);
        project2.setCost(1000.00);
        project3.setCost(100.00);

        p.elevatorPitch(project1);
    }
}
