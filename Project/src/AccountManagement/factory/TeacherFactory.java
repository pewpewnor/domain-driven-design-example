package AccountManagement.factory;

import AccountManagement.model.Teacher;
import PaymentManagement.factory.PaymentFactory;
import base.Factory;

public class TeacherFactory extends Factory {

	public static Teacher createTeacher(int id, String name, String email, String password, String currency,
			double balance) {
		return new Teacher(id, name, email, password, PaymentFactory.createPayment(currency, balance));
	}

}