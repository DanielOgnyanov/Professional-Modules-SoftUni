package EXAM.Exam22Feb2020.guild;

public class Player {
    private String name;
    private String clazz;
    private String rank = "Trial";
    private String description = "n/a";

    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public String getClazz() {
        return clazz;
    }

    public String getRank() {
        return rank;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Player %s: %s", getName(), getClazz()))
                .append(System.lineSeparator())
                .append(String.format("Rank: %s", getRank()))
                .append(System.lineSeparator())
                .append(String.format("Description: %s", getDescription()));


        return output.toString().trim();
    }


}
