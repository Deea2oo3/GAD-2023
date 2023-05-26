public class Person {
    private String name;
    private String job;
    private String university;
    private boolean drivingLicense;
    private boolean isMarried;

    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.job = builder.job;
        this.university = builder.university;
        this.drivingLicense = builder.drivingLicense;
        this.isMarried = builder.isMarried;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getUniversity() {
        return university;
    }

    public boolean hasDrivingLicense() {
        return drivingLicense;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public static class PersonBuilder {
        private String name;
        private String job;
        private String university;
        private boolean drivingLicense;
        private boolean isMarried;

        public PersonBuilder(String name) {
            this.name = name;
        }

        public PersonBuilder setJob(String job) {
            this.job = job;
            return this;
        }

        public PersonBuilder setUniversity(String university) {
            this.university = university;
            return this;
        }

        public PersonBuilder setDrivingLicense(boolean drivingLicense) {
            this.drivingLicense = drivingLicense;
            return this;
        }

        public PersonBuilder setMarried(boolean isMarried) {
            this.isMarried = isMarried;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
