# Kółko i krzyżyk
__Autor__: Karol Działowski

__Zadanie__: [Zadanie 4](https://onedrive.live.com/?cid=8729e46e64549db3&id=8729E46E64549DB3%21427&ithint=folder,&authkey=!AF83fA0MsejZzrQ)

## :^)

![:^)](http://i.imgur.com/eVb6XIx.png)

## Spełnione założenia
### Na ocenę 4
1. Po uruchomieniu programu rozpoczyna się nowa gra z pustą planszą
2. Gra rozgrywana jest z komputerem LUB z innym zawodnikiem.
3. Kiedy gra jest w toku, kliknięcie na wolne pole powoduje jego zaznaczenie i wpisanie odpowiednio „X” lub „O”.
4. Kliknięcie na pole, które nie jest puste nie powoduje żadnych skutków dla przebiegu gry.
5. Gra kończy się, kiedy w jednym wierszu, kolumnie lub na przekątnej znajdą się trzy takie same symbole albo kiedy nie będzie pustych pól na planszy.
6. Po zakończeniu gry wyświetlany jest komunikat w standardowym oknie dialogowym z informacją o tym, kto wygrał grę lub o grze nierozstrzygniętej.
7. Po zakończeniu gry program nie reaguje na klikanie na pola planszy (niezależnie od tego, czy są one puste czy zapełnione).

### Na ocenę 5
1. Gra zawiera przycisk do rozpoczęcia nowej gry – żeby nie trzeba było ponownie uruchamiać programu po zakończeniu pierwszej gry.
2. Kliknięcie przycisku do rozpoczęcia gry powoduje rozpoczęcie gry, czego widzialnym skutkiem jest wyczyszczenie planszy (tj. poszczególnych etykiet).
3. Logika gry zaimplementowana jest w osobnej klasie – na zasadzie analogicznej jak w przypadku gry Papier-Kamień-Nożyce omawianej na zajęciach.
4. Program umożliwia ustawienie symboli używanych przez przeciwników – tj. który gracz używa „X”, a który „O”.

Tutaj nie wiedziałem jak to zaimplementować. W zadaniu nie jest napisane kto ma zaczynać (czy AI czy komputer, ani czy kółko zawsze zaczyna). Dlatego w kodzie w pliku ```Gra.java``` w linii ```70``` są zakomentowane dwie alternatywne możliwości.
* Opcja 1: Losuje czy ma zaczynać AI czy Gracz
``` JAVA
        Random r = new Random();
        int los = r.nextInt(2);
        if (los == 1) {
            ruchAI();
        }
```
* Opcja 2: Jeżeli AI jest kółkiem to zaczyna
``` JAVA
        if (graczAI.getFigura() == 1) {
            ruchAI();
        }
```

### Na ocenę 6
1. Program umożliwia wybór przez gracza gry z komputerem lub z innym graczem.
2. Program umożliwia grę z komputerem, w której komputer wybiera ruchy na podstawie sensownego algorytmu zmierzającego do zwycięstwa (nie losowo). Nie musi to być algorytm najskuteczniejszy z możliwych. Wystarczy, że:
	* jeśli w wierszu, kolumnie lub na przekątnej są dwa pola oznaczone symbolem używanym przez komputera, to komputer wybierze zagranie na to wolne pole w celu zwycięstwa.
	* jeśli w wierszu, kolumnie lub na przekątnej są dwa pola oznaczone symbolem używanym przez zawodnika, to komputer wybierze zagranie na to wolne pole, w celu obrony przed zwycięstwem zawodnika.
c. pozostałe zagrania mogą być losowe.
3. Przed rozpoczęciem gry gracz może wprowadzić imiona/nazwy graczy, które są używane przy wyświetlaniu informacji o zwycięzcy gry – zamiast standardowych napisów typu „Wygrał zawodnik 1.” -> „Wygrał Michał.”
