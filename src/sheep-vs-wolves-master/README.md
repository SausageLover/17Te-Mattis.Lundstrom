Detta är en uppgift i kursen Programmering 2.

Sheep vs Wolves
===
Den här uppgiften går ut på att göra en simulering av ett ekosystem bestående av vargar, får och växter. Bifogat till denna uppgift finns ett grafiskt gränssnitt som är uppbyggt av olika delar. Testa först att kompilera och köra programmet (PastureGUI är den körbara klassen) för att se hur det fungerar (Bry dig inte om att det åstadkommer exekveringsfel än).

Repositoryt finns här: https://github.com/TOENITG/sheep-vs-wolves
Ladda ner som ZIP-fil.
Skapa ett nytt projekt i Eclipse/NetBeans
Importera filerna till ditt projekt. Enklast är att packa upp ZIP-filen och sedan dra och släppa dem på src-mappen i projektet du skapade nyss.
Du behöver flytta alla bildfiler till bin-mappen i ditt projekt. Gör det i utforskaren.
Kontrollera att PastureGUI går att köra.

Uppvärmning
---
Dummy-objektet i simulationen rör sig enbart åt höger och bryr sig inte om att planen tar slut.
Editera filen Dummy.java och ändra så att dummyn istället rör sig i en slumpmässig riktning.
Gör så att dummyn inte flyttar om den håller på att röra sig utanför gränsen för planen.
Lägg till några fler dummys som rör sig på planen.

Förklara koden
---
Gå igenom koden till klasserna PastureGUI och Pasture och försök förstå hur den fungerar. Skriv en förklaring vad de olika metoderna gör och vad de olika instansvariablerna används till. Förklara även hur de hänger ihop med varandra. Detta kan du göra direkt i koden.

Utöka programmet
---
1)    I PastureGUI skapas en JButton för startknappen. Lägg till en knapp ’Stop’ samt en knapp ’Exit’. Stop-knappen ska stoppa simuleringen medans exit-knappen ska avbryta programmet. För att avbryta programmet kan du skriva `System.exit(0);`

Följande steg måste göras:

* Skapa knapparna.
* Ändra GridLayouten på JPanel buttons så att det får plats tre knappar och lägg till de nya knapparna.
* Lägg till Actionlisteners till de nya knapparna.
* Implementera Actionevents för de nya knapparna.

2) Skapa en abstrakt klass LivingThing som implementerar gränssnittet Entity. Klassen ska implementera metoderna getPosition och setPosition (Vilka kan tas från Dummy) medan de andra i gränssnittet Entity ska vara abstrakta.

3)    Skapa en subklass Plant till LivingThing. En växt ska ’växa’ efter ett visst antal tick i slumpmässig riktning. (Dvs skapa en ny växt). Använd ’plant.gif’ för att representera växten grafiskt. Testa klassen genom att lägga till några plantor i konstruktorn till Pasture.

4)    Skapa en abstrakt subklass Animal till LivningThing. Klassen ska ha variablerna int maxFood och int currentFood. Animal ska även ha en metod public void move() som flyttar djuret i en slumpmässig riktning. Variabeln currentFood ska räknas ner varje gång djuret flyttar sig och djuret dör om currentFood hamnar på noll. Tag hjälp av koden i dummy.

5)    Skapa en subklass Sheep till Animal. Ett får rör sig varje tick i en slumpmässig riktning. Om ett får hamnar på samma ruta som en växt äter den upp växten och currentFood sätts till maxFood. Ett får kan representeras med hjälp av bilden ’sheep.gif’. Testa klassen genom att lägga till några får i konstruktorn till Pasture.

6)    Skapa en subklass Wolf till ’Animal’ En varg ska röra sig i en slumpmässig riktning varje tick. Om en varg hamnar på samma ruta som ett får äter vargen upp fåret och currentFood sätts till maxFood. En varg kan representeras av bilden ’wolf.gif’. Testa klassen genom att lägga till några vargar i konstruktorn till Pasture.

7)    Testa med olika värden på antalet får, vargar och plantor och deras egenskaper så att inga arter dör ut på så lång tid som möjligt.

Extrauppgifter
---
* Ge djuren möjlighet att röra sig olika fort (de flyttar efter ett visst antal tick)

* Se till så att alla ändringar av positioner sker i klassen Pasture ( För att öka stabiliteten av programmet).

* Lägg till metoder för får och vargar så att de kan föröka sig vid en viss tidpunkt (Förslagsvis när de har levt ett visst antal ticks och är mätta)

* Skapa ett till grafiskt gränssnitt där man kan ange olika parametrar till programmet ( Antal får, vargar, plantor, djurens egenskaper osv)

Redovisning
---
Följande ska lämnas in:

* Beskrivningen av PastureGUI och Pasture
* Kommenterad källkod till de olika klasserna
