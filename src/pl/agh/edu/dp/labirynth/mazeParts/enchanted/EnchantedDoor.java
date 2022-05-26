package pl.agh.edu.dp.labirynth.mazeParts.enchanted;

import pl.agh.edu.dp.labirynth.mazeParts.normal.Door;
import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;

public class EnchantedDoor extends Door {
    public EnchantedDoor(Room r1, Room r2) {
        super(r1, r2);
    }

    @Override
    public String toString() {
        return "Enchanted Door";
    }
}
