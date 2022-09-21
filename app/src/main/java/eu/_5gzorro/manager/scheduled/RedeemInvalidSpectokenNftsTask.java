package eu._5gzorro.manager.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
//@EnableConfigurationProperties({ScheduleConfiguration.class})
public class RedeemInvalidSpectokenNftsTask {

    private static final Logger log = LoggerFactory.getLogger(RedeemInvalidSpectokenNftsTask.class);

//    private final ScheduleConfiguration scheduleConfiguration;
//
//    private static final String redeemCron = ;
//
//    public RedeemInvalidSpectokenNftsTask(ScheduleConfiguration scheduleConfiguration) {
//        this.scheduleConfiguration = scheduleConfiguration;
//        this.redeemCron = scheduleConfiguration.getRedeemCron();
//    }

    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    public void execute() {
        System.out.println("Probando scheduled.");
    }
}
