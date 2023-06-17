package AccountManagement.model;

import PaymentManagement.context.ManagingPayment.model.Payment;

public class Teacher extends User {
	private Payment salary;
	public Teacher(int id, String name, String email, String password) {
		super(id, name, email, password);
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