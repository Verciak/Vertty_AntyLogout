# Vertty_AntyLogout
Plugin na AntyLogout, wiele funkcji.

Kod nie jest super dobry, robione na szybko! Pod 1.8.8

## Lista funkcji
- odpychanie od spawna
- tworzenie ściany na lini pvp
- particlesy
- pełna konfiguracja pluginu
- oraz wiele więcej

## Plik config.yml

```yml
###############################
##   Ustawienia anylogouta   ##
###############################
#Odpychanie od spawna
spawn:
  #czy ma byc wlaczone odpychanie od spawna (lepiej niech bedzie wlaczone bo czasami idzie sie zbugowac w scianie)
  status: true

  #czy ma byc wlaczone odpychanie od spawna
  status_sciana: true

  #Permisja do omijania odpychania od spawna
  permission: "logout.admin"

  #czy ma byc wlaczony efekt podczas odpychania od spawna
  efekt: true

  #kordy spawna
  kordy:
    #Kordy X srodka spawna
    x: 0

    #Kordy Z srodka spawna
    z: 0

    #na ktorej kratce jest linia od srodka
    distance: 10

    #id bloku sciany
    id: 95

    #data bloku sciany
    data: 15

#Ogolne ustawienia i wiadomosci
wiadomosci:
  #czy ma byc wlaczona informacja ile pozostalo antyloga (actionbar)
  status_actionbar: true

  #wiadomosc nad paskiem podczas antylogut (actionbar)
  actionbar_inpvp: "&cAntyLogout &8(&c{TIME}&8)"

  #wiadomosc nad paskiem podczas zakonczenia sie antylogut (actionbar)
  actionbar_endpvp: "&aMozesz sie wylogowac!"

  #wiadomosc na chat podczas zakonczenia sie antylogut
  chat_endpvp: "&8» &aSkonczyles walczyc, mozesz sie wylogowac!"

  #wiadomosc na chat podczas wylogowania sie podczas walki
  chat_logout: "&8&l• &cGracz &6{NICK} &cwylogowal sie podczas walki!"

  #wiadomosc na chat podczas zostania zaatakowanym przez damagera
  chat_damager: "&8&l• &4Zostales zaatakowany nie mozesz wylogowac sie przez {TIME} sekund!"

  #wiadomosc na chat podczas zostania zaatakowanym przez damagera
  chat_player: "&8&l• &4Zaatakowales gracza, nie mozesz wylogowac sie przez {TIME} sekund!"

  #Trwanie antylogouta (w sekundach)
  time: 20

#Komendy niedostepne podczas walki
komendy:
  #permisja ktora omija blokade
  permission: "antylog.bypass"

  #wiadomosc na chat gdy ktos wpisze zablokowana komende
  message: "&cTa komenda jest zablokowana podczas walki!"

  #lista zablokowanych komend
  block:
    - "test"
    - "help"

#Blokowanie otwierania danego Inventory
#Typy Inventory:
#True oznacza ze jest zablokowane
ANVIL:
  status: true
  message: "&8&l• &cNie mozesz otwierac &4ANVIL &cpodczas walki!"
BEACON:
  status: true
  message: "&8&l• &cNie mozesz otwierac &4BEACON &cpodczas walki!"
BREWING:
  status: true
  message: "&8&l• &cNie mozesz otwierac &4BREWING &cpodczas walki!"
CHEST:
  status: true
  message: "&8&l• &cNie mozesz otwierac &4CHEST &cpodczas walki!"
DISPENSER:
  status: true
  message: "&8&l• &cNie mozesz otwierac &4DISPENSER &cpodczas walki!"
DROPPER:
  status: true
  message: "&8&l• &cNie mozesz otwierac &4DROPPER &cpodczas walki!"
ENCHANTING:
  status: true
  message: "&8&l• &cNie mozesz otwierac &4ENCHANTING &cpodczas walki!"
ENDER_CHEST:
  status: true
  message: "&8&l• &cNie mozesz otwierac &4ENDER_CHEST &cpodczas walki!"
FURNACE:
  status: true
  message: "&8&l• &cNie mozesz otwierac &4FURNACE &cpodczas walki!"
HOPPER:
  status: true
  message: "&8&l• &cNie mozesz otwierac &4HOPPER &cpodczas walki!"
WORKBENCH:
  status: true
  message: "&8&l• &cNie mozesz otwierac &4WORKBENCH &cpodczas walki!"
HOPPER_MINECART:
  status: true
  message: "&8&l• &cNie mozesz otwierac &4HOPPER_MINECART &cpodczas walki!"
STORAGE_MINECART:
  status: true
  message: "&8&l• &cNie mozesz otwierac &4STORAGE_MINECART &cpodczas walki!"
TRAPPED_CHEST:
  status: true
  message: "&8&l• &cNie mozesz otwierac &4TRAPPED_CHEST &cpodczas walki!"
ITEM_FRAME:
  status: true
  message: "&8&l• &cNie mozesz otwierac &4ITEM_FRAME &cpodczas walki!"
```
## Jeżeli znajdziesz błąd napisz na dc: VerttyPL#7533
