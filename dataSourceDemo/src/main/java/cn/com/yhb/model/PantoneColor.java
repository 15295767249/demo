package cn.com.yhb.model;

public class PantoneColor {

    private String id;
    private String colorNumber;
    private String colorCode;
    private String colorStyle;

    public PantoneColor(String id, String colorNumber, String colorCode, String colorStyle) {
        this.id = id;
        this.colorNumber = colorNumber;
        this.colorCode = colorCode;
        this.colorStyle = colorStyle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColorNumber() {
        return colorNumber;
    }

    public void setColorNumber(String colorNumber) {
        this.colorNumber = colorNumber;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorStyle() {
        return colorStyle;
    }

    public void setColorStyle(String colorStyle) {
        this.colorStyle = colorStyle;
    }

    @Override
    public String toString() {
        return "PantoneColor{" +
                "id=" + id +
                ", colorNumber='" + colorNumber + '\'' +
                ", colorCode='" + colorCode + '\'' +
                ", colorStyle='" + colorStyle + '\'' +
                '}';
    }
}
