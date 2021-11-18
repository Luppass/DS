package e3;

import java.util.ArrayList;
import java.util.Objects;

public class Melody {

    /**
     * Creates an empty Melody instance .
     */

    private final ArrayList<NotesClass> notasList = new ArrayList<>();

    public Melody() {

    }

    /**
     * Add a note at the end of this melody .
     *
     * @param note       The note to add
     * @param accidental The accidental of the note
     * @param time       The duration of the note in milliseconds
     * @throws IllegalArgumentException if the note , the accidental
     *                                  or the time are not valid values .
     */

    public void addNote(Notes note, Accidentals accidental, float time) {

        if (note == null || accidental == null || time == 0.0f) {
            throw new IllegalArgumentException("Not valid values");
        } else {
            NotesClass notes = new NotesClass(note, accidental, time);
            notasList.add(notes);
        }

    }

    /**
     * Returns the note on the given position
     *
     * @param index The position of the note to get .
     * @return The note on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */

    public Notes getNote(int index) {

        if (index >= 0 && index < notasList.size()) {
            return notasList.get(index).getName();
        }
        else throw new IllegalArgumentException("index is not a valid position");
    }

    /**
     * Returns the accidental of the note on the given position
     *
     * @param index The position of the accidental to get .
     * @return The accidental on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public Accidentals getAccidental(int index) {

        if (index >= 0 && index < notasList.size()) {
            return notasList.get(index).getAccidental();
        }
        else throw new IllegalArgumentException("index is not a valid position");
    }

    /**
     * Returns the duration of the note on the given position
     *
     * @param index The position of the time to get .
     * @return The time on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */

    public float getTime(int index) {
        if (index >= 0 && index < notasList.size()) {
            return notasList.get(index).getDuration();
        }
        else throw new IllegalArgumentException("index is not a valid position");
    }

    /**
     * Returns the number of notes in this melody .
     *
     * @return The number of notes in this melody .
     */
    public int size() {
        return notasList.size();
    }

    /**
     * Returns the duration of this melody .
     *
     * @return The duration of this melody in milliseconds .
     */
    public float getDuration() {
        float sum = 0;

        for (NotesClass i : notasList) {
            sum += i.getDuration();
        }
        return sum;
    }


    /**
     * Performs the equality tests of the current melody with another melody
     * passed as a parameter . Two melodies are equal if they represent the same
     * music fragment regardless of the name of its notes .
     *
     * @param o The melody to be compared with the current melody .
     *          6
     * @return true if the melodies are equals , false otherwise .
     */

    public boolean equals(Object o) {
        int aux = 0;

        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        if (((Melody) o).notasList.size() != notasList.size()) return false;

        for (int i = 0; i < notasList.size(); i++) {
            Notes notes1 = notasList.get(i).getName();
            Accidentals accidentals1 = notasList.get(i).getAccidental();
            float duration1 = notasList.get(i).getDuration();
            Notes notes2 = ((Melody) o).notasList.get(i).getName();
            Accidentals accidentals2 = ((Melody) o).notasList.get(i).getAccidental();
            float duration2 = ((Melody) o).notasList.get(i).getDuration();

            if (duration1 == duration2) {

                if (notes1 == notes2 && accidentals1 == accidentals2) aux++;

                if (((notes1 == Notes.DO && accidentals1 == Accidentals.SHARP) && (notes2 == Notes.RE && accidentals2 == Accidentals.FLAT))
                        || ((notes1 == Notes.RE && accidentals1 == Accidentals.FLAT) && (notes2 == Notes.DO && accidentals2 == Accidentals.SHARP)))
                    aux++;

                if (((notes1 == Notes.RE && accidentals1 == Accidentals.SHARP) && (notes2 == Notes.MI && accidentals2 == Accidentals.FLAT))
                        || ((notes1 == Notes.MI && accidentals1 == Accidentals.FLAT) && (notes2 == Notes.RE && accidentals2 == Accidentals.SHARP)))
                    aux++;

                if (((notes1 == Notes.MI && accidentals1 == Accidentals.NATURAL) && (notes2 == Notes.FA && accidentals2 == Accidentals.FLAT))
                        || ((notes1 == Notes.FA && accidentals1 == Accidentals.FLAT) && (notes2 == Notes.MI && accidentals2 == Accidentals.NATURAL)))
                    aux++;

                if (((notes1 == Notes.MI && accidentals1 == Accidentals.SHARP) && (notes2 == Notes.FA && accidentals2 == Accidentals.NATURAL))
                        || ((notes1 == Notes.FA && accidentals1 == Accidentals.NATURAL) && (notes2 == Notes.MI && accidentals2 == Accidentals.SHARP)))
                    aux++;

                if (((notes1 == Notes.FA && accidentals1 == Accidentals.SHARP) && (notes2 == Notes.SOL && accidentals2 == Accidentals.FLAT))
                        || ((notes1 == Notes.SOL && accidentals1 == Accidentals.FLAT) && (notes2 == Notes.FA && accidentals2 == Accidentals.SHARP)))
                    aux++;

                if (((notes1 == Notes.SOL && accidentals1 == Accidentals.SHARP) && (notes2 == Notes.LA && accidentals2 == Accidentals.FLAT))
                        || ((notes1 == Notes.LA && accidentals1 == Accidentals.FLAT) && (notes2 == Notes.SOL && accidentals2 == Accidentals.SHARP)))
                    aux++;

                if (((notes1 == Notes.LA && accidentals1 == Accidentals.SHARP) && (notes2 == Notes.SI && accidentals2 == Accidentals.FLAT))
                        || ((notes1 == Notes.SI && accidentals1 == Accidentals.FLAT) && (notes2 == Notes.LA && accidentals2 == Accidentals.SHARP)))
                    aux++;

                if (((notes1 == Notes.SI && accidentals1 == Accidentals.NATURAL) && (notes2 == Notes.DO && accidentals2 == Accidentals.FLAT))
                        || ((notes1 == Notes.DO && accidentals1 == Accidentals.FLAT) && (notes2 == Notes.SI && accidentals2 == Accidentals.NATURAL)))
                    aux++;

                if (((notes1 == Notes.SI && accidentals1 == Accidentals.SHARP) && (notes2 == Notes.DO && accidentals2 == Accidentals.NATURAL))
                        || ((notes1 == Notes.DO && accidentals1 == Accidentals.NATURAL) && (notes2 == Notes.SI && accidentals2 == Accidentals.SHARP)))
                    aux++;
            }
        }
        return aux == notasList.size();
    }

    /**
     * Returns an integer that is a hash code representation of the melody .
     * Two melodies m1 , m2 that are equals (m1. equals (m2) == true ) must
     * have the same hash code .
     *
     * @return The hash code of this melody .
     */
    @Override
    public int hashCode() {
        int hash = 0;

        for (NotesClass notesClass : notasList){
            NoteHash noteHash = new NoteHash(notesClass);
            hash += noteHash.getHash();
        }
        return hash;
    }


    /**
     * The string representation of this melody .
     *
     * @return The String representantion of this melody .
     */
    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();

        for (NotesClass notesClass : notasList) {
            if (Objects.equals(notesClass.getAccidental().toString(), Accidentals.NATURAL.toString()))
                cadena.append(notesClass.getName().toString()).append('(').append(notesClass.getDuration()).append(')').append(" ");
            else
                if (Objects.equals(notesClass.getAccidental().toString(), Accidentals.SHARP.toString()))
                cadena.append(notesClass.getName().toString()).append('#').append('(').append(notesClass.getDuration()).append(')').append(" ");
            else
                if (Objects.equals(notesClass.getAccidental().toString(), Accidentals.FLAT.toString()))
                cadena.append(notesClass.getName().toString()).append('b').append('(').append(notesClass.getDuration()).append(')').append(" ");
        }
        cadena.setLength(cadena.length() - 1); //elimina el espacio del final
        return cadena.toString();
    }
}

