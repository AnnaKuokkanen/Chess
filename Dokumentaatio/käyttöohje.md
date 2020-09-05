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

## Pelaaminen Lichessilla

Tarvittaessa tarkemmat ohjeet löytyvät [Lichessin API:sta](https://lichess.org/api)

1. Kloonaa projekti

2. Rekisteröidy [Lichessiin](https://lichess.org/signup)

3. Luo uusi [API access token](https://lichess.org/signup)

4. Päivitä käyttäjäsi botiksi:

```
$ curl -d '' https://lichess.org/api/bot/account/upgrade -H "Authorization: Bearer INSERT YOUR TOKEN HERE"

```
5. On kaksi tapaa välittää käyttäjäsi botille:

a) lisää käyttäjäsi komentoriviltä

b) voit välittää Lichess tokenin LICHESS_TOKEN-ympäristömuuttujan avulla 

6. Kirjautumisen jälkeen valitse "PLAY WITH THE COMPUTER" ja valitse puolesi. Kirjoita terminaalissa $ ./gradlew build,
sitten joko 

```
$ ./gradlew run --args="--lichess"
```
(jos välität tokenin ympäristömuuttujana) tai 

```
$ ./gradlew run --args="--lichess --token=oma_token" 
```
