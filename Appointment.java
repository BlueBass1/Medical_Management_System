import java.util.Random;

public class Appointment {
    static Random num = new Random();

    String time;
    String newPatient;
    String sick;
    String clinic;
    String doctor;
    String fullName;
    String reason;
    String insurancePlan;
    String medicalRecords;
    String medication;
    String newPCP;
    int wait;
    boolean urgent;

    public Appointment (
            String time,
            String newPatient,
            String sick,
            String clinic,
            String newPCP,
            String doctor,
            String fullName,
            String reason,
            String insurancePlan,
            String medicalRecords,
            String medication
    ){
        this.time = time;
        this.newPatient = newPatient;
        this.sick = sick;
        this.clinic = clinic;
        this.newPCP = newPCP;
        this.doctor = doctor;
        this.fullName = fullName;
        this.reason = reason;
        this.insurancePlan = insurancePlan;
        this.medicalRecords = medicalRecords;
        this.medication = medication;
        this.wait = 0;
        this.urgent = false;
    }

    public void waitTime() {
        if (this.urgent){
            this.wait = num.nextInt(2);
        } else {
            this.wait = num.nextInt(8);
        }
    }
    public void urgency(){
        this.urgent = this.sick.equalsIgnoreCase("yes");
    }
    public void appointmentDetails() {
        System.out.println("\ntime: " + this.time);
        System.out.println("newPatient: " + this.newPatient);
        System.out.println("sick: " + this.sick);
        System.out.println("clinic: " + this.clinic);
        System.out.println("doctor: " + this.doctor);
        System.out.println("Full Name: " + this.fullName);
        System.out.println("reason: " + this.reason);
        if (this.insurancePlan.equals("")){
            System.out.println("N/A");
        } else {
            System.out.println("insurancePlan: " + this.insurancePlan);

        }
        if (this.medicalRecords.equals("")){
            System.out.println("N/A");
        } else {
            System.out.println("medicalRecords: " + this.medicalRecords);

        }
        if (this.medication.equals("")){
            System.out.println("N/A\n");
        } else {
            System.out.println("medication: " + this.medication + "\n");

        }
    }
}
