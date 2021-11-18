package e3;

    public class NotesClass {

        private final Notes name;
        private final Accidentals accidental;
        private final float duration;

        public NotesClass(Notes name, Accidentals accidentals, float duration){
            this.name = name;
            this.accidental = accidentals;
            this.duration = duration;
        }

        public float getDuration() {
            return duration;
        }

        public Accidentals getAccidental() {
            return accidental;
        }

        public Notes getName() {
            return name;
        }
    }

