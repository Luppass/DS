package e4;

 enum Operation {

        PLUS("+") {
            float apply(float x, float y) {
                return x + y;
            }
        },
        MINUS("-") {
            float apply(float x, float y) {
                return x - y;
            }
        },
        TIMES("*") {
            float apply(float x, float y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            float apply(float x, float y) {
                return x / y;
            }
        };

        private final String symbol;

         Operation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }
        abstract float apply(float x, float y);
    }

