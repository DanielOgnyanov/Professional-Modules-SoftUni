package DefiningClasses.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {


    public Person(String name,
                  List<String> companyInfo,
                  List<String> allPokemon,
                  List<String> parents,
                  List<String> children,
                  List<String> car) {
        this.name = name;
        this.companyInfo = companyInfo;
        this.allPokemon = allPokemon;
        this.parents = parents;
        this.children = children;
        this.car = car;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompanyInfo(List<String> companyInfo) {
        this.companyInfo = companyInfo;
    }

    public void setAllPokemon(List<String> allPokemon) {
        this.allPokemon = allPokemon;
    }

    public void setParents(List<String> parents) {
        this.parents = parents;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public void setCar(List<String> car) {
        this.car = car;
    }

    String name;  // Unique

    List<String> companyInfo = new ArrayList<>(); // One

    List<String> allPokemon = new ArrayList<>();

    List<String> parents = new ArrayList<>();

    List<String> children = new ArrayList<>();

    List<String> car = new ArrayList<>(); // One


}
