package com.example.encodeurdecodeur

object CesarCipher {

    fun encoder(texte: String, decalage: Int): String {
        val resultat = StringBuilder()
        for (char in texte) {
            if (char.isLetter()) {
                val base = if (char.isUpperCase()) 'A' else 'a'
                val nouveauChar = (base + (char - base + decalage) % 26)
                resultat.append(nouveauChar)
            } else {
                resultat.append(char)
            }
        }
        return resultat.toString()
    }

    fun decoder(texte: String, decalage: Int): String {
        return encoder(texte, 26 - decalage) // Décalage inverse
    }
}
