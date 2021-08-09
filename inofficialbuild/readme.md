
**WARNING**

This is an **inofficial build** of the CovPass Check app, based on Version 1.38 (tag).

If you download and install this version please do it on your own risk.

The purpose of this build is to report a bug on the official Google Play Store page:

https://play.google.com/store/apps/details?id=de.rki.covpass.checkapp&hl=de&gl=US

The are two changes on the original files:

File: covpass-android\common-app-covpass-check\src\main\res\values\generated_strings.xml

changed datain line 32 just to show that the app is inofficial: 

<string name="validation_start_screen_title">Übersicht</string>

to

<string name="validation_start_screen_title">*Inoffical* Übersicht</string>

File: covpass-android\common-app\src\main\res\layout\fragment_qr_scanner.xml

changed data (**bug**) line 22:

android:alpha="0.57"

to

android:alpha="0.01"

==============================================================================

**WARNUNG**

Dieses ist ein **inoffizieller Build** der CovPass Check app, basierend auf der Version 1.38 (tag).

Wenn Sie diese Datei herunterladen und installieren machen Sie dieses auf Ihr eigenes Risiko.

Der Grund für diese Datei ist die Meldung eines Fehlers auf der offiziellen Google Play Store Seite:

https://play.google.com/store/apps/details?id=de.rki.covpass.checkapp&hl=de&gl=US

Die Datei beinhalted zwei Änderungen zum offiziellen Build:

Datei: covpass-android\common-app-covpass-check\src\main\res\values
generated_strings.xml

geänderte Daten in Zeile 32 nur um anzuzeigen das es inoffizieller Build ist: 

<string name="validation_start_screen_title">Übersicht</string>

in

<string name="validation_start_screen_title">*Inoffical* Übersicht</string>

Datei: covpass-android\common-app\src\main\res\layout
fragment_qr_scanner.xml

geänderte Daten (**Fehler**) in Zeile 22:

android:alpha="0.57"

in

android:alpha="0.01"
