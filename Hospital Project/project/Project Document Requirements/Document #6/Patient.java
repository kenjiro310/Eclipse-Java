import java.util.*;
//Patient Object
//Each Patient object represents one patient in the hospital. Each object contains all of the patient's
//information, such as their name, phone number, address, social security number, room number, the
//doctor assigned to them, the nurse station corresponding to their room number, previous medical
//diagnoses, previous and current medications, the times of their next scheduled checkup and
//medication, and so on.
public class Patient {
	private String firstName;
	private String lastName;
	private int phoneNumber;
	private String address;
	private String insuranceProvider;
	private int SSN;
	private String doctor;
	private int nurseStation;
	private int roomNumber;
	private String currentDiagnosis;	
	private LinkedList<Drug> medications = new LinkedList<Drug>(); 		//stores drug objects of each drug that the //patient is currently taking
	private LinkedList<String> diagnosisHistory = new LinkedList<String>();	//stores each each diagnosis from most //recent to least
	private double nextCheckup;					//time of next checkup
	private double nextMedication;				//time next medication will be administered
	private double lastMedication;				//time last medication was administered
	
	public Patient(String fN, String lN, int pN, String adrs, String iP, int social, String doc, int nS, int rN, String cD) {
		firstName = fN;
		lastName = lN;
		phoneNumber = pN;
		address = adrs;
		insuranceProvider = iP;
		SSN = social;
		doctor = doc;
		nurseStation = nS;
		roomNumber = rN;
		currentDiagnosis = cD;	
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}

	public String getInsuranceProvider() {
		return insuranceProvider;
	}
	
	public int getSSN() {
		return SSN;
	}

	public String getDoctor() {
		return doctor;
	}

	public int getNurseStation() {
		return nurseStation;
	}

	public int getRoomNumber() {
		return roomNumber;
	}
	
	public String getCurrentDiagnosis() {
		return currentDiagnosis;
	}

	public LinkedList getMedications() {
		return medications;
	}
	
	public double getNextCheckup() {
		return nextCheckup;
	}

	public double getNextMedication() {
		return nextMedication;
	}
	
	public void changeFirstName(String newFirstName) {
		firstName = newFirstName ;
	}
	
	public void changeLastName(String newLastName) {
		lastName = newLastName;
	}
	
	public void changePhoneNumber(int newPhoneNumber) {
		phoneNumber = newPhoneNumber;
	}
	
	public void changeAddress(String newAddress) {
		address = newAddress;
	}

	public void changeInsuranceProvider(String newInsuranceProvider) {
		insuranceProvider = newInsuranceProvider;
	}
	
	public void changeSSN(int newSSN) {
		SSN = newSSN;
	}

	public void changeDoctor(String newDoctor) {
		doctor = newDoctor;
	}

	public void changeNurseStation(int newNurseStation) {
		nurseStation = newNurseStation;
	}

	public void changeRoomNumber(int newRoomNumber) {
		roomNumber = newRoomNumber;
	}
	
	public void setNextCheckup(int newCheckupTime) {
		nextCheckup = newCheckupTime;
	}
	
	public void setNextMed(int newMedTime) {
		lastMedication = nextMedication;
		nextMedication = newMedTime;
	}
	
	public void newCurrentDiagnosis(String cD) {
		currentDiagnosis = cD;
		diagnosisHistory.addFirst(currentDiagnosis);
	}
	
	public void newMedication(Drug d) {
		medications.addFirst(d);
	}
}
