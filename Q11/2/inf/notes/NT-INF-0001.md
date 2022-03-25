# NT-INF-0001

## 3.4.1: Bedingte Anweisungen

Bedingungen werden mit Hilfe von Vergleichsbefehlen (````CMP````) umgesetzt.

CMP Subtrahiert den Angegenbenen Wert vom Akkkumulator, setzt die Statusflags, überschreibt ihn aber nicht!

````assembly
LOADI 76
CMPI 100
````

Der weitere Programmablauf kann dann mit Sprungbefehlen (```JMP```)
durch Auswertung der Statusregister beeinflusst werden.

Markenvereinbarung unterstützen dabei die Sprungbefehle.

> Bsp. Sortieren von zwei zahlen  
> x1 = (int)Zahl1
> x2 = (int)Zahl2  
> if (x1 &gt;= x2) [1] = X2; [2] = X1  
> else [1] = X1; [2] = X2

<!-- markdownlint-disable-file MD010-->

````asm
x1: WORD 00
x2: WORD 00

sortltr:
	LOAD x1
	CMP x2
	JMPN swap
	RETURN

swap: 
	LOAD x2
	STORE eax
	LOAD x1
	STORE x2
	LOAD eax
	STORE x1
	RETURN
````
