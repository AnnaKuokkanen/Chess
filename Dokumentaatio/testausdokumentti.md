# Ohjelman testaus 

## Yksikkötestit

Yksikkötestien rivikattavuus: 

![Rivikattavuus](jacocoReport.png)

Sovelluksen sovelluslogiikkaa on testattu JUnit-testeillä. Suurimmassa osassa tapauksia ohjelman toimintaa on 
jouduttu testaamaan asettamalla manuaalisesti tarvittavat nappulat laudalle ja hakemalla tietyn nappulan lailliset 
siirrot. 

Etenkin itse algoritmin toimintaa on ollut vaikea testata muulla tavoin kuin empiirisesti. Olen kehittänyt joitakin 
pelitilanteita, missä testataan algoritmin kykyä "suunnitella" haluttu siirtomäärä eteenpäin, mutta mitä enemmän laudalla on 
nappuloita ja mitä suurempi hakusyvyys on, sitä vaikeampaa on päätellä mikä on algoritmin kannalta haluttu lopputulos. 

## Suorituskykytestit

Suorituskykytesteissä bottia käytettiin hakusyvyyksillä 1-5 ja jokaisella hakusyvyydellä tehtiin 20 siirtoa. 
Tämän jälkeen jokaisen hakusyvyden siirron keskimääräinen aika laskettiin ja tulostettiin nanosekunteina. 

Tällä hetkellä botti käyttää AlphaBetaPruning-luokkaa ja muut algoritmit on poistettu. Kuitenkin testejä varten 
muokkasin bottia hetkellisesti käyttämään Minimaxia ja talletin tulokset. Huomasin, että molemmat algoritmit olivat 
lähes yhtä nopeita hakusyvyyksillä 1-3. Kuitenkin hakusyvyydellä 4 ero alkoi näkyä ja hakusyvyydellä 5 tavallinen 
minimax oli jo tuplasti hitaampi kuin alfa-beta-karsinnalla varustettu. 

Suorituskykytestien visualisaatio:

![Suorituskyky](suorituskyky.png)

Suorituskykytesti on luokassa PerformanceTest.java. Testi voidaan ajaa komentoriviltä komennolla $ ./gradlew run PerformanceTest.java

| syvyys | Minimax (ns) | Alpha-beta (ns) |
---------|--------------|-----------------|
| 1 | 5844424 | 3716258 |
| 2 | 12007603 | 10195893 |
| 3 | 81951213 | 69698823 |
| 4 | 932767478 | 686162466 |
| 5 | 2056572904 | 1102791754 |
