package eu._5gzorro.manager.scheduled;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "schedule")
public class ScheduleConfiguration {

    private static String redeemCron;

    public String getRedeemCron() {
        return redeemCron;
    }

}
