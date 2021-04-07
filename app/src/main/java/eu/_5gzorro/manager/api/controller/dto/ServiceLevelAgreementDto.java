package eu._5gzorro.manager.api.controller.dto;

import java.time.LocalDateTime;

public class ServiceLevelAgreement {
    private String id;
    private String href;
    private String name;
    private String description;
    private String version;
    private LocalDateTime validFor;
    private String state;
    private boolean approved;
    private LocalDateTime approvalDate;

}
