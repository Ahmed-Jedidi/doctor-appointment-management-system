package notification;

public class NotifactionFactory {
	public INotification createNotification (String type) {
		if (type.equalsIgnoreCase("EMAIL")) {
			return new EmailNotification();
		} else if (type.equalsIgnoreCase("SMS")) {
			return new SMSNotification();
		} else if (type.equalsIgnoreCase("PLATFORM")) {
			return new PlatformNotification();
		}
		return null;
	}
}
