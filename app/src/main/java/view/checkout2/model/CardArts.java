
package view.checkout2.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardArts {

    @SerializedName("cardArt")
    @Expose
    private List<CardArt> cardArt = null;

    public List<CardArt> getCardArt() {
        return cardArt;
    }

    public void setCardArt(List<CardArt> cardArt) {
        this.cardArt = cardArt;
    }

}
