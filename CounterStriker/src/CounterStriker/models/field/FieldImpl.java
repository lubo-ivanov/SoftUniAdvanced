package CounterStriker.models.field;

import CounterStriker.common.OutputMessages;
import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class FieldImpl implements Field {

    @Override
    public String start(Collection<Player> players) {
        Set<Player> terrorists = setTeam(players, "Terrorist");
        Set<Player> counterTerrorists = setTeam(players, "CounterTerrorist");

        while (!terrorists.isEmpty() && !counterTerrorists.isEmpty()) {
            executeRound(terrorists, counterTerrorists);
            counterTerrorists = removeDeadPlayers(counterTerrorists);

            executeRound(counterTerrorists, terrorists);
            terrorists = removeDeadPlayers(terrorists);
        }
        if (terrorists.isEmpty()) {
            return OutputMessages.COUNTER_TERRORIST_WINS;
        } else {
            return OutputMessages.TERRORIST_WINS;
        }

    }

    private Set<Player> setTeam(Collection<Player> players, String teamName) {
        return players.stream()
                .filter(player -> player.getClass().getSimpleName().equalsIgnoreCase(teamName))
                .collect(Collectors.toSet());
    }

    private Set<Player> removeDeadPlayers(Set<Player> players) {
        return players.stream().filter(Player::isAlive).collect(Collectors.toSet());
    }

    private void executeRound(Set<Player> attackers, Set<Player> defenders) {
        for (Player attacker : attackers) {
            int bulletsFired = attacker.getGun().fire();
            for (Player defender : defenders) {
                defender.takeDamage(bulletsFired);
            }
        }
    }
}
