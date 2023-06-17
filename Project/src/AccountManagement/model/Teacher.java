package AccountManagement.model;

import PaymentManagement.model.Payment;

public class Teacher extends User {
    private Payment salary;

    public Teacher(int id, String name, String email, String password, Payment payment) {
        super(id, name, email, password);
        this.salary = payment;
    }

    /**
     * @return Payment return the salary
     */
    public Payment getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(Payment salary) {
        this.salary = salary;
    }

}