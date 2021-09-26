package src.pojo;

public enum Parent {
    JAMIE ("J"),
    CAMERON ("C");
    String shortName;
    Parent(String parentShortName){
        this.shortName = parentShortName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
