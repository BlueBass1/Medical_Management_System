import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        ArrayList<Appointment> appointments = new ArrayList<>();

        boolean scheduling = true;
        boolean prompt = true;
        boolean reviewing = true;
        boolean editing = true;
        boolean canceling = true;


//        3 max doctors for demo
//        Doctor user verification
//        Doctor password verification
//        Admin privileges for doctors

        while (prompt) {
            System.out.println("Welcome! What would you like to do? [set] an appointment, or [view] your appointment?");
            String choice = key.nextLine();
            prompt = false;
            if (choice.equalsIgnoreCase("set")) {
                scheduling = true;
                while (scheduling) {
                    System.out.println("Alright, to set an appointment, we need you to provide some information. ");

                    System.out.print("\nwhat time would you like to set an appointment? [AM or PM] ");
                    String time = key.nextLine();

                    System.out.print("\nAre you a new patient? [Yes or No] ");
                    String newPatient = key.nextLine();

                    System.out.print("\nAre you feeling unwell? [Yes or No] ");
                    String sick = key.nextLine();

                    System.out.print("\nWhat clinic would you like to schedule with? ");
                    String clinic = key.nextLine();

                    System.out.print("\nAre you looking for a new PCP (Primary Care Provider)? [Yes or No] ");
                    String newPCP = key.nextLine();

                    System.out.print("\nWhat is the name of the doctor you want? ");
                    String doctor = key.nextLine();

                    System.out.print("\nWhat is your name? ");
                    String fullName = key.nextLine();

                    System.out.print("\nWhy are you scheduling an appointment? ");
                    String reason = key.nextLine();

                    System.out.print("\nOk, who are you insured under? (Optional) [ENTER] to skip. ");
                    String insurancePlan = key.nextLine();

                    System.out.print("\nDo you have any medical records we need to be aware of? (Optional) [ENTER] to skip. ");
                    String medicalRecords = key.nextLine();

                    System.out.print("\nLastly, please name your prescribed medicine. (Optional) [ENTER] to skip. ");
                    String medication = key.nextLine();

                    appointments.add(new Appointment(
                            time,
                            newPatient,
                            sick,
                            clinic,
                            newPCP,
                            doctor,
                            fullName,
                            reason,
                            insurancePlan,
                            medicalRecords,
                            medication));

                    for (Appointment a : appointments) {
                        a.urgency();
                        a.waitTime();
                        if (a.fullName.equalsIgnoreCase(fullName) && a.wait > 0) {
                            System.out.println("\n" + a.fullName + ", your appointment has been set " + a.wait + " days from now at " + a.time + "\n");
                            scheduling = false;
                            prompt = true;
                        } else if (a.fullName.equalsIgnoreCase(fullName) && a.wait == 1) {
                            System.out.println("\n" + a.fullName + ", your appointment has been set up for tomorrow at " + a.time + "\n");
                            scheduling = false;
                            prompt = true;
                        } else if (a.fullName.equalsIgnoreCase(fullName) && a.wait == 0) {
                            System.out.println("\n" + a.fullName + ", your appointment has been set up for today at " + a.time + ".\n");
                            scheduling = false;
                            prompt = true;
                        }
                    }
                }
            } else if (choice.equalsIgnoreCase("view")) {
                reviewing = true;
                System.out.println("\nWe need your full name to access your appointment(s)");
                System.out.print("> ");
                String patient = key.nextLine();
                while (reviewing) {
                    for (Appointment a : appointments) {
                        if (a.fullName.equalsIgnoreCase(patient)) {
                            a.appointmentDetails();
                        }
                    }
                    System.out.println("What would you like to do? [Edit] [Cancel]");
                    String revision = key.nextLine();

                    if (revision.equalsIgnoreCase("edit")){
                        while (editing){
                            System.out.println("Input appointment number for editing");
                            for (Appointment a : appointments) {
                                if (a.fullName.equalsIgnoreCase(patient)){
                                    System.out.println("\n" + (appointments.indexOf(a) + 1) + ". Appointment for: " + a.reason + "\n");
                                }
                            }
                            int edit = key.nextInt();
                            for (Appointment a : appointments) {
                                if ((appointments.indexOf(a) + 1) == edit ) {
                                    System.out.println("What would you like to edit?");
                                    a.appointmentDetails();
                                }
                            }
                            String change = key.nextLine();
                            for (Appointment a : appointments) {
                                if (change.equalsIgnoreCase("time") ) {
                                    System.out.println("Rescheduling for what time?");
                                    System.out.print(">");
                                    String newTime = key.nextLine();
                                    if (Integer.parseInt(newTime) > 0) {
                                        a.time = newTime;
                                        System.out.println("Time has been updated to: " + a.time);
                                    } else {
                                        System.out.println("Invalid time input. time unchanged");
                                    }
                                }
                            }
                        }


                    } else if (revision.equalsIgnoreCase("cancel")) {
                        System.out.println("Input number for the one you want to cancel");
                        for (Appointment a : appointments) {
                            System.out.println((appointments.indexOf(a) + 1) + ". Appointment for: " + a.reason);
                        }
                    }
                    prompt = true;
                    reviewing = false;
                }
            } else if (choice.equalsIgnoreCase("q")){
                break;
            } else {
                System.out.print("\nInvalid input. Please try again\n");
                prompt = true;
            }
        }
    }
}
