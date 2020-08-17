# 5. viikko

Sain korjattua viime viikolla ilmaantuneen ongelman botin toiminnassa. Ongelmana oli, että botti jumiutui noin 
15 siirron jälkeen. Kun sain korjattua tämän virheen, huomasin, että pelitilanne päivittyi väärin; botti pyrki usein
liikuttamaan nappuloita, joita ei enää ollut laudalla tai liikkumaan. Lopulta selvisi, että kyse oli siitä, että en
päivittänyt botissa siirtoja Board-olioon, joten siinä oli vanhaa tietoa. 

Tällä hetkellä ongelma on korjattu. Ainoat väärät siirrot, joita botti tekee liittyvät nyt siihen, että kuningasta
ei estetä liikkumasta uhatuille ruuduille: tämä toiminnallisuus täytyy toteuttaa seuraavaksi. Muuten peli on siinä 
vaiheessa, että algoritmin luominen on mahdollista. 

17.8: omia tietorakenteita on aloitettu (testit puuttuvat). Lisäksi loin uuden tavan valita siirtoja: botti tarkistaa, 
voiko se poistaa jonkun vastustajan nappuloista ja jos voi, se poistaa korkea-arvoisimman.

Käytettyjä tunteja: 8
