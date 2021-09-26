package src.pojo;

public enum Parent {
    JAMIE ("J"),
    CAMERON ("C");

    private String shortName;

    Parent(String parentShortName){
        this.shortName = parentShortName;
    }

    public String getShortName() {
        return shortName;
    }
}
