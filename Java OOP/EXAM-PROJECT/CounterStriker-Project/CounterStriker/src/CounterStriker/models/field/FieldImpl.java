package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field {


    @Override
    public String start(Collection<Player> players) {


        List<Player> counter = alivePlayerMethod(players, "CounterTerrorist");

        List<Player> terrorist = alivePlayerMethod(players, "Terrorist");


        int allTerroristGunPoint = getAllGunPoint(terrorist);


        int allCounterGunPoint = getAllGunPoint(counter);


        return findTheWinner(players, counter, terrorist, allTerroristGunPoint, allCounterGunPoint);


    }

    private String findTheWinner(Collection<Player> players,
                                 List<Player> counter,
                                 List<Player> terrorist,
                                 int allTerroristGunPoint,
                                 int allCounterGunPoint) {
        while (true) {

            allTerroristGunPoint = attackMethod(counter, allTerroristGunPoint);
            counter = alivePlayerMethod(players, "CounterTerrorist");

            if (counter.isEmpty()) {
                return TERRORIST_WINS;
            }

            allCounterGunPoint = attackMethod(terrorist, allCounterGunPoint);
            terrorist = alivePlayerMethod(players, "Terrorist");

            if (terrorist.isEmpty()) {

                return COUNTER_TERRORIST_WINS;
            }


        }
    }

    private int attackMethod(List<Player> players, int allPoints) {
        for (Player curr : players) {
            int currAr = curr.getArmor();
            int currHea = curr.getHealth();
            allPoints = currAr + currHea;
            curr.takeDamage(allPoints);

        }
        return allPoints;
    }

    private int getAllGunPoint(List<Player> list) {
        int sum = 0;

        for (Player player : list) {
            sum += player.getGun().getBulletsCount();
        }
        return sum;
    }

    private List<Player> alivePlayerMethod(Collection<Player> players, String classSimpleName) {
        List<Player> result = new ArrayList<>();

        for (Player currPl : players) {
          if (currPl.getClass().getSimpleName().equals(classSimpleName) && currPl.isAlive()) {
              result.add(currPl);
          }
        }
        return result;
    }
}
