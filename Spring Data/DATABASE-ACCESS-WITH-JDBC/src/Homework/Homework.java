package Homework;

import java.sql.*;
import java.util.*;

public class Homework {


    // Connection Settings
    public static final String CONNECTION_STRING =
            "jdbc:mysql://localhost:3306/";
    public static final String MINIONS_TABLE_NAME = "minions_db";

    protected Connection connection;

    public void setConnection(String user, String password) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user",user);
        properties.setProperty("password",password);

        connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db",properties);

    }


    //////////////////////////////////////////////////////////////////////////////////////////////
    public void getVillainsNameEx2() throws SQLException {
        String query = "SELECT `v`.`name` , COUNT(`mv`.`minion_id`) AS 'count'\n" +
                "FROM `villains` AS `v`\n" +
                "\n" +
                "JOIN `minions_villains` AS `mv` \n" +
                "ON `v`.`id` = `mv`.`villain_id`\n" +
                "GROUP BY `v`.`id`\n" +
                "HAVING `count` > 15\n" +
                "ORDER BY `count` DESC";

        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){

            System.out.printf("%s %d%n", resultSet.getString("name")
                    ,resultSet.getInt("count"));

        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////

    public void getMinionsNameEx3() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter villain id:");

        int villainId = Integer.parseInt(scanner.nextLine());

        String nameVillains = getEntityNameById(villainId, "villains");

        if(nameVillains == null) {

            System.out.printf("No villain with ID %d exists in the database.\n",villainId);
            return;
        }


        System.out.printf("Villain: %s%n", nameVillains);

        String query = "SELECT m.name , m.age FROM minions AS m\n" +
                "JOIN minions_villains mv ON m.id = mv.minion_id\n" +
                "WHERE mv.villain_id = ?";

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1,villainId);

        ResultSet resultSet = statement.executeQuery();

        int counter = 1;

        while (resultSet.next()) {
            System.out.printf("%d. %s %d%n",
                    counter++, resultSet.getString("name"),
                    resultSet.getInt("age"));
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////



    public void addMinionEx4() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter minions info: name, age, town name:");
        String[] minionInfo = scanner.nextLine().split("\\s+");
        System.out.printf("Enter villain name:");
        String[] villainsInfo = scanner.nextLine().split("\\s+");

        String minionName = minionInfo[0];
        int age = Integer.parseInt(minionInfo[1]);
        String townName = minionInfo[2];

        String villainName = villainsInfo[0];

        int townId = getEntityIdByName(townName,"towns");


        if(townId < 0) {
            insertEntityIntoTowns(townName);
            System.out.printf("Town %s was added to the database.\n",townName);
        }

        int villainId = getEntityIdByName(villainName,"villains");

        if (villainId < 0) {
            insertEntityIntoVillains(villainName);
            System.out.printf("Villain %s was added to the database.\n",villainName);
        }
        townId = getEntityIdByName(townName,"towns");
        insertMinion(minionName,age,townId);

        villainId = getEntityIdByName(villainName,"villains");
        int minionId = getEntityIdByName(minionName,"minions");

        String query = "INSERT INTO minions_villains VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,minionId);
        statement.setInt(2,villainId);
        statement.execute();

        System.out.printf("Successfully added %s to be minion of %s.\n",minionName,villainName);

    }


    ///////////////////////////////////////////////////////////////////////////////////////////////




    public void changeTownsNameCasingEx5() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter country name:");
        String countryName = scanner.nextLine();



        String query = "UPDATE towns SET name = UPPER(name) WHERE country = ?";

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1,countryName);

        int townAffected = statement.executeUpdate();

        if(townAffected == 0) {
            System.out.println("No town names were affected.");
            return;
        }

        System.out.printf("%d  town names were affected.%n",townAffected);

        findAffectedCity(countryName);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////

    public void printAllMinionNamesEx7() throws SQLException {
        String query = "SELECT name FROM minions";
        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();

        List<String> firstElement = new ArrayList<>();

        while (resultSet.next()) {
            firstElement.add(resultSet.getString("name"));
        }

        int positionCount = 1;


        while (firstElement.size() > 0) {

            if (positionCount % 2 == 1) {
                System.out.println(firstElement.get(0));
                firstElement.remove(0);
                positionCount++;

            } else {
                System.out.println(firstElement.get(firstElement.size()-1));
                firstElement.remove(firstElement.size()-1);
                positionCount++;
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////

    public void increaseMinionsAgeEx8() throws SQLException {
        System.out.println("Enter minions ids separated by space:");
        Scanner scanner = new Scanner(System.in);
        String [] ids = scanner.nextLine().split("\\s+");

        for (int i = 0; i < ids.length; i++) {

            int currId = Integer.parseInt(ids[i]);

            setAgeAndName(currId);


        }


        printEx8Result();


    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public void increaseAgeEx9() throws SQLException {
        System.out.println("Enter minion id:");
        Scanner scanner = new Scanner(System.in);
        int minionId = Integer.parseInt(scanner.nextLine());

        String query = "CALL usp_get_older(?)";

        CallableStatement statement = connection.prepareCall(query);
        statement.setInt(1,minionId);

        statement.execute();

        printResult(minionId);
    }





    // ALL METHOD START HERE


    private void setAgeAndName(int currId) throws SQLException {
        String query = "CALL set_age_and_name(?)";

        CallableStatement statement = connection.prepareCall(query);
        statement.setInt(1,currId);
        statement.execute();
    }

    private void printEx8Result() throws SQLException {
        String query = "SELECT name, age FROM minions";

        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " +
                    resultSet.getInt("age"));
        }


    }


    private String getEntityNameById(int entityId, String tableName) throws SQLException {
        String query = String.format("SELECT name FROM %s WHERE id = ?",tableName);

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1,entityId);

        ResultSet resultSet = statement.executeQuery();


        return  resultSet.next() ? resultSet.getString("name") : null;

    }


    private void insertMinion(String minionName, int age, int townId) throws SQLException {
        String query = "INSERT INTO Minions(Name, Age, town_id) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,minionName);
        statement.setInt(2,age);
        statement.setInt(3,townId);
        statement.execute();

    }

    private void insertEntityIntoVillains(String villainName) throws SQLException {
        String query = "INSERT INTO villains(name,evilness_factor) value(?,?)";

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1,villainName);
        statement.setString(2,"evil");
        statement.execute();
    }

    private void insertEntityIntoTowns(String townName) throws SQLException {
        String query = "INSERT INTO towns(name) value(?)";

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1,townName);
        statement.execute();
    }

    private int getEntityIdByName(String entityName, String tableName) throws SQLException {

        String query = String.format("SELECT id FROM %s WHERE name = ?", tableName);

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1,entityName);

        ResultSet resultSet = statement.executeQuery();

        return resultSet.next() ? resultSet.getInt(1) : -1;



    }


    private void findAffectedCity(String countryName) throws SQLException {
        String nameTownQuery = "SELECT name FROM towns WHERE country = (?)";
        PreparedStatement st = connection.prepareStatement(nameTownQuery);

        st.setString(1,countryName);
        ResultSet resultSet = st.executeQuery();

        System.out.print("[");
        while (resultSet.next()) {

            boolean last = resultSet.isLast();
            if(last) {
                System.out.printf(resultSet.getString("name"));
                System.out.print("]");
                return;
            }
            System.out.printf(resultSet.getString("name") + "," + " ");

        }

    }


    private void printResult(int minionId) throws SQLException {
        String query = "SELECT name , age FROM minions WHERE id = (?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,minionId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.print(resultSet.getString("name")
                    + " " + resultSet.getInt("age"));
        }
    }
}
