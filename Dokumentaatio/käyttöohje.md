# Käyttöohje shakkipeliin

Peliä voi pelata omalla koneella käyttämällä [XBoardia](https://www.gnu.org/software/xboard/) (tällä pelaamista kokeiltu 
kehittämisvaiheessa) tai verkossa [Lichess-ohjelmalla](https://lichess.org/).

## Pelaaminen XBoardilla

1. Hae ohjelma koneellesi
```
git clone https://github.com/AnnaKuokkanen/Shakki.git
```

2. Luo ohjelmasta jar-tiedosto
```
./gradlew build
```

3. Lataa XBoardin viimeisin versio ja pura se haluamassasi hakemistossa komennolla
```
$ tar xvzf xboard-4.9.0.tar.gz
```

4. Käynnistä XBoard
```
$ xboard 
```

5. Valitse Engine ja sen alla Edit Engine List

6. Lisää listaan polku jar-tiedostoosi

  "tira-chess" -fcp "java -jar /home/local/ ..oma polkusi.. /chess/build/libs/chess-all.jar"
  
Valitse sitten "commit changes" ja "OK".

7. Valitse jälleen Engine ja sen alla Load New 1st Engine.

8. Valitse listalta omasi ja paina "OK". 

9. Aloita pelaaminen valkoisilla ja botin pitäisi vastata omalla siirrollaan.

Valikosta voi valita myös Mode > Machine white, jolloin botti pelaa valkoisilla, sekä Mode > Two machines, jolloin botti
pelaa itseään tai jotain muuta ohjelman tekoälyä vastaan. Ohjelma toimii näissä tapauksissa periaatteessa, mutta koska 
botti arvioi pelitilannetta pelkästään laudalla olevien nappuloiden yhteisarvon perusteella, ohjelma jumittuu usein tekemään 
samoja siirtoja itseään vastaan.
