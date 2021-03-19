package WorkingWithAbstraction.TrafficLights;

public enum Lights {
    RED("GREEN"),
    GREEN("YELLOW"),
    YELLOW("RED");


    private String value;
    Lights (String value){
        this.value = value;
    }

    public String getValue()
    {
        return this.value;
    }
}
