# Ohjelman testaus 

## Yksikkötestit

Yksikkötestien rivikattavuus: 

![Rivikattavuus](jacocoReport.png)

Sovelluksen sovelluslogiikkaa on testattu JUnit-testeillä

## Suorituskykytestit

Suorituskykytesteissä bottia käytettiin hakusyvyyksillä 1-5 ja jokaisella hakusyvyydellä tehtiin 20 siirtoa. 
Tämän jälkeen jokaisen hakusyvyden siirron keskimääräinen aika laskettiin ja tulostettiin nanosekunteina. 

Tällä hetkellä botti käyttää AlphaBetaPruning-luokkaa ja muut algoritmit on poistettu. Kuitenkin testejä varten 
muokkasin bottia hetkellisesti käyttämään Minimaxia ja talletin tulokset. Huomasin, että molemmat algoritmit olivat 
lähes yhtä nopeita hakusyvyyksillä 1-3. Kuitenkin hakusyvyydellä 4 ero alkoi näkyä ja hakusyvyydellä 5 tavallinen 
minimax oli jo tuplasti hitaampi kuin alfa-beta-karsinnalla varustettu. 

Suorituskykytestien visualisaatio:

![Suorituskyky](suorituskyky.png)
