/**
 * 
 */
package com.crs.flipkart.business;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Payment;
import com.crs.flipkart.dao.PaymentDaoInterface;
import com.crs.flipkart.dao.PaymentDaoOperations;

/**
 * @author Abhinav
 *
 */
public class PaymentService implements PaymentServiceInterface {

	private static Logger logger = Logger.getLogger(PaymentService.class);
	NotificationServiceInterface notificationService = new NotificationService();
	PaymentDaoInterface paymentDao = new PaymentDaoOperations();
	RegisteredCoursesServiceInterface registerCourse = new RegisteredCoursesService();

	/*
	 * Method gives student various payment options
	 * 
	 * @param StudentId : Id of the Student
	 */
	@Override

	public boolean onlinePayment(String studentId) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Online-payment method");
		String paymentId;
		int b = (int) (Math.random() * 1000);
		paymentId = "1";
        
		double amount = 1000.00;

		Payment payment = new Payment(studentId, paymentId, "Online", amount, "77777", true);
		try {
			boolean isPaid = paymentDao.payFees(payment);
			if (isPaid) {
				String message = "Fees Has been paid with Account number  -> " + paymentId;
				registerCourse.updateStatus(studentId);
				notificationService.sendNotification(studentId, message);
			}
			return isPaid;

		} catch (Exception e) {
			throw e;
		}

	}

	public boolean offlinePayment(String studentId) {
		// TODO Auto-generated method stub
		logger.info("Offline payment mehthod");
		String paymentId;
		int b = (int) (Math.random() * 1000);
		paymentId = studentId + Integer.toString(b);

		double amount = 1000;

		Payment payment = new Payment(studentId, paymentId, "Offline", amount, "77777", true);
		try {
			boolean isPaid = paymentDao.payFees(payment);
			if (isPaid) {
				String message = "Fees Has been paid with Account number  -> " + paymentId;
				registerCourse.updateStatus(studentId);
				notificationService.sendNotification(studentId, message);

			}

			return isPaid;

		} catch (Exception e) {
			throw e;
		}

	}
}
