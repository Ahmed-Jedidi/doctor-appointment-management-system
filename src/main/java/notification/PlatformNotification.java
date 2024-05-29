package notification;

public class PlatformNotification implements INotification {

	@Override
	public void SendNotification(String Message) {
		// TODO Auto-generated method stub
		System.out.println("Platform Notification: "+Message);
	}

}
