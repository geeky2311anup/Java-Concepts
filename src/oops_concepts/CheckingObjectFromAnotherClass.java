public class TestDataAbstraction {

    public TestDataAbstraction() {
        System.out.println("Program Started");
    }

    private void displayTitle() {
        System.out.println("Checking Data Abstraction Object");
    }

    private void createAndUseObject() {
        dataAbstraction objectRef = new dataAbstraction();
        objectRef.getvar();
    }

    public static void main(String[] args) {
        TestDataAbstraction demo = new TestDataAbstraction();
        demo.displayTitle();
        demo.createAndUseObject();
        System.out.println("Program Finished");
    }
}
