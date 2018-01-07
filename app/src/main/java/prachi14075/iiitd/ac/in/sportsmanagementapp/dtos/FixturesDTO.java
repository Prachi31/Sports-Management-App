package prachi14075.iiitd.ac.in.sportsmanagementapp.dtos;


import android.graphics.drawable.Drawable;

public class FixturesDTO {

    String   roundName;
    Drawable dropDownImage;

    public FixturesDTO(String roundName, Drawable dropDownImage) {
        this.roundName = roundName;
        this.dropDownImage = dropDownImage;
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName;
    }

    public Drawable getDropDownImage() {
        return dropDownImage;
    }

    public void setDropDownImage(Drawable dropDownImage) {
        this.dropDownImage = dropDownImage;
    }
}
