package com.lyndir.masterpassword;

import com.lyndir.lhunath.opal.system.logging.Logger;


/**
 * <i>07 04, 2012</i>
 *
 * @author lhunath
 */
public enum MPTemplateCharacterClass {

    UpperVowel( 'V', "AEIOU" ),
    UpperConsonant( 'C', "BCDFGHJKLMNPQRSTVWXYZ" ),
    LowerVowel( 'v', "aeiou" ),
    LowerConsonant( 'c', "bcdfghjklmnpqrstvwxyz" ),
    UpperAlphanumeric( 'A', "AEIOUBCDFGHJKLMNPQRSTVWXYZ" ),
    Alphanumeric( 'a', "AEIOUaeiouBCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz" ),
    Numeric( 'n', "0123456789" ),
    Other( 'o', "@&%?,=[]_:-+*$#!'^~;()/." ),
    Any( 'x', "AEIOUaeiouBCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz0123456789!@#$%^&*()" ),
    Space( ' ', " " );

    @SuppressWarnings("UnusedDeclaration")
    private static final Logger logger = Logger.get( MPTemplateCharacterClass.class );

    private final char   identifier;
    private final char[] characters;

    MPTemplateCharacterClass(final char identifier, final String characters) {

        this.identifier = identifier;
        this.characters = characters.toCharArray();
    }

    public char getIdentifier() {

        return identifier;
    }

    public char getCharacterAtRollingIndex(final int index) {

        return characters[index % characters.length];
    }

    public static MPTemplateCharacterClass forIdentifier(final char identifier) {
        for (MPTemplateCharacterClass characterClass : values())
            if (characterClass.getIdentifier() == identifier)
                return characterClass;

        throw logger.bug( "No character class defined for identifier: %s", identifier );
    }
}
