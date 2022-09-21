package eu._5gzorro.manager.api.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class RedeemInvalidSpectokenNftsTask {

    private static final Logger log = LoggerFactory.getLogger(RedeemInvalidSpectokenNftsTask.class);

    @Scheduled(cron = "${cron.schedule}")
    public void execute() {
        System.out.println("Probando scheduled.");
    }
}
