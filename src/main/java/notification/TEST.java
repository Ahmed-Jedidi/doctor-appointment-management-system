package notification;

public class TEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotifactionFactory factory = new NotifactionFactory();
		
		INotification emailNotification = factory.createNotification("EMAIL");
		INotification smsNotification = factory.createNotification("SMS");
		INotification platformNotification = factory.createNotification("PLATFORM");
		
		RDVMangment rdvMangment = new RDVMangment();
		
		rdvMangment.addObserver(emailNotification);
		rdvMangment.addObserver(smsNotification);
		rdvMangment.addObserver(platformNotification);
		
		rdvMangment.RDVTaken();
	}

}
