package fr.data.engineer.tp2;

public class PersonMessage {
    int id;
    String firstName;
    String lastName;
    String date;
    String vaccine;
    String sideEffectName;
    String sideEffectCode;

    public PersonMessage(String firstName, String lastName, String date, String vaccine, String sideEffectName, String sideEffectCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.vaccine = vaccine;
        this.sideEffectName = sideEffectName;
        this.sideEffectCode = sideEffectCode;
    }

    public PersonMessage() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getSideEffectName() {
        return sideEffectName;
    }

    public void setSideEffectName(String sideEffectName) {
        this.sideEffectName = sideEffectName;
    }

    public String getSideEffectCode() {
        return sideEffectCode;
    }

    public void setSideEffectCode(String sideEffectCode) {
        this.sideEffectCode = sideEffectCode;
    }

    @Override
    public String toString() {
        return "PersonMessage{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date='" + date + '\'' +
                ", vaccine='" + vaccine + '\'' +
                ", sideEffectName='" + sideEffectName + '\'' +
                ", sideEffectCode='" + sideEffectCode + '\'' +
                '}';
    }
}
