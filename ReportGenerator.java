/**
 A company generates three parts of a report in parallel:
 Sales Report
 Employee Report
 Inventory Report
 The final report should be displayed only after all three reports are completed.
 Use the join() method to ensure the main thread waits for all report-generation threads.
 */
class ReportGenerator implements Runnable {
    private final String reportName;

    public ReportGenerator(String reportName)
    {
    this.reportName = reportName;
    }

    public void run() {
        System.out.println( reportName + " generation complete");
    }
}

