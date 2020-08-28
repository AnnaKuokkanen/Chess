Mitä täytyy saada tehtyä viimeisellä viikolla?

- Dokumentaatio kuntoon
- tietorakenne HashMapin tilalle
- JUnit- sekä suorituskykytestaus
- mahdollisesti koodin refaktorointia

Tällä hetkellä kuninkaan shakkitilanteen tarkistaminen toimii ja botti tekee suurimmaksi osaksi laillisia siirtoja. Tornitusta 
ja nappuloiden korotusta ei kuitenkaan ole toteutettu. Laittomat siirrot johtuvat enää siitä,että nappuloiden korotusta ei ole
ohjelmassa toteutettu, mutta xboard kuitenkin korottaa sotilaan automaattisesti kuningattareksi, jolloin botti saattaa yrittää 
liikuttaa kuningastaan laittomaan ruutuun. 

* HashMap on nyt korvattu uudella tietorakenteella
* Javadocit on tehty
* vastapuolen kuningas otetaan huomioon shakkitilanteen tarkistamisessa

Tunteja käytetty: 10
