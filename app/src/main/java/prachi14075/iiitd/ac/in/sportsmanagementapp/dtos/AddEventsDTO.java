package prachi14075.iiitd.ac.in.sportsmanagementapp.dtos;

import android.os.Parcel;
import android.os.Parcelable;

public class AddEventsDTO implements Parcelable {

    private String   eventName;
    private String   eventType;
    private String[] eventCategory;
    private String   eventRegistrationStartDate;
    private String   eventRegistrationEndDate;
    private String   eventStartDate;
    private String   eventEndDate;
    private String[] eventRules;

    private MatchTimingsDTO   eventMatchTimings;
    private ContactDetailsDTO eventCoordinatorDetails;

    public AddEventsDTO(String eventName, String eventType, String[] eventCategory, String eventRegistrationStartDate,
                        String eventRegistrationEndDate, String eventStartDate, String eventEndDate, String[] eventRules,
                        MatchTimingsDTO eventMatchTimings, ContactDetailsDTO eventCoordinatorDetails) {

        this.eventName = eventName;
        this.eventType = eventType;
        this.eventCategory = eventCategory;
        this.eventRegistrationStartDate = eventRegistrationStartDate;
        this.eventRegistrationEndDate = eventRegistrationEndDate;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.eventRules = eventRules;
        this.eventMatchTimings = eventMatchTimings;
        this.eventCoordinatorDetails = eventCoordinatorDetails;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String[] getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(String[] eventCategory) {
        this.eventCategory = eventCategory;
    }

    public String getEventRegistrationStartDate() {
        return eventRegistrationStartDate;
    }

    public void setEventRegistrationStartDate(String eventRegistrationStartDate) {
        this.eventRegistrationStartDate = eventRegistrationStartDate;
    }

    public String getEventRegistrationEndDate() {
        return eventRegistrationEndDate;
    }

    public void setEventRegistrationEndDate(String eventRegistrationEndDate) {
        this.eventRegistrationEndDate = eventRegistrationEndDate;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public String[] getEventRules() {
        return eventRules;
    }

    public void setEventRules(String[] eventRules) {
        this.eventRules = eventRules;
    }

    public MatchTimingsDTO getEventMatchTimings() {
        return eventMatchTimings;
    }

    public void setEventMatchTimings(MatchTimingsDTO eventMatchTimings) {
        this.eventMatchTimings = eventMatchTimings;
    }

    public ContactDetailsDTO getEventCoordinatorDetails() {
        return eventCoordinatorDetails;
    }

    public void setEventCoordinatorDetails(ContactDetailsDTO eventCoordinatorDetails) {
        this.eventCoordinatorDetails = eventCoordinatorDetails;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.eventName);
        dest.writeString(this.eventType);
        dest.writeStringArray(this.eventCategory);
        dest.writeString(this.eventRegistrationStartDate);
        dest.writeString(this.eventRegistrationEndDate);
        dest.writeString(this.eventStartDate);
        dest.writeString(this.eventEndDate);
        dest.writeStringArray(this.eventRules);
        dest.writeParcelable((Parcelable) this.eventMatchTimings, flags);
        dest.writeParcelable((Parcelable) this.eventCoordinatorDetails, flags);
    }

    protected AddEventsDTO(Parcel in) {
        this.eventName = in.readString();
        this.eventType = in.readString();
        this.eventCategory = in.createStringArray();
        this.eventRegistrationStartDate = in.readString();
        this.eventRegistrationEndDate = in.readString();
        this.eventStartDate = in.readString();
        this.eventEndDate = in.readString();
        this.eventRules = in.createStringArray();
        this.eventMatchTimings = in.readParcelable(MatchTimingsDTO.class.getClassLoader());
        this.eventCoordinatorDetails = in.readParcelable(ContactDetailsDTO.class.getClassLoader());
    }

    public static final Parcelable.Creator<AddEventsDTO> CREATOR = new Parcelable.Creator<AddEventsDTO>() {
        @Override
        public AddEventsDTO createFromParcel(Parcel source) {
            return new AddEventsDTO(source);
        }

        @Override
        public AddEventsDTO[] newArray(int size) {
            return new AddEventsDTO[size];
        }
    };
}
