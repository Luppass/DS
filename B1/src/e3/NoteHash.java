package e3;

public class NoteHash {
    private final NotesClass notesClass;
    float hash;

    public NoteHash(NotesClass notesClass){
        this.notesClass = notesClass;
    }

    public float getHash() {
        Accidentals accidental = notesClass.getAccidental();
        Notes note = notesClass.getName();
        float duration = notesClass.getDuration();

        if (note == Notes.DO){
            if (accidental == Accidentals.NATURAL) hash =  (2504 * duration);
            else if (accidental == Accidentals.FLAT) hash =  (5003 * duration);
            else if (accidental == Accidentals.SHARP) hash = (1002 * duration);
        }
        else if (note == Notes.RE){
            if (accidental == Accidentals.NATURAL) hash =  (3306* duration);
            else if (accidental == Accidentals.FLAT) hash =  (1002* duration);
            else if (accidental == Accidentals.SHARP) hash =  (9997* duration);
        }
        else if (note == Notes.MI){
            if (accidental == Accidentals.NATURAL) hash =  (4441 * duration);
            else if (accidental == Accidentals.FLAT) hash =  (9997 * duration);
            else if (accidental == Accidentals.SHARP) hash =  (8883 * duration);
        }
        else if (note == Notes.FA){
            if (accidental == Accidentals.NATURAL) hash =  (8883 * duration);
            else if (accidental == Accidentals.FLAT) hash = (4441 * duration);
            else if (accidental == Accidentals.SHARP) hash = (2227 * duration);
        }
        else if (note == Notes.SOL){
            if (accidental == Accidentals.NATURAL) hash =  (4204 * duration);
            else if (accidental == Accidentals.FLAT) hash =  (2227 * duration);
            else if (accidental == Accidentals.SHARP) hash =  (7005 * duration);
        }
        else if (note == Notes.LA){
            if (accidental == Accidentals.NATURAL) hash =  (3306 * duration);
            else if (accidental == Accidentals.FLAT) hash =  (7005 * duration);
            else if (accidental == Accidentals.SHARP) hash =  (9997 * duration);
        }
        else if (note == Notes.SI){
            if (accidental == Accidentals.NATURAL) hash =  (5003 * duration);
            else if (accidental == Accidentals.FLAT) hash =  (9997 * duration);
            else if (accidental == Accidentals.SHARP) hash = (2504 * duration);
        }
        return hash;
    }

}
