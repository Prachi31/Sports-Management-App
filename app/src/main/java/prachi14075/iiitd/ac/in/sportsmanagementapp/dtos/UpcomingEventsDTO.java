package prachi14075.iiitd.ac.in.sportsmanagementapp.dtos;

import android.os.Parcel;
import android.os.Parcelable;

public class UpcomingEventsDTO implements Parcelable {

    private String backgroundImg;
    private String upcomingEventName;
    private String upcomingEventType;
    private String upcomingEventDaysLeft;
    private String upcomingEventStatus;
    private int upcomingEventNumberTags;

    public UpcomingEventsDTO(String backgroundImg,String upcomingEventName, String upcomingEventType, String upcomingEventDaysLeft, String upcomingEventStatus, int upcomingEventNumberTags) {
        this.backgroundImg = backgroundImg;
        this.upcomingEventName = upcomingEventName;
        this.upcomingEventType = upcomingEventType;
        this.upcomingEventDaysLeft = upcomingEventDaysLeft;
        this.upcomingEventStatus = upcomingEventStatus;
        this.upcomingEventNumberTags = upcomingEventNumberTags;
    }

    public String getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(String backgroundImg) {
        this.backgroundImg = backgroundImg;
    }

    public String getUpcomingEventName() {
        return upcomingEventName;
    }

    public void setUpcomingEventName(String upcomingEventName) {
        this.upcomingEventName = upcomingEventName;
    }

    public String getUpcomingEventType() {
        return upcomingEventType;
    }

    public void setUpcomingEventType(String upcomingEventType) {
        this.upcomingEventType = upcomingEventType;
    }

    public String getUpcomingEventDaysLeft() {
        return upcomingEventDaysLeft;
    }

    public void setUpcomingEventDaysLeft(String upcomingEventDaysLeft) {
        this.upcomingEventDaysLeft = upcomingEventDaysLeft;
    }

    public String getUpcomingEventStatus() {
        return upcomingEventStatus;
    }

    public void setUpcomingEventStatus(String upcomingEventStatus) {
        this.upcomingEventStatus = upcomingEventStatus;
    }

    public int getUpcomingEventNumberTags() {
        return upcomingEventNumberTags;
    }

    public void setUpcomingEventNumberTags(int upcomingEventNumberTags) {
        this.upcomingEventNumberTags = upcomingEventNumberTags;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.backgroundImg);
        dest.writeString(this.upcomingEventName);
        dest.writeString(this.upcomingEventType);
        dest.writeString(this.upcomingEventDaysLeft);
        dest.writeString(this.upcomingEventStatus);
        dest.writeInt(this.upcomingEventNumberTags);
    }

    protected UpcomingEventsDTO(Parcel in) {
        this.backgroundImg = in.readString();
        this.upcomingEventName = in.readString();
        this.upcomingEventType = in.readString();
        this.upcomingEventDaysLeft = in.readString();
        this.upcomingEventStatus = in.readString();
        this.upcomingEventNumberTags = in.readInt();
    }

    public static final Parcelable.Creator<UpcomingEventsDTO> CREATOR = new Parcelable.Creator<UpcomingEventsDTO>() {
        @Override
        public UpcomingEventsDTO createFromParcel(Parcel source) {
            return new UpcomingEventsDTO(source);
        }

        @Override
        public UpcomingEventsDTO[] newArray(int size) {
            return new UpcomingEventsDTO[size];
        }
    };
}
