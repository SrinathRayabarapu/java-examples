package com.hibernate.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "speaker")
public class Speaker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int speakerId;

    private String speakerName;
    private String topic;
    private Date speakerSchedule;

    public Speaker(){
    }

    public Speaker(String speakerName, String topic, Date speakerSchedule) {
        this.speakerName = speakerName;
        this.topic = topic;
        this.speakerSchedule = speakerSchedule;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getSpeakerSchedule() {
        return speakerSchedule;
    }

    public void setSpeakerSchedule(Date speakerSchedule) {
        this.speakerSchedule = speakerSchedule;
    }

    public int getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(int speakerId) {
        this.speakerId = speakerId;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "speakerId=" + speakerId +
                ", speakerName='" + speakerName + '\'' +
                ", topic='" + topic + '\'' +
                ", speakerSchedule=" + speakerSchedule +
                '}';
    }

}