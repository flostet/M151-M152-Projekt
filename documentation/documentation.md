# M151 / M152 - Crypto Trading Platform

## Einführung

In diesem Projekt erstelle ich eine Platform, um mit Crypto-Währungen zu traden. Es wird dabei mit fiktivem Geld getradet und die Coins die man kauft, gehören einem danach natürlich nicht. Es gibt Admin Benutzer, die Crypto-Währungen hinzufügen können und auch bestehende Entfernen. Diese Admin-Nutzer können jedoch keine Währungen kaufen. Die "normalen" Benutzer können ihr Konto mit Spielgeld aufladen und damit dann die Währungen kaufen.

## Personengruppen

**Hanspeter Meyer**

* 67 Jahre alt
* Pensioniert
* hat als Lastwagen-Chauffeur gearbeitet

![Hanspeter Meyer](src/HanspeterMeyer.jpg)
_Quelle: thispersondoesnotexist.com_

Hanspeter hat sich mit seinem Job etwas angespart und hat im Internet von Krypto-Währungen gehört. Er möchte einen Teil seines erspartem in Krypto-Währungen investieren. Er möchte eine Plattform, auf der er einfach und unkompliziert seine Währungen kaufen kann und diese darauf hodln.

**Maria Jäger**

* 45 Jahre alt
* Architektin
* 7'000 CHF Lohn

![Hanspeter Meyer](src/MariaJaeger.jpg)
_Quelle: thispersondoesnotexist.com_

Maria hat durch Ihren Sohn von Krypto-Währungen gehört und hat sich in den letzten Monaten sehr gut darüber informiert. Jetzt hat sie den Entschluss gefasst, dass sie monatlich 1'000 Franken in Krypto investieren möchte. Ihre Anforderungen an eine Trading-Platform sind, dass die Platform möglichst viele Coins im Portfolio hat, da sie besonders in Altcoins investieren möchte.

**Kevin-Justin Müller**

* 21 Jahre alt
* Ausbildung als Elektriker
* 950 CHF Lohn

![Hanspeter Meyer](src/KevinJustinMüller.jpg)
_Quelle: thispersondoesnotexist.com_

Kevin-Justin hat von einem Kollegen gehört, der sein Investment verzehnfacht hat und möchte jetzt auch möglichst schnell viel Geld verdienen. Er hat bis jetzt nur von Bitcoin gehört und geht deshalb mit seinen 2500 CHF, die er sich erspart hat All-In. Er hofft auf den grossen Gewinn und möchte deshalb möglichst einfach sehen, um wie viel sein Investment bereits gewachsen ist.

**Philip Trummer**

* 29 Jahre alt
* CEO der Trading Platform
* verdient 30% des monatlichen Gewinns

![Hanspeter Meyer](src/PhilipTrummer.jpg)
_Quelle: thispersondoesnotexist.com_

Philip ist der CEO der ganzen Platform und damit ein Admin-Benutzer. Er möchte deshalb einerseits die Platform unterhalten, also neue Währungen hinzufügen oder bereits implementierte Entfernen. Anderseits möchte er aber auch selber investieren und dafür möchte er ein möglichst schönes Design und einen guten Überblick über seine Investments.

## User Stories

Als Benutzer möchte ich einen Account erstellen können, sodass ich mit dem Investieren anfangen kann.

Als Benutzer und Admin möchte ich mich mit einem Account anmelden können, sodass ich die Platform nutzen kann.

Als Benutzer möchte ich Geld auf mein Trading-Konto laden, sodass ich dieses Investieren kann.

Als Benutzer möchte ich die aktuellen Preise der Währungen sehen, damit ich entscheiden kann ob ich kaufe oder verkaufe.

Als Benutzer möchte ich eine Krypto-Währung möglichst schnell kaufen und verkaufen können, damit ich einen möglichst guten Preis bekomme.

Als Admin möchte ich neue Währungen hinzufügen können und bestehen löschen, damit die Benutzer eine möglichst gute Auswahl haben.

## Technologien

### Frontend
* Deno als Framework
* HTML
* CSS
* JavaScript

### Backend
* Java Spring als Framework
* Gradle als Package Manager

### Datenbank
* Postgres DB

### Zusätzlich
* Alle Teile werden in einem jeweiligen Docker Container laufen
* Eine API, um die aktuellen Crypto-Preise zu erhalten