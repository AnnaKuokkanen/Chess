# Toteutusdokumentti

## Arkkitehtuuri
![Arkkitehtuuri](arkkitehtuuri.png)

## Saavutetut aika- ja tilavaativuudet

## Parannusehdotuksia

Shakkipelissä botille jäi toteuttamatta tornitus ja sotilaiden korottaminen. Koska pelissä on kuitenkin valmis käyttöliittymä, 
ohjelmaan oli lisättävä ehdot vastustajan tornituksen ja korottamisen tarkistukselle. Ihminen voi siis pelatessaan tornittaa ja 
korottaa sotilaitaan ilman että botin toiminta häiriintyy, mutta botti ei koskaan itse tornita, ja jos botin sotilas pääsee laudan 
toiselle reunalle ja muuttuu kuningattareksi, botti ei liikuta sitä, koska luulee sen edlleen olevan sotilas. XBoard huolehtii siitä, 
että ihminen ei voi liikuttaa esim. kuningastaan niin, että tulee shakki, joten vaikka botti ei tiedä, että sotilas on kuningatar, 
se ei häiritse peliä. Jos taas botti pelaa itseään vastaan, ja esimerkiksi valkoisen puolen sotilas korotetaan, mustan pitäisi huomata 
tämä ennen seuraavaa siirtoaan ja päivittää pelitilanne. Nämä puutteet eivät siis varsinaisesti häiritse ydintoiminnallisuutta, 
mutta kuitenkin haittaavat botin päätöksentekoa (etenkin se, että botilla ei ole tietoa sotilaiden korottamisesta).

Botti voi pelata myös itseään vastaan, kuten määrittelydokumentissa on kirjoitettu. Ongelmana on vain se, että botti jumittuu hyvin usein. 
Syynä lienee se, että botin arvio pelitilanteesta perustuu puhtaasti laudalla olevien nappuloiden yhteisarvoon (nappuloiden keskinäiset 
arvot otettu freeCodeCampin sivuilta). Tämän takia jos kummallakin puolella on vain yksi siirto, joka ei johda tietyllä hakusyvyydellä 
minkään oman nappulan menetykseen, botti valitsee aina sen. Jos kummallakaan puolella tämä siirto ei lisää mahdollisia siirtoja, molemmat 
puolet siirtävät kyseisiä nappuloita vuorotellen edestakaisin. Ratkaisuna tähän voisi olla paranneltu tapa arvoida pelitilannetta, joka 
ottaisi huomioon myös nappuloiden sijainnit laudalla.

## Lähteet 

[freeCodeCamp](https://www.freecodecamp.org/news/simple-chess-ai-step-by-step-1d55a9266977/)

[Minimax - Wikipedia](https://en.wikipedia.org/wiki/Minimax)

[Minimax - Javatpoint](https://www.javatpoint.com/mini-max-algorithm-in-ai)

[Alpha-Beta-pruning - Wikipedia](https://en.wikipedia.org/wiki/Alpha%E2%80%93beta_pruning)
