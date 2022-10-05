public class Person {
        private String name;
        private String birthdate;

        protected Person(String name, String birthdate) {
            this.name = name;
            this.birthdate = birthdate;
        }

        protected String getName() {
                return name;
        }

        protected String getBirthdate() {
                return birthdate;
        }


}
