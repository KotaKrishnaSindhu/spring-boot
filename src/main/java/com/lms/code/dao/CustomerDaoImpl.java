package com.lms.code.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lms.code.entity.Company;

@Repository
@Transactional

public class CustomerDaoImpl implements CustomerDao {

	/*
	 * private SessionFactory sessionFactory;
	 * 
	 * public void setSessionFactory(SessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 * 
	 * 
	 * @Override public void save(CustomerDto c) { Session session =
	 * this.sessionFactory.openSession(); Transaction tx =
	 * session.beginTransaction(); session.persist(c); tx.commit(); session.close();
	 * 
	 * }
	 * 
	 * 
	 * @Override // @Bean public List<CustomerDto> findAll() { Session session =
	 * this.sessionFactory.openSession(); List<CustomerDto> customerList =
	 * session.createQuery("from COMPANY").list(); session.close(); return
	 * customerList;
	 * 
	 * }
	 */
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Company> getCustomersDetails() {
		String hql = "from Company company ";
		return (List<Company>) hibernateTemplate.find(hql);
	}

	public Integer addCustomers(Company company) {
		hibernateTemplate.save(company);
		return company.getCustomerId();

	}

	@Override
	public Company getCustomerDetails(Integer customerId) {
		// Customer customer = hibernateTemplate.get(Customer.class, id);
		String hql = "from Company company where company.customerId = ?";
		System.out.println(customerId);
		List<Company> list = (List<Company>) hibernateTemplate.find(hql, customerId);
		System.out.println(list);
		Company company = new Company();
		if (list.size() > 0) {
			company = list.get(0);
		}
		return company;

	}

	@Override
	public boolean updateCustomer(Company company) {
		System.out.println(company.getCustomerId());
		System.out.println(company.getCustomerName());
		System.out.println(company.getEmailId());
		hibernateTemplate.saveOrUpdate(company);
		hibernateTemplate.flush();
		return true;

	}

	@Override
	public boolean deleteCustomer(Company company) {
		/*
		 * String hql = "delete from Company company where company.customerId = ?";
		 * System.out.println(customerId); List<Company> list = (List<Company>)
		 * hibernateTemplate.find(hql, customerId); System.out.println(list); Company
		 * company = new Company(); if (list.size() > 0) { company = list.get(0); }
		 */
		hibernateTemplate.delete(company);
		return true;
	}

}
