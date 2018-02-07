
package view.checkout2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardArt {

    @SerializedName("baseImageFileName")
    @Expose
    private String baseImageFileName;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("width")
    @Expose
    private Integer width;

    public String getBaseImageFileName() {
        return baseImageFileName;
    }

    public void setBaseImageFileName(String baseImageFileName) {
        this.baseImageFileName = baseImageFileName;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

}
