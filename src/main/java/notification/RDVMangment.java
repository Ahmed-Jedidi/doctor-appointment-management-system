package notification;

import java.util.ArrayList;
import java.util.List;

public class RDVMangment {
	private List<INotification> notifications = new ArrayList<INotification>();
	
	public void addObserver(INotification notification) {
		notifications.add(notification);
	}
	public void removeObserver(INotification notification) {
		notifications.remove(notification);
	}
	public void RDVTaken() {
		for (INotification Notification : notifications) {
			Notification.SendNotification("Nouveau rendez-vous pris.");
		}
	}
}
