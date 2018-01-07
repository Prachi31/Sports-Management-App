package prachi14075.iiitd.ac.in.sportsmanagementapp.dtos;


public class MyMatchesDTO {
    private String teamOneName;
    private String teamOneScore;
    private String matchTime;
    private String matchDate;
    private String teamTwoName;
    private String teamTwoScore;
    private String matchOccured;

    public MyMatchesDTO(String teamOneName, String teamOneScore, String matchtime, String matchdate, String teamTwoName, String teamTwoScore, String matchOccured) {

        this.teamOneName = teamOneName;
        this.teamOneScore = teamOneScore;
        this.matchTime = matchtime;
        this.matchDate = matchdate;
        this.teamTwoName = teamTwoName;
        this.teamTwoScore = teamTwoScore;
        this.matchOccured = matchOccured;
    }

    public String getMatchOccured() {
        return matchOccured;
    }

    public void setMatchOccured(String matchOccured) {
        this.matchOccured = matchOccured;
    }
    public String getTeamOneName() {
        return teamOneName;
    }

    public void setTeamOneName(String teamOneName) {
        this.teamOneName = teamOneName;
    }

    public String getTeamOneScore() {
        return teamOneScore;
    }

    public void setTeamOneScore(String teamOneScore) {
        this.teamOneScore = teamOneScore;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getTeamTwoName() {
        return teamTwoName;
    }

    public void setTeamTwoName(String teamTwoName) {
        this.teamTwoName = teamTwoName;
    }

    public String getTeamTwoScore() {
        return teamTwoScore;
    }

    public void setTeamTwoScore(String teamTwoScore) {
        this.teamTwoScore = teamTwoScore;
    }
}
