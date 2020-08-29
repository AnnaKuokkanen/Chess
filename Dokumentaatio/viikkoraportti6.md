Tällä hetkellä kuninkaan shakkitilanteen tarkistaminen toimii ja botti tekee suurimmaksi osaksi laillisia siirtoja. Tornitusta 
ja nappuloiden korotusta ei kuitenkaan ole toteutettu. Laittomat siirrot johtuvat enää siitä, että nappuloiden korotusta ei ole
ohjelmassa toteutettu, mutta Xboard kuitenkin korottaa sotilaan automaattisesti kuningattareksi, jolloin botti saattaa yrittää 
liikuttaa kuningastaan laittomaan ruutuun. Huomasin myös, että olin unohtanut sisällyttää vastapuolen kuninkaan shakkitilanteen 
tarkistamisessa, mutta tämä virhe on nyt korjattu. 

Huomasin, että botti jumittuu välillä shakkitilanteissa paikoilleen, vaikka sillä olisi siirtoja. Se ei yritä tehdä väärää 
siirtoa, vaan jää paikoilleen tekemättä mitään. Kaikki nämä tilanteet ovat tulleet vastaan kun kuningas on ollut shakissa. 
Mallinsin yhden pöytätilanteista testeissä ja botti kyllä sisälsi oikeat siirrot, mutta jostain syystä pelissä se ei tee mitään.
Tämä täytyy selvittää seuraavaksi.

Tällä viikolla kirjoitin Javadocit kaikille sitä vaativille metodeille ja korvasin HashMap-tietorakenteen omalla tietorakenteella.
Lisäksi muokkasin bottia niin, että se voi (periaatteessa) pelata itseään vastaan. Käytännössä se kuitenkin jumittuu usein paikoilleen, 
koska samoja siirtoja pääsee tekemään edestakaisin.

Tunteja käytetty: 12
