package eu._5gzorro.manager.api.dto;

import eu._5gzorro.manager.api.model.NotificationMethodBase;
import eu._5gzorro.manager.api.model.enumureration.NotificationType;

public class EmailNotificationDto extends NotificationMethodBase {

    private String distributionList;

    public EmailNotificationDto() {
        super(NotificationType.EMAIL);
    }

    public String getDistributionList() {
        return distributionList;
    }

    public EmailNotificationDto setDistributionList(String distributionList) {
        this.distributionList = distributionList;
        return this;
    }
}
