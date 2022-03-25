# Das Vektorprodukt

<!--markdownlint-disable-file MD010 MD046-->

Gegeben: 2 Vektoren a (a1, a2, a3) und b (b1, b2, b3)

````markdown  
# Satz
Für a und b nennen wir den Vektor c = a × b das Vektorprodukt ( Kreuzprodukt) von a und b
````

	a × b = (a2 * b3 - a3 * b2), (a3 * b1 - a1 * b3), (a1 * b2 - b1 * a2)

````markdown
# Beispiel
	(2; -4; 1) × (1; 3; 5) = 
		( -20 - 3 ), (1 - 10), (6 + 4) =
		(-23; -9; 10)
````

## Ist a × b == b × a?

Nein, da der Operator "SUB a, b" nicht Gesetz: Kommutativgesetz unterstützt

````markdown
# Merke
a × b = - (b × a);
````

## Bk. pg 113/3

b)  

````markdown

A = [-1;  5;  0]
B = [ 2;  2;  2]
C = [ 2;  2;  0]

AB = [3;  -3;  2]
AC = [3;  -3;  0]

$A  = 0.5 (|AB × AC|)
	= 0.5 (sqrt((0 + 6)² + (0 + 6)² + (-9 + 9)²))
	= 0.5 (sqrt( 36 + 36 + 0))
	= 0.5 sqrt(72) 
	= ~ 4.2
````

a2b3 - a3b2 + a3b1 - a1b3 + a1b2 - b2a1

## pg. 114 / 8a

a = [ 3; 2;-1]
b = [-1; 3; 1]

C = a × b
	= [(); (); ()]


<!--TODO pg 114/8a, 9-->