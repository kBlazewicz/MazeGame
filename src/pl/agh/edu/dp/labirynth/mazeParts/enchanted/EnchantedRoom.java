package pl.agh.edu.dp.labirynth.mazeParts.enchanted;

import pl.agh.edu.dp.labirynth.mazeParts.normal.Room;

public class EnchantedRoom extends Room {
    public EnchantedRoom(int number, int x, int y) {
        super(number, x, y);
    }

    @Override
    public String toString() {
        return "Enchanted Room";
    }
}
