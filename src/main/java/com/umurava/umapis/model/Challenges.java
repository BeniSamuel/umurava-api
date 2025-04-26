package com.umurava.umapis.model;

import com.umurava.umapis.enums.Clevel;
import com.umurava.umapis.enums.Cstatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Challenges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cover;
    private String title;
    private String longDescription;
    private Date startTime;
    private Date endTime;

    @Enumerated(EnumType.STRING)
    private Cstatus cstatus;

    @Enumerated(EnumType.STRING)
    private Clevel clevel;

    public Challenges () {}
    public Challenges (String cover, String title, String description, Date startTime, Date endTime, Cstatus cstatus, Clevel clevel) {
        this.cover = cover;
        this.clevel = clevel;
        this.cstatus = cstatus;
        this.title = title;
        this.longDescription = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public  String getCover () { return this.cover; }
    public String getTitle () { return this.title; }
    public String getLongDescription () { return this.longDescription; }
    public Date getStartTime () { return this.startTime; }
    public Date getEndTime () { return this.endTime; }
    public Cstatus getCstatus () { return this.cstatus; }
    public Clevel getClevel () { return this.clevel; }

    public void setTitle ( String title ) { this.title = title; }
    public void setCover ( String cover ) { this.cover = cover; }
    public void setLongDescription ( String description ) { this.longDescription = description; }
    public void setStartTime ( Date Stime ) { this.startTime = Stime; }
    public void setEndTime ( Date etime ) { this.endTime = etime; }
    public void setCstatus (Cstatus status) { this.cstatus = status; }
    public void setClevel (Clevel level) { this.clevel = level; }
}
