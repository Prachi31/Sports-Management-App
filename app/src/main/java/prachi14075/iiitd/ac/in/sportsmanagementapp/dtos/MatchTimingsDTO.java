package prachi14075.iiitd.ac.in.sportsmanagementapp.dtos;


public class MatchTimingsDTO {

    private String startTime;
    private String endTime;

    public MatchTimingsDTO(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

}
