package CounterStriker.core;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.Comparator;


public class ControllerImpl implements Controller {
    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        switch (type) {
            case "Rifle":
                guns.add(new Rifle(name, bulletsCount));
                break;
            case "Pistol":
                guns.add(new Pistol(name, bulletsCount));
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_TYPE);
        }
        return String.format("Successfully added gun %s.", name);

    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gun = guns.getModels().stream()
                .filter(model -> model.getName().equals(gunName))
                .findFirst().orElse(null);
        if (gun == null) {
            throw new NullPointerException(ExceptionMessages.GUN_CANNOT_BE_FOUND);
        }
        switch (type) {
            case "Terrorist":
                players.add(new Terrorist(username, health, armor, gun));
                break;
            case "CounterTerrorist":
                players.add(new CounterTerrorist(username, health, armor, gun));
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }
        return String.format("Successfully added player %s.", username);
    }

    @Override
    public String startGame() {
        return this.field.start(players.getModels());
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        players.getModels().stream()
                .sorted(Comparator.comparing(Player::getUsername))
                .sorted(Comparator.comparingInt(Player::getHealth).reversed())
                .sorted(Comparator.comparing(player -> player.getClass().getSimpleName()))
                .forEach(sb::append);
        return sb.toString().trim();
    }
}
