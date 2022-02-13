package CounterStriker.repositories;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class PlayerRepository implements Repository<Player> {
    private Collection<Player> models;

    public PlayerRepository() {
        this.models = new LinkedHashSet<>();
    }

    @Override
    public Collection<Player> getModels() {
        return this.models;
    }

    @Override
    public void add(Player model) {
        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_PLAYER_REPOSITORY);
        }
        this.models.add(model);
    }

    @Override
    public boolean remove(Player model) {
        return this.models.remove(model);
    }

    @Override
    public Player findByName(String name) {
        return this.models.stream().filter(model -> model.getUsername().equals(name)).findFirst().orElse(null);
    }
}
