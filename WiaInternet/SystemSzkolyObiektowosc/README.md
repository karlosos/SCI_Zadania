# Jak to działa?
Bazową klasą jest **_osoba_** która posiada pola identyfikujące osobę. Po tej klasie dziediczą **_uczen_** i **_nauczyciel_**. Każdy obiekt **_uczen_** tworzy podwładny obiekt **_oceny_**, czyli jest to jednym z pół klasy. Dlatego możemy się odnosić do ocen poszczególnych uczniów. Klasa **_uczen_** pozwala poprzez interfejs klasy **_oceny_** dodawać oceny, pobierać oceny i ich średnie ocen. Aby dodawać oceny potrzebujemy specjalnego hasła. Klasa nauczyciel może dodawać oceny za prośrednictwem publicznej metody ucznia i własnego pola z hasłem. Dlatego nauczyciel nie musi podawać hasła aby dodać ocenę.

Pozdr ;-)
