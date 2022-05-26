# Projektowanie Obiektowe

Zadania wykonane w ramach projektu z przedmiotu Projektowanie Obiektowe.

Instrukcja do wykonania zadania:

[Zadanie](Projektowanie%20Obiektowe%209e00e48c927443c088d33be75a2eb384/Zadanie%20ceeb866d4c3b4156a73cb32eec180c60.md)

### 1. Wzorzec builder

1. stworzenie interfejsu MazeBuilder

```java
Room buildRoom();
void buildWalls(Room room);
void buildDoor(int room1,int room2);
Maze getMaze();
```

1. zmiana implementacji metody createMaze:

```java
public class MazeGame {
    public Maze createMaze(MazeBuilder mazeBuilder){
        Room room1 = mazeBuilder.buildRoom();
        Room room2 = mazeBuilder.buildRoom();

        mazeBuilder.buildWalls(room1);
        mazeBuilder.buildWalls(room2);

        mazeBuilder.buildDoor(room1,room2);
	}
}
```

1. Pozwoliło to na odseparowanie implementacji w metodzie maze builder, tzn nie tworzenie konkretnych instancji klas i operowania na ich metodach, a jedynie wywołanie serii poleceń dla budowniczego.
2. Do klasy Room dodałem jego współrzędne oraz do konstruktora klasy potrzebne do określania wspólnych ścian i układu labiryntu.

5.

```java
public class Main {

    public static void main(String[] args) {
        MazeGame mazeGame = new MazeGame();
        StandardBuilderMaze builder = new StandardBuilderMaze();
        Maze maze = mazeGame.createMaze(builder);
        System.out.println(maze.getRoomNumbers());
    }
}
```

1. 

```java
public static void main(String[] args) {
        MazeGame mazeGame = new MazeGame();
        CountingMazeBuilder builder = new CountingMazeBuilder();
        Maze maze = mazeGame.createMaze(builder);
        System.out.println(countingMazeBuilder.getCounts());
//        System.out.println(maze.getRoomNumbers());
    }
```

Implementacje metod klasy MazeBuilder zwracają null zamiast obiektów.

![Untitled](Projektowanie%20Obiektowe%209e00e48c927443c088d33be75a2eb384/Untitled.png)

### 2. Wzorzec Abstract Factory

1. Stworzyłem klasę abstrakcyjną FactoryMazeBuilder, która generuje labirynt z pliku o następującym schemacie:

```
współrzędna_x1 współrzędna_y1
współrzędna_x2 współrzędna_y2
współrzędna_x3 współrzędna_y3
...
Doors
...
numer_pokoju_1 numer_pokoju_2
numer_pokoju_0 numer_pokoju_1

```

powyższy plik ma stworzyć 3 pokoje (indeksowane od 0) i drzwi z pokoi 1→2 oraz 0→1

![Untitled](Projektowanie%20Obiektowe%209e00e48c927443c088d33be75a2eb384/Untitled%201.png)

Stworzyłem klasę abstrakcyjną Maze Factory, aby zastosować wzorzec projektowy, poszczególne instancje obiektów tworzę poprzez metodę, którą będzie można przesłonić w klasie którą tworzymy np NormalMazeFactory

```java
public abstract Door createDoor(Room room1, Room room2);

public abstract Wall createWall() ;

public abstract Room createRoom(int x, int y);
```

w klasie MazeGame dodałem drugą metodę o tej samej, z innym argumentem.

```java
public Maze createMaze(MazeFactory mazeFactory){
        FactoryMazeBuilder builder = new FactoryMazeBuilder(mazeFactory);
        return builder.generateMaze("src/pl/agh/edu/dp/maps/map.txt");
    }
```

3.

Tworzę klasę EnchantedMazeFactory i przesłaniam potrzebne metody:

```java
public class EnchantedMazeFactory extends MazeFactory {

    public Door createDoor(Room room1, Room room2) {
        return new EnchantedDoor(room1, room2);
    }

    public Wall createWall() {
        return new EnchantedWall();
    }

    public Room createRoom(int x, int y) {
        return new EnchantedRoom(currentMaze.getRoomNumbers(), x, y);
    }
}
```

Tworzę również potrzebne dziedziczące klasy.

Wywołanie funkcji main :

```java
MazeFactory builder = new NormalMazeFactory();
Maze maze = mazeGame.createMaze(builder);
System.out.println(maze.getRoomNumbers());

MazeFactory enchantedBuilder = new EnchantedMazeFactory();
Maze enchantedMaze = mazeGame.createMaze(enchantedBuilder);
System.out.println(enchantedMaze.getRoomNumbers());
```

Daje nam poniższy rezultat (po nadpisaniu metod toString dla pokoi i wyświetleniu list)

```java
[Normal Room, Normal Room, Normal Room, Normal Room]
4
[Enchanted Room, Enchanted Room, Enchanted Room, Enchanted Room]
4
```

Analogicznie z poprzednim przypadkiem utworzyłem BombedMazeFactory

### 3. Wzorzec Singleton

Aby zmienić klasę MazeFactory aby była Singletonem dodałem 3 prywatne pola MazeFactory oraz metody do ich pobierania:

```java
private static MazeFactory normalMazeFactoryInstance =null;

public static MazeFactory getNormalMazeFactoryInstance(){
        if (normalMazeFactoryInstance == null){
            normalMazeFactoryInstance = new NormalMazeFactory();
        }
        return normalMazeFactoryInstance;
    }
```

![Untitled](Projektowanie%20Obiektowe%209e00e48c927443c088d33be75a2eb384/Untitled%202.png)

### Struktura po zastosowaniu wzorców:

![Klasy korzystające ze wzorca Builder](Projektowanie%20Obiektowe%209e00e48c927443c088d33be75a2eb384/Untitled%203.png)

Klasy korzystające ze wzorca Builder

![Klasy korzystające ze wzorca AbstractFactory oraz Singleton](Projektowanie%20Obiektowe%209e00e48c927443c088d33be75a2eb384/Untitled%204.png)

Klasy korzystające ze wzorca AbstractFactory oraz Singleton

![Części składające się na budowę pokoi](Projektowanie%20Obiektowe%209e00e48c927443c088d33be75a2eb384/Untitled%205.png)

Części składające się na budowę pokoi

![Untitled](Projektowanie%20Obiektowe%209e00e48c927443c088d33be75a2eb384/Untitled%206.png)

### 4. Player

**Wzorzec Singleton** jest zaimplementowany ponieważ dla wywołania:

```java
MazeFactory bombedMazeFactory = MazeFactory.getBombedMazeFactoryInstance();
MazeFactory bombedMazeFactory2 = MazeFactory.getBombedMazeFactoryInstance();
System.out.println(bombedMazeFactory2+"\n"+bombedMazeFactory);

OTRZYMUJEMY:
pl.agh.edu.dp.labirynth.factory.BombedMazeFactory@523884b2
pl.agh.edu.dp.labirynth.factory.BombedMazeFactory@523884b2
```

**GRACZ**

Do klasy Maze dodałem metodę pobierającą pokój startowy, oraz koncowy dla gracza

zmieniłem interfejs MapSite aby po wybraniu metody Enter z konkretnego pokoju, zwracała nowy pokój.

klasa gracz:

![Untitled](Projektowanie%20Obiektowe%209e00e48c927443c088d33be75a2eb384/Untitled%207.png)

w klasie FactoryBuilder dodałem nowy konstruktor pozwalający na dobudowywanie do istniejącego labiryntu. 

**GRA**

1. przykładowa gra dla mapy o następującym układzie:
    
    ![IMG_8D873C918032-1.jpeg](Projektowanie%20Obiektowe%209e00e48c927443c088d33be75a2eb384/IMG_8D873C918032-1.jpeg)
    

![Untitled](Projektowanie%20Obiektowe%209e00e48c927443c088d33be75a2eb384/Untitled%208.png)

1. Przykładowa gra po wybuchu na tej samej mapie:

![Untitled](Projektowanie%20Obiektowe%209e00e48c927443c088d33be75a2eb384/Untitled%209.png)

### 5. GUI

Z wykorzystaniem Swing UI designer wykonałem bardzo proste GUI do pierwszoosobowej rozgrywki.

![Untitled](Projektowanie%20Obiektowe%209e00e48c927443c088d33be75a2eb384/Untitled%2010.png)

Aby działała zarówno część podstawowa jak i część dodatkowa z GUI do wysyłania wiadomości stworzyłem dodatkową abstrakcyjną klasę OutputManager o statycznych polach i metodach, które wypisują wiadomości na konsolę oraz GUI.

 Na potrzeby GUI do klasy Player dodałem metodę deactivate, blokującą wykonywanie dalszych ruchów po wygranej lub bombardowaniu.