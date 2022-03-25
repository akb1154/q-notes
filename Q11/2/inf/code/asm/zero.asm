JSR getDiscount
HOLD

discounted: WORD 00 # von Programm überschrieben
amount: WORD 10 # um wieviel vergünstigt
limit: WORD 150 # ab welchem wert wird vergünstigt
eax: WORD 6535# höhe des einkaufes in eax

getDiscount:
	LOAD eax
	STORE discounted
	CMP limit
	JMPN discount
	RETURN

discount:
	LOAD eax
	SUB amount
	STORE discounted
	RETURN