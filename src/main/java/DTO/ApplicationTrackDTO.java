package DTO;

import java.time.LocalDate;

public class ApplicationTrackDTO {

    public String date;
    public long applications;

    public long getApplications() {
        return applications;
    }

    public void setApplications(long applications) {
        this.applications = applications;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
