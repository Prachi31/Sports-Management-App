package prachi14075.iiitd.ac.in.sportsmanagementapp.dtos;

import android.os.Parcel;
import android.os.Parcelable;

public class OngoingEventsDTO implements Parcelable {

    private String ongoingBackgroundImg;
    private String ongoingEventName;
    private String ongoingEventType;
    private String ongoingEventDaysLeft;
    private String ongoingEventStatus;
    private int ongoingEventNumberTags;

    public OngoingEventsDTO(String backgroundImg, String ongoingEventName, String ongoingEventType, String ongoingEventDaysLeft, String ongoingEventStatus, int ongoingEventNumberTags) {
        this.ongoingBackgroundImg = backgroundImg;
        this.ongoingEventName = ongoingEventName;
        this.ongoingEventType = ongoingEventType;
        this.ongoingEventDaysLeft = ongoingEventDaysLeft;
        this.ongoingEventStatus = ongoingEventStatus;
        this.ongoingEventNumberTags = ongoingEventNumberTags;
    }

    public String getOngoingBackgroundImg() {
        return ongoingBackgroundImg;
    }

    public void setOngoingBackgroundImg(String ongoingBackgroundImg) {
        this.ongoingBackgroundImg = ongoingBackgroundImg;
    }

    public String getOngoingEventName() {
        return ongoingEventName;
    }

    public void setOngoingEventName(String ongoingEventName) {
        this.ongoingEventName = ongoingEventName;
    }

    public String getOngoingEventType() {
        return ongoingEventType;
    }

    public void setOngoingEventType(String ongoingEventType) {
        this.ongoingEventType = ongoingEventType;
    }

    public String getOngoingEventDaysLeft() {
        return ongoingEventDaysLeft;
    }

    public void setOngoingEventDaysLeft(String ongoingEventDaysLeft) {
        this.ongoingEventDaysLeft = ongoingEventDaysLeft;
    }

    public String getOngoingEventStatus() {
        return ongoingEventStatus;
    }

    public void setOngoingEventStatus(String ongoingEventStatus) {
        this.ongoingEventStatus = ongoingEventStatus;
    }

    public int getOngoingEventNumberTags() {
        return ongoingEventNumberTags;
    }

    public void setOngoingEventNumberTags(int ongoingEventNumberTags) {
        this.ongoingEventNumberTags = ongoingEventNumberTags;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ongoingBackgroundImg);
        dest.writeString(this.ongoingEventName);
        dest.writeString(this.ongoingEventType);
        dest.writeString(this.ongoingEventDaysLeft);
        dest.writeString(this.ongoingEventStatus);
        dest.writeInt(this.ongoingEventNumberTags);
    }

    protected OngoingEventsDTO(Parcel in) {
        this.ongoingBackgroundImg = in.readString();
        this.ongoingEventName = in.readString();
        this.ongoingEventType = in.readString();
        this.ongoingEventDaysLeft = in.readString();
        this.ongoingEventStatus = in.readString();
        this.ongoingEventNumberTags = in.readInt();
    }

    public static final Parcelable.Creator<OngoingEventsDTO> CREATOR = new Parcelable.Creator<OngoingEventsDTO>() {
        @Override
        public OngoingEventsDTO createFromParcel(Parcel source) {
            return new OngoingEventsDTO(source);
        }

        @Override
        public OngoingEventsDTO[] newArray(int size) {
            return new OngoingEventsDTO[size];
        }
    };
}
