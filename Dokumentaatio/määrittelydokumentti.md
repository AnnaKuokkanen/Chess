# Shakki 

Tarkoituksena on rakentaa sekä ihmistä että itseään vastaan shakkia pelaava ohjelma.

## Ratkaistavat ongelmat

Ohjelman tulisi osata päättää paras siirto, kun tavoitteena on eliminoida vastapuolen kuninkaan mahdolliset siirrot ja
estää vastapuolta tekemästä samoin.

## Käytettävät algoritmit

Tarkoituksena on käyttää Minimaxiin perustuvaa algoritmia, jota tehostetaan alfa-beta-karsinnalla. Minimax on algoritmi, 
joka sopii tilanteisiin, missä kaksi osapuolta yrittävät tehdä siirtoja, jotka maksimoivat heidän etunsa tietämättä vastapuolen 
liikettä. Erityisesti algoritmi sopii siis kahden pelaajan peleihin, missä pelaajat tekevät vuorotellen siirtoja ja yrittävät 
saada omaa tilannettaan paremmaksi kuin vastustajan. Erityisesti shakki on tällainen peli. 

Minimax-algoritmi olettaa, että molemmat puolet toimivat optimaalisesti, ja toinen pelaajista yrittää saada pelilaudalla olevien 
nappuloiden yhteisarvoa mahdollisimman pieneksi ja toinen mahdollisimman suureksi. Ohjelma luo tietynkorkuisen puun mahdollisista 
siirroista, käy sen rekursiivisesti läpi ja valitsee siirron, joka takaa pienimmän mahdollisen kustannuksen tulevaisuudessa.

Tehostan Minimaxia alfa-beta-karsinnalla, koska mahdollisten siirtojen puu saattaa kasvaa shakkipeleissä hyvin suureksi, ja 
parhaan siirron laskeminen saattaa olla näissä tilanteissa hidasta. Alfa-beta-karsinta sallii joidenkin puun oksien karsinnan, 
koska voidaan todeta, että ne eivät paranna pelaajan tilannetta, joten pelaaja ei koskaan valitse mitään niiden siirroista. 

## Käytettävät tietorakenteet

Ohjelma käyttää alussa Javan HashMap- sekä ArrayList-tietorakenteita, joten kehitän tietorakenteet, jotka vastaavat näitä ja 
korvaavat tarvittavat toiminnallisuudet.

## Syötteet

Ohjelma saa syötteenä vastapuolen värin, siirretyn nappulan tyypin, siirron lähtöruudun sekä nappulan uuden sijainnin. Botin 
täytyy päivitää pelitilanne vastustajan siirron jälkeen sekä oman siirtonsa perusteella. 

## Aika- ja tilavaativuudet

Minimaxin aikavaativuus on O(b^m), missä b on solmun lasten määrä (branching factor) ja m on puun maksimisyvyys. 
Minimaxin tilavaativuus on 

## Lähteet 

[freeCodeCamp](https://www.freecodecamp.org/news/simple-chess-ai-step-by-step-1d55a9266977/)

[Minimax - Wikipedia](https://en.wikipedia.org/wiki/Minimax)

[Minimax - Javatpoint](https://www.javatpoint.com/mini-max-algorithm-in-ai)

[Alpha-Beta-pruning - Wikipedia](https://en.wikipedia.org/wiki/Alpha%E2%80%93beta_pruning)
