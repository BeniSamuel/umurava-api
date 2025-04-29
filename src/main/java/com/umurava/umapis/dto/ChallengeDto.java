package com.umurava.umapis.dto;

import java.util.Date;

public class ChallengeDto {
    private String name;
    private String longDescription;
    private Date startTime;
    private Date endTime;

    public String getName () { return this.name; }
    public String getLongDescription () { return this.longDescription; }
    public Date getStartTime () { return this.startTime; }
    public Date getEndTime () { return this.endTime; }
}
