## 4. viikko

Tällä viikolla huomasin, että Pawn-luokassa oli virhe, sillä nappulan väriä ei otettu huomioon, joten eri puolen nappulat
liikkuivat samaan suuntaan. Virhe on nyt korjattu. Lisäksi tällä viikolla olen toteuttanut botin liikkumismetodin, joka
palautti aluksi ensimmäisen löydetyn mahdollisen siirron. Huomasin botin toiminnassa virheitä.

Ongelmia: botti ei jostain syystä vaikuta päivittävän pelitilannetta oikein ja yrittää liikuttaa nappuloita, jotka eivät
ole laudalla, vaikka mielestäni pidän huolta siitä, että päivitän liikutettavan nappulan uuden sijainnin, vanhan 
sijainnin nappulan arvoksi null, uuden ruudun nappulan arvoksi liikutettavan nappulan, sekä tarvittaessa poistan ruudussa jo
olleen nappulan laudalta.

Kun olen ratkaissut tämän ongelman, täytyy vielä toteuttaa kuninkaan tilanteen tarkistaminen, jotta botti ei tee vääriä 
siirtoja, kun kuningas on uhattuna.

Käytettyjä tunteja: 15
