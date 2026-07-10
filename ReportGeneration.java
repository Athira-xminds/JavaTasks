public class ReportGeneration {
    public static void main(String[] args) throws InterruptedException {
        Thread salesReport = new Thread(new ReportGenerator("Sales Report"));
        Thread employeeReport = new Thread(new ReportGenerator("Employee Report"));
        Thread inventoryReport = new Thread(new ReportGenerator("Inventory Report"));

        salesReport.start();
        employeeReport.start();
        inventoryReport.start();
        salesReport.join();
        employeeReport.join();
        inventoryReport.join();
        System.out.println("\n");
        System.out.println("Sales, Employee and Inventory reports generated successfully");
        System.out.println("Final report completed");

    }
}
