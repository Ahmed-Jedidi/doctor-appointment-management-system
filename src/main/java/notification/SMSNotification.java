package notification;

public class SMSNotification implements INotification {

	@Override
	public void SendNotification(String Message) {
		// TODO Auto-generated method stub
		System.out.println("SMS Notification: "+Message);
	}

}
