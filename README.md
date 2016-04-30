# Torneo-Relampago

Buscar el q tenga menos hs disponibles menor o igual a 6
fijarlo y armar su subconjunto  en base a
buscar el prox minimo hs disponibles y ver su interseccion.
meterlo en el conjunto, actualizar los valores de verdad de esos hs ya no disponibles.
y repetirlo para el prox minimo hs disponible
Luego hacerlo para todos los jugadores, desde el que tienen menos hs disponibles, al que tiene mas.

--------------------------------------
             1-SACO EL MIN de matriz 	
		(y lo meto en un conjunto, solo el jugador)
	     		2-Para los jugadores restantes (saco el min de los que quedan).
	     			3-Busco la primer interseccion entre ambos jugadores en hs.
				4-Actualizo las hs disponibles
				5-tratado, Meto al conjunto el 2do minimo 	
			-2vuelvo a 2- hasta que trate todos los siguientes minimos.
	              -Sacados y tratados armar la lista del primer min
	     -1 Sigo con el proximo min	