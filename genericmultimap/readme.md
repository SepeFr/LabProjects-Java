**Esercizio: MultiMappa Generica**

Una MultiMappa è una mappa che può avere più valori associati alla stessa chiave.

### Specifiche della Classe

La classe `MultiMappa` è generica rispetto ai tipi di chiavi e valori e implementa i seguenti metodi:

- `put(k, v)`: Associa il valore `v` alla chiave `k`.
- `putAll(MultiMappa)`: Aggiunge tutti gli elementi della MultiMappa in input alla mappa corrente.
- `removeAll(MultiMappa)`: Rimuove tutte le chiavi della MultiMappa in input dalla mappa corrente.
- `get(k)`: Restituisce l'insieme dei valori associati alla chiave `k`.
- `get(k, p)`: Come sopra, ma restituisce solo i valori che soddisfano il predicato `p`.
- `values()`: Restituisce l'elenco (con duplicati) dei valori contenuti nella MultiMappa.
- `valueSet()`: Restituisce l'insieme dei valori contenuti nella MultiMappa.
- `transformToMultiMap`: Restituisce una MultiMappa in cui le coppie `(k, v)` sono trasformate in `(k, z)` secondo una funzione `(k, v) -> z` (dove `z` può essere di tipo diverso rispetto a quello di `v`).
- `mapEach`: Sostituisce ciascun valore `v` con un valore dello stesso tipo secondo una funzione `(k, v) -> v'`.
- La classe è iterabile sulle coppie `(k, v)` mediante una classe interna `Elemento`.
