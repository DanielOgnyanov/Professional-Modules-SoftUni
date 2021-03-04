package EXAM.Exam22Feb2020.guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }


    public void addPlayer(Player player) {
        if (this.capacity > this.roster.size()) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                this.roster.remove(player);
                return true;
            }
        }
        return false;
    }


    public void promotePlayer(String name) {   ///

        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
            }
        }
    }


    public void demotePlayer(String name) {

        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
            }
        }
    }


    public Player[] kickPlayersByClass(String clazz) {
        List<Player> list = new ArrayList<>();

        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                list.add(player);
            }
        }
        for (Player player : list) {
            if (player.getClazz().equals(clazz)) {
                this.roster.remove(player);
            }
        }

        Player[] arr = new Player[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        System.out.println();
        StringBuilder output = new StringBuilder();
        output.append(String.format("Players in the EXAM.Exam22Feb2020.guild: %s:", name)).append(System.lineSeparator());

        for (Player player : roster) {
            output.append(player).append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
